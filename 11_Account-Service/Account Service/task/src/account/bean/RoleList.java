package account.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class RoleList {
    @Bean
    public Set<String> RoleList() {
        return Set.of(
                "ROLE_USER",
                "ROLE_ACCOUNTANT",
                "ROLE_ADMINISTRATOR",
                "ROLE_AUDITOR"
        );
    }
}