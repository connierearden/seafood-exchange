package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seafoodexchange.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
