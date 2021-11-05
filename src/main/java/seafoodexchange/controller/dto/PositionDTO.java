package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Position;

@Getter
@Setter
@NoArgsConstructor
public class PositionDTO {
    @JsonProperty("grower_id")
    private Long growerId;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("kilo")
    private Integer kilograms;

    public PositionDTO (Position p) {
        growerId = p.getGrower().getId();
        productId = p.getProduct().getId();
        kilograms = p.getKilograms();
    }

}
