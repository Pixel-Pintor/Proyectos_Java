package account.repository;

import account.model.Payment;
import account.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    boolean existsByUserAndPeriod(User user, YearMonth period);
    Payment findByUserAndPeriod(User user, YearMonth period);
    List<Payment> getByUserOrderByPeriodDesc(User user);
}