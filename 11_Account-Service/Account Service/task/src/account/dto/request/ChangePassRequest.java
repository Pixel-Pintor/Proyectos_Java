package account.dto.request;

import account.annotation.BreachedPasswordCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassRequest {
    @Pattern(regexp = "[\\da-zA-Z]{12,}", message = "Password length must be 12 chars minimum!")
    @BreachedPasswordCheck
    private String new_password;
}