package seafoodexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seafoodexchange.repository.GrowerRepository;

@Service
public class GrowerService {
    @Autowired
    private GrowerRepository growerRepository;

}
