package seafoodexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seafoodexchange.model.Grower;
import seafoodexchange.repository.GrowerRepository;

import java.util.List;

@Service
public class GrowerService {
    @Autowired
    private GrowerRepository growerRepository;

    public void createGrower (Grower grower) {
        growerRepository.save(grower);
    }

    public Grower getGrowerById(Long growerId) {
        return growerRepository.getById(growerId);
    }

    public List<Grower> getAllGrowers() {
        return growerRepository.findAll();
    }
}
