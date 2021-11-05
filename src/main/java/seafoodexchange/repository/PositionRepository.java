package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import seafoodexchange.model.Position;
import seafoodexchange.model.Product;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("from Position p where p.grower.id = :growerId")
    List<Position> getGrowerPositionsById(Long growerId);
}
