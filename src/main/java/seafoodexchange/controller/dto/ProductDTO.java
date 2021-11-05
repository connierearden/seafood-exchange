package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Product;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
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
