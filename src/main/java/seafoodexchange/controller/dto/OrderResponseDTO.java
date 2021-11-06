package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Order;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDTO {
    @JsonProperty("date_create")
    private String dateCreate;

    private CustomerDTO customer;
    private CompanyDTO company;
    private ProductDTO product;

    @JsonProperty("price_for_kilogram")
    private int priceForKilogram;
    private int boxes;

    @JsonProperty("box_weight")
    private int boxWeight;

    private String status;
    private String sentTo;

    public OrderResponseDTO (Order o) {
        dateCreate = o.getDateCreate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        customer = new CustomerDTO(o.getCustomer());
        company = new CompanyDTO(o.getCompany());
        product = new ProductDTO(o.getProduct());
        priceForKilogram = o.getPriceForKilogram();
        boxes = o.getBoxes();
        boxWeight = o.getBoxWeight();
        status = o.getStatus();
        sentTo = o.getSentTo();

    }
}
