package account.annotation;

import account.validator.BreachedPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BreachedPasswordValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@ReportAsSingleViolation
public @interface BreachedPasswordCheck {
    String message() default "The password is in the hacker's database!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}