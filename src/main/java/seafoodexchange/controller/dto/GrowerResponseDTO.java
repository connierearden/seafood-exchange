package seafoodexchange.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seafoodexchange.model.Grower;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class GrowerResponseDTO {

    private String name;
    private String country;
    private List<PositionDTO> positions;
    private Double balance;

    public GrowerResponseDTO (Grower g) {
        this.name = g.getName();
        this.country = g.getCountry();
        this.positions = g.getPositions()
                .stream().map(PositionDTO::new)
                .collect(Collectors.toList());
        this.balance = g.getBalance();
    }
}
