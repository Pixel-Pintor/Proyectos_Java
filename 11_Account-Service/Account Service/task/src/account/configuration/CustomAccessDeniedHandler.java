package account.configuration;

import account.model.EventEnum;
import account.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private final LogService logService;

    @Autowired
    public CustomAccessDeniedHandler(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        logService.handleAccessDenied();
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied!");
    }
}