package account.component;

import account.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationSuccessEventListener implements
        ApplicationListener<AuthenticationSuccessEvent> {
    private LogService logService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        logService.handleSuccessLogin();
    }
}