package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import seafoodexchange.model.Product;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("produced_in")
    private String producedIn;

    @JsonProperty("add_info")
    private String addInfo;

    public ProductDTO(Product p) {
        this.name = p.getName();
        this.producedIn = p.getProducedIn();
        this.addInfo = p.getAddInfo();
    }
}
