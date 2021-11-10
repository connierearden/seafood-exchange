package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Customer;

@Getter
@Setter
@NoArgsConstructor
public class CustomerResponseDTO {
    private String name;

    private String location;

    private Double balance;

    @JsonProperty("order_size")
    private Integer orderSize;

    public CustomerResponseDTO(Customer customer) {
        name = customer.getName();
        location = customer.getLocation();
        balance = customer.getBalance();
        orderSize = customer.getOrders().size();
    }
}
