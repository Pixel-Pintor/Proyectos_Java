package account.dto.response;

import account.constants.Regexp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    @NotBlank
    @Pattern(regexp = Regexp.EMPLOYEE_EMAIL)
    private String employee;

    @NotBlank
    @Pattern(regexp = Regexp.PAYMENT_PERIOD)
    private String period;

    @Positive
    private Long salary;

    public PaymentDto(String name, String lastname, String strPeriod, String strSalary) {
    }
}