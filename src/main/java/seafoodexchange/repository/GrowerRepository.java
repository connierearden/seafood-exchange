package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seafoodexchange.model.Grower;
import seafoodexchange.model.Product;

public interface GrowerRepository extends JpaRepository<Grower, Long> {
}
