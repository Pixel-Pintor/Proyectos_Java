package account.validator;

import account.annotation.BreachedPasswordCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class BreachedPasswordValidator implements ConstraintValidator<BreachedPasswordCheck, String> {
    private final List<String> listBreachedPasswords;
    public BreachedPasswordValidator(@Autowired List<String> listBreachedPasswords) {
        this.listBreachedPasswords = listBreachedPasswords;
    }

    @Override
    public void initialize(BreachedPasswordCheck constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !listBreachedPasswords.contains(value);
    }
}