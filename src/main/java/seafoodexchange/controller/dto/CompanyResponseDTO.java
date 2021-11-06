package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Company;

@Getter
@Setter
@NoArgsConstructor
public class CompanyResponseDTO {

    private String name;

    private String location;

    private Double balance;

    @JsonProperty("position_count")
    private int positionCount;

    @JsonProperty("order_count")
    private int orderCount;

    public CompanyResponseDTO (Company company) {
        name = company.getName();
        location = company.getLocation();
        balance = company.getBalance();
        positionCount = company.getPositions().size();
        orderCount = company.getOrders().size();
    }
}
