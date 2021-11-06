package seafoodexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seafoodexchange.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
