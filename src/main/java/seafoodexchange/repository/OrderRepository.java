package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import seafoodexchange.controller.dto.OrderResponseDTO;
import seafoodexchange.model.Order;

import java.util.List;

public interface OrderRepository  extends JpaRepository<Order, Long> {
    @Query("from Order o where o.customer.id = : customId")
    List<Order> getAllByCustomerId(Long customId);

    @Query("from Order o where o.company.id = : coId")
    List<Order> getAllByCompanyId(Long coId);

}
