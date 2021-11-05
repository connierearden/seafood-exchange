package seafoodexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.GrowerRequestDTO;
import seafoodexchange.controller.dto.GrowerResponseDTO;
import seafoodexchange.model.Grower;
import seafoodexchange.service.GrowerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("grower")
public class GrowerController {
    @Autowired
    private GrowerService growerService;

    //test +
    @GetMapping("/{id}")
    public GrowerResponseDTO getById(@PathVariable Long id) {
        return new GrowerResponseDTO(growerService.getGrowerById(id));
    }

    //test +
    @GetMapping
    public List<GrowerResponseDTO> getAll() {
        return growerService.getAllGrowers().stream()
                .map(GrowerResponseDTO::new).collect(Collectors.toList());
    }

    //test +
    @PostMapping
    public String create(@RequestBody GrowerRequestDTO growerRequestDTO) {
        Grower grower = Grower.builder()
                .name(growerRequestDTO.getName())
                .country(growerRequestDTO.getCountry())
                .positions(List.of())
                .balance(0d)
                .build();
        growerService.createGrower(grower);
        return "Success";
    }
}
