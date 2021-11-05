package seafoodexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.ProductDTO;
import seafoodexchange.model.Product;
import seafoodexchange.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //test +
    @GetMapping
    public List<ProductDTO> getAll () {
        return productService.getAllProducts().stream()
                .map(ProductDTO::new).collect(Collectors.toList());
    }

    //test +
    @GetMapping("/{prodId}")
    public ProductDTO getById (@PathVariable Long prodId) {
        return new ProductDTO(productService.getProductById(prodId));
    }

    //test +
    @PostMapping
    public String create (@RequestBody ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .addInfo(productDTO.getAddInfo())
                .producedIn(productDTO.getProducedIn())
                .build();
        productService.createProduct(product);
        return "Success";
    }

}
