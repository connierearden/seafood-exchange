package seafoodexchange.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import seafoodexchange.model.Company;

@Getter
@Setter
public class CompanyDTO {
    private String name;
    private String location;

    public CompanyDTO(Company company) {
        name = company.getName();
        location = company.getLocation();
    }
}
