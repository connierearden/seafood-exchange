package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seafoodexchange.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
