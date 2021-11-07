package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Product;
import seafoodexchange.model.enum_pack.CoolingType;
import seafoodexchange.model.enum_pack.TypeProduct;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private TypeProduct type;

    @JsonProperty("fish_family")
    private String fishFamily;

    @JsonProperty("cooling_type")
    private CoolingType coolingType;

    private String name;

    public ProductDTO (Product prod) {
        type = prod.getType();
        fishFamily = prod.getFishFamily();
        coolingType = prod.getCoolingType();
        name = prod.getName();
    }
}
