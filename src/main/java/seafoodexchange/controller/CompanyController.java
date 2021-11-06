package seafoodexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.CompanyRequestDTO;
import seafoodexchange.controller.dto.CompanyResponseDTO;
import seafoodexchange.model.Company;
import seafoodexchange.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    //test -
    @GetMapping("/{id}")
    public CompanyResponseDTO getById(@PathVariable Long id) {
        return null;
    }

    //test -
    @GetMapping
    public List<CompanyResponseDTO> getAll() {
        return null;
    }

    //test -
    @PostMapping
    public String create(@RequestBody CompanyRequestDTO companyRequestDTO) {
        Company company = Company.builder()
                .name(companyRequestDTO.getName())
                .location(companyRequestDTO.getLocation())
                .positions(List.of())
                .balance(0d)
                .build();
        companyService.createCompany(company);
        return "Success";
    }
}
