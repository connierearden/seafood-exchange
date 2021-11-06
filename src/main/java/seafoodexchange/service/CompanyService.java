package seafoodexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seafoodexchange.model.Company;
import seafoodexchange.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void createCompany (Company company) {
        companyRepository.save(company);
    }

    public Company getCompanyById(Long companyId) {
        return companyRepository.getById(companyId);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
