package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seafoodexchange.model.Order;

public interface OrderRepository  extends JpaRepository<Order, Long> {
}
