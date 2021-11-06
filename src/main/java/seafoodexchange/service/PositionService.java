package seafoodexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seafoodexchange.model.Position;
import seafoodexchange.repository.PositionRepository;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public void createPosition(Position position) {
        positionRepository.save(position);
    }

    public List<Position> getCompanyPositionsById(Long companyId) {
        return positionRepository.getCompanyPositionsById(companyId);
    }
}
