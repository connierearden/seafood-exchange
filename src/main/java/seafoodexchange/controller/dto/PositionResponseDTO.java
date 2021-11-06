package seafoodexchange.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Company;
import seafoodexchange.model.Position;
import seafoodexchange.model.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class PositionResponseDTO {

    @JsonProperty("date_start")
    private String dateStart;

    @JsonProperty("date_finish")
    private String dateFinish;

    private CompanyDTO company;

    private ProductDTO product;

    @JsonProperty("price_for_kilogram")
    private int priceForKilogram;

    private int boxes;

    @JsonProperty("box_weight")
    private int boxWeight;

    public PositionResponseDTO(Position position) {
        dateStart = position.getDateStart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        dateFinish = position.getDateFinish().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        company = new CompanyDTO(position.getCompany());
        product = new ProductDTO(position.getProduct());
        priceForKilogram = position.getPriceForKilogram();
        boxes = position.getBoxes();
        boxWeight = position.getBoxWeight();
    }


}
