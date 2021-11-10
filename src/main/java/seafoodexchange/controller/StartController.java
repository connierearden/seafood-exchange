package seafoodexchange.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import seafoodexchange.model.Company;
import seafoodexchange.model.Position;
import seafoodexchange.model.Product;
import seafoodexchange.model.enums.CoolingType;
import seafoodexchange.model.enums.TypeProduct;
import seafoodexchange.service.CompanyService;
import seafoodexchange.service.PositionService;
import seafoodexchange.service.ProductService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@AllArgsConstructor
public class StartController {

    private ProductService productService;
    private CompanyService companyService;
    private PositionService positionService;

    @GetMapping
    public String fillDataIn() {
        StringBuilder sb = new StringBuilder();
        sb.append(createProducts());
        sb.append(createCompanies());
        sb.append(createPositions());
        sb.append(createCustomers());
        sb.append(createOrders());

        return sb.toString();
    }

    public String createProducts() {
        String answer = "Operation does not perform\n";

        List<String> salmonFish = List.of("Форель", "Горбуша", "Кета", "Нельма", "Кижуч", "Чавыча", "Кумжа", "Сиг", "Омуль", "Хариус", "Таймень", "Ленок");
        Map<String, String> fishNameAndFamily = new HashMap<>();

        List.of("Форель", "Горбуша", "Кета", "Нельма", "Кижуч", "Чавыча", "Кумжа", "Сиг", "Омуль", "Хариус", "Таймень", "Ленок")
                .forEach( name -> fishNameAndFamily.put(name, "Лососевые"));
        List.of("Осетр", "Севрюга", "Стерлядь", "Белуга", "Шип").forEach( name -> fishNameAndFamily.put(name, "Осетровые"));
        List.of("Судак", "Окунь", "Ёрш").forEach( name -> fishNameAndFamily.put(name, "Окуневые"));
        List.of("Сельдь", "Сардины", "Шпроты").forEach( name -> fishNameAndFamily.put(name, "Сельдевые"));

        if (productService.getAllProducts().isEmpty()) {
            fishNameAndFamily.forEach((k, v) ->
                    productService.createProduct(Product.builder()
                            .type(TypeProduct.FISH)
                            .fishFamily(v)
                            .coolingType(CoolingType.values()[new Random().nextInt(3)])
                            .name(k)
                            .build()));
            answer = "Products are added\n";
        }
        return answer;
    }

    public String createCompanies() {
        String answer = "Operation does not perform";
        Map<String, String> companyNameAndLocation = new HashMap<>();
        companyNameAndLocation.put("Рыба и хозяева", "Москва");
        companyNameAndLocation.put("Рыбный лов", "Волгоград");
        companyNameAndLocation.put("Рыба-север", "Мурманск");
        companyNameAndLocation.put("Рыболовы", "Самара");

        if (companyService.getAllCompanies().isEmpty()) {
            companyNameAndLocation.forEach((k,v) -> companyService.createCompany(Company.builder()
                    .name(k).location(v).balance(0d).build()));
            answer = "Companies are added\n";
        }
        return answer;
    }

    public String createPositions() {
        String answer = "";
        if (positionService.getAllPositions().isEmpty()) {
            positionService.createPosition(
                    new Position(null, LocalDateTime.of(2021, 11, 10, 14, 20),
                            LocalDateTime.of(2021, 11, 15, 14, 20),
                            null, null, 800, 5, 4));

            answer = "Position are added\n";
        }
        return answer;
    }

    public String createCustomers() {
        //create 5 customers
        return null;
    }

    public String createOrders() {
        //create 5 orders
        return null;
    }

}
