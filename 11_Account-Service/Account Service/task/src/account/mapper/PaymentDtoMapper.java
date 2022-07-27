package account.mapper;

import account.dto.response.PaymentDto;
import account.model.Payment;
import account.model.User;

import java.text.DateFormatSymbols;

public class PaymentDtoMapper {
    public static PaymentDto mapping(Payment payment) {
        User user = payment.getUser();

        String strSalary;
        strSalary = String.format("%s dollar(s) %s cent(s)", payment.getSalary() / 100, payment.getSalary() % 100);

        String strMonth = new DateFormatSymbols().getMonths()[payment.getPeriod().getMonth().getValue() - 1];
        String strPeriod = String.format("%s-%s", strMonth, payment.getPeriod().getYear());

        return new PaymentDto(user.getName(), user.getLastname(), strPeriod, strSalary);
    }
}