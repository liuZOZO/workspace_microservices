package inside_payment.repository;

import inside_payment.domain.Balance;
import inside_payment.domain.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface PaymentRepository extends CrudRepository<Payment,UUID> {
}
