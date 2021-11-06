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
    private String type;

    @JsonProperty("fish_family")
    private String fishFamily;

    @JsonProperty("cooling_type")
    private String coolingType;

    private String name;

    public ProductDTO (Product prod) {
        type = prod.getType();
        fishFamily = prod.getFishFamily();
        coolingType = prod.getCoolingType();
        name = prod.getName();
    }
}
