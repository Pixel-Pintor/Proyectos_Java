package account.configuration;

import account.model.EventEnum;
import account.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final LogService logService;

    @Autowired
    public RestAuthenticationEntryPoint(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logService.handleFailedLogin();
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}