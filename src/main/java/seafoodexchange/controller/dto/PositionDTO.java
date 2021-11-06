package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionDTO {

    @JsonProperty("date_start")
    private String dateStart;

    @JsonProperty("date_finish")
    private String dateFinish;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("price_for_kilogram")
    private int priceForKilogram;

    private int boxes;

    @JsonProperty("box_weight")
    private int boxWeight;


}
