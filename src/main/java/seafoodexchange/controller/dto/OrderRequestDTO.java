package seafoodexchange.controller.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDTO {
    @JsonProperty("customer_id")
    private Long customerId;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("position_id")
    private Long positionId;

    @JsonProperty("price_for_kilogram")
    private int priceForKilogram;
    private int boxes;

    @JsonProperty("box_weight")
    private int boxWeight;
    private String status;
    private String sentTo;
}
