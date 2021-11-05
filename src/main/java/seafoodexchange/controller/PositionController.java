package seafoodexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.PositionDTO;
import seafoodexchange.model.Position;
import seafoodexchange.service.GrowerService;
import seafoodexchange.service.PositionService;
import seafoodexchange.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("position")
public class PositionController {

    private PositionService positionService;
    private GrowerService growerService;
    private ProductService productService;

    @Autowired
    public PositionController(PositionService positionService, GrowerService growerService, ProductService productService) {
        this.positionService = positionService;
        this.growerService = growerService;
        this.productService = productService;
    }

    //test +
    @PostMapping
    public String create(@RequestBody PositionDTO positionDTO) {
        positionService.createPosition(Position.builder()
                    .grower(growerService.getGrowerById(positionDTO.getGrowerId()))
                    .product(productService.getProductById(positionDTO.getProductId()))
                    .kilograms(positionDTO.getKilograms())
                    .build());
        return "Success";
    }

    //test +
    @GetMapping("/grower_id={growerId}")
    public List<PositionDTO> getGrowerPositions(@PathVariable Long growerId) {
        return positionService.getGrowerPositionsById(growerId)
                .stream().map(PositionDTO::new).collect(Collectors.toList());
    }
}
