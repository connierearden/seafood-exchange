package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import seafoodexchange.model.Position;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("from Position p where p.company.id = :coId")
    List<Position> getAllByCompanyId(Long coId);
}
