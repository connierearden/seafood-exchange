package seafoodexchange.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.CompanyDTO;
import seafoodexchange.controller.dto.CompanyResponseDTO;
import seafoodexchange.model.Company;
import seafoodexchange.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("companies")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    //test +
    @GetMapping("/{companyId}")
    public CompanyResponseDTO getById(@PathVariable Long companyId) {
        return new CompanyResponseDTO(companyService.getCompanyById(companyId));
    }

    //test +
    @GetMapping
    public List<CompanyResponseDTO> getAll() {
        return companyService.getAllCompanies().stream()
                .map(CompanyResponseDTO::new).collect(Collectors.toList());
    }

    //test +
    @PostMapping
    public String create(@RequestBody CompanyDTO companyRequestDTO) {
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
