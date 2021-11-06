package seafoodexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class PositionController {
    @Autowired
    private PositionService positionService;

    @Autowired
    private CompanyService companyService;

    @Autowired
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

    public static void main(String[] args) {
        String dateStart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(dateStart);
    }


}
