package account.service;

import account.component.AttemptCounter;
import account.component.DecodeBase64;
import account.model.EventEnum;
import account.model.LogEvent;
import account.model.Role;
import account.model.User;
import account.repository.LogEventRepository;
import account.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LogService {
    private final int MAX_ATTEMPT = 5;
    private LogEventRepository logEventRepository;
    private DecodeBase64 decodeBase64;
    private HttpServletRequest request;
    private UserRepository userRepository;

    public void handleFailedLogin() {
        final String uri = request.getRequestURI();
//        final String ip = request.getRemoteAddr();
        String email = getEmailFromHeader();
        if (email != null) {
            // check user is active or not
            User user = userRepository.findByEmailIgnoreCase(email);
            if (user != null && !user.isActive()) return;

            log(EventEnum.LOGIN_FAILED, email, request.getRequestURI(), request.getRequestURI());
            handleAttemptLogin(email, uri);
        }
    }

    public void handleAccessDenied() {
        String email = getEmailFromHeader();
        if (email != null) log(EventEnum.ACCESS_DENIED, email, request.getRequestURI(), request.getRequestURI());
    }

    public void handleSuccessLogin() {
        // set attempt = 0
        String email = getEmailFromHeader();
        if (email != null) {
            AttemptCounter attemptCounter = AttemptCounter.getInstance();
            attemptCounter.set(email, 0);
        }
    }

    private String getEmailFromHeader() {
        String authorization = request.getHeader("authorization");
        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
            String credentials = decodeBase64.decode(authorization.substring("Basic".length()).trim());
            final String[] values = credentials.split(":", 2);
            return values[0];
        }
        return null;
    }

    private void handleAttemptLogin(String email, String uri) {
        AttemptCounter attemptCounter = AttemptCounter.getInstance();
        int attempt = attemptCounter.get(email);
        attempt++;
        if (attempt >= MAX_ATTEMPT) {
            log(EventEnum.BRUTE_FORCE, email, uri, uri);
            lockUser(email, uri);
            attemptCounter.set(email, 0);
            return;
        }
        attemptCounter.set(email, attempt);
    }

    private void lockUser(String email, String uri) {
        User user = userRepository.findByEmailIgnoreCase(email);
        if (user != null && !isAdministrator(user)) {
            user.setActive(false);
            userRepository.save(user);
            log(EventEnum.LOCK_USER, email, String.format("Lock user %s", email), uri);
        }
    }

    private boolean isAdministrator(User user) {
        for (Role role :
                user.getRoles()) {
            if (role.getName().equals("ROLE_ADMINISTRATOR")) return true;
        }
        return false;
    }

    public void log(EventEnum event, String subject, String object, String path) {
        logEventRepository.save(new LogEvent(LocalDate.now(), event.name(), subject, object, path));
    }

    public List<LogEvent> getLogs() {
        return (List<LogEvent>) logEventRepository.findAll();
    }
}