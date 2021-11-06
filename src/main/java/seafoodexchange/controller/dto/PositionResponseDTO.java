package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Company;
import seafoodexchange.model.Position;
import seafoodexchange.model.Product;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PositionResponseDTO {

    @JsonProperty("date_start")
    private LocalDateTime dateStart;

    @JsonProperty("date_finish")
    private LocalDateTime dateFinish;

    private CompanyDTO company;

    private ProductDTO product;

    @JsonProperty("price_for_kilogram")
    private int priceForKilogram;

    private int boxes;

    @JsonProperty("box_weight")
    private int boxWeight;

    public PositionResponseDTO(Position position) {
        dateStart = position.getDateStart();
        dateFinish = position.getDateFinish();
        company = new CompanyDTO(position.getCompany());
        product = new ProductDTO(position.getProduct());
        priceForKilogram = position.getPriceForKilogram();
        boxes = position.getBoxes();
        boxWeight = position.getBoxWeight();
    }


}
