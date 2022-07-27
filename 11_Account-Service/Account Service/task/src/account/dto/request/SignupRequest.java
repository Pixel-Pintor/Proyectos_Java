package account.dto.request;

import account.annotation.BreachedPasswordCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String lastname;
    @NotNull
    @Email(regexp = ".+@acme.com", message = "Invalid email")
    private String email;
    @Pattern(regexp = "[\\da-zA-Z]{12,}", message = "Password length must be 12 chars minimum!")
    @BreachedPasswordCheck
    private String password;
}