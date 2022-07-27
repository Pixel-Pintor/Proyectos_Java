package account.service;

import account.component.CurrentUser;
import account.dto.request.UploadPayrollRequest;
import account.model.Payment;
import account.model.User;
import account.repository.PaymentRepository;
import account.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.YearMonth;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;
    private UserRepository userRepository;

    @Transactional
    public void uploadPayroll(List<UploadPayrollRequest> payments) {
        for (UploadPayrollRequest payment :
                payments) {
            User user = userRepository.findByEmailIgnoreCase(payment.getEmployee());
            if (user == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

            if (hasPaymentContainsPeriod(user, payment.getPeriod())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

            Payment newPayment = new Payment();
            newPayment.setPeriod(payment.getPeriod());
            newPayment.setSalary(payment.getSalary());
            newPayment.setUser(user);

            paymentRepository.save(newPayment);
        }
    }

    public void updatePayment(UploadPayrollRequest payment) {
        User user = getUserPayment(payment.getEmployee());

        Payment p = paymentRepository.findByUserAndPeriod(user, payment.getPeriod());
        if (p == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        p.setSalary(payment.getSalary());
        paymentRepository.save(p);
    }

    public Payment findPayment(User user, YearMonth period) {
        return paymentRepository.findByUserAndPeriod(user, period);
    }

    public List<Payment> findPayment(User user) {
        return paymentRepository.getByUserOrderByPeriodDesc(user);
    }

    public boolean hasPaymentContainsPeriod(User user, YearMonth period) {
        return paymentRepository.existsByUserAndPeriod(user, period);
    }

    private User getUserPayment(String email) {
        User user = userRepository.findByEmailIgnoreCase(email);
        if (user == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return user;
    }
}