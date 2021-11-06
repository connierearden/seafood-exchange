package seafoodexchange.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.PositionDTO;
import seafoodexchange.controller.dto.PositionResponseDTO;
import seafoodexchange.model.Position;
import seafoodexchange.service.CompanyService;
import seafoodexchange.service.PositionService;
import seafoodexchange.service.ProductService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("positions")
@AllArgsConstructor
public class PositionController {

    private PositionService positionService;
    private CompanyService companyService;
    private ProductService productService;

    //test +
    @PostMapping
    public String create(@RequestBody PositionDTO positionDTO) {
        positionService.createPosition(
                Position.builder()
                        .dateStart(LocalDateTime.parse(positionDTO.getDateStart(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                        .dateFinish(LocalDateTime.parse(positionDTO.getDateFinish(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                        .company(companyService.getCompanyById(positionDTO.getCompanyId()))
                        .product(productService.getProductById(positionDTO.getProductId()))
                        .priceForKilogram(positionDTO.getPriceForKilogram())
                        .boxes(positionDTO.getBoxes())
                        .boxWeight(positionDTO.getBoxWeight())
                        .build());
        return "Success";
    }

    //test +
    @GetMapping
    public List<PositionResponseDTO> getAll() {
        return positionService.getAllPositions().stream()
                .map(PositionResponseDTO::new).collect(Collectors.toList());
    }

    //test +
    @GetMapping("/{id}")
    public PositionResponseDTO getById(@PathVariable Long id) {
        return new PositionResponseDTO(positionService.getPositionById(id));
    }

    //test +
    @GetMapping("/company_id={coId}")
    public List<PositionResponseDTO> getAllByCompanyId (@PathVariable Long coId) {
        return positionService.getPositionsByCompanyId(coId).stream()
                .map(PositionResponseDTO::new).collect(Collectors.toList());
    }


}
