package account.controller;

import account.component.CurrentUser;
import account.component.StringToLocalDateConverter;
import account.mapper.PaymentDtoMapper;
import account.model.Payment;
import account.model.User;
import account.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/api/empl")
public class EmployeeController {
    private final PaymentService paymentService;
    private final CurrentUser currentUser;

    public EmployeeController(PaymentService paymentService, CurrentUser currentUser) {
        this.paymentService = paymentService;
        this.currentUser = currentUser;
    }

    @GetMapping("/payment")
    public ResponseEntity<?> findByPeriod(
            @RequestParam(name = "period", required = false) String strPeriod
    ) {
        if (currentUser.getCurrentUser().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        User user = currentUser.getCurrentUser().get().getUser();

        if (strPeriod != null) {
            YearMonth period = StringToLocalDateConverter.convert(strPeriod);
            Payment payment = paymentService.findPayment(user, period);
            return ResponseEntity.ok().body(PaymentDtoMapper.mapping(payment));
        } else {
            List<Payment> payments = paymentService.findPayment(user);
            return ResponseEntity.ok().body(
                    payments.stream().map(PaymentDtoMapper::mapping).collect(Collectors.toList())
            );
        }

    }
}