package seafoodexchange.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Customer;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private String name;

    private String location;

    public CustomerDTO(Customer customer) {
        name = customer.getName();
        location = customer.getLocation();
    }
}
