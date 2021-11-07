package seafoodexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seafoodexchange.model.Company;
import seafoodexchange.model.Position;
import seafoodexchange.model.Product;
import seafoodexchange.model.enum_pack.CoolingType;
import seafoodexchange.model.enum_pack.TypeProduct;
import seafoodexchange.service.CompanyService;
import seafoodexchange.service.PositionService;
import seafoodexchange.service.ProductService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api")
public class StartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PositionService positionService;

    @GetMapping("/products")
    public String createProducts() {
        if (productService.getAllProducts().isEmpty()) {
            productService.createProduct(new Product(10L, TypeProduct.FISH, "Лососевые", CoolingType.LIVE, "Семга", null, null));
            productService.createProduct(new Product(11L, TypeProduct.FISH, "Лососевые", CoolingType.LIVE, "Форель", null, null));
            productService.createProduct(new Product(12L, TypeProduct.FISH, "Лососевые", CoolingType.LIVE, "Горбуша", null, null));
            productService.createProduct(new Product(13L, TypeProduct.FISH, "Лососевые", CoolingType.CHILLED, "Кета", null, null));
            productService.createProduct(new Product(14L, TypeProduct.FISH, "Лососевые", CoolingType.CHILLED, "Нельма", null, null));
            productService.createProduct(new Product(15L, TypeProduct.FISH, "Лососевые", CoolingType.CHILLED, "Кижуч", null, null));
            productService.createProduct(new Product(16L, TypeProduct.FISH, "Лососевые", CoolingType.FROZEN, "Чавыча", null, null));
            productService.createProduct(new Product(17L, TypeProduct.FISH, "Лососевые", CoolingType.FROZEN, "Кумжа", null, null));
            productService.createProduct(new Product(18L, TypeProduct.FISH, "Лососевые", CoolingType.FROZEN, "Сиг", null, null));
            productService.createProduct(new Product(19L, TypeProduct.FISH, "Лососевые", CoolingType.CHILLED, "Омуль", null, null));
            productService.createProduct(new Product(20L, TypeProduct.FISH, "Лососевые", CoolingType.FROZEN, "Хариус", null, null));
            productService.createProduct(new Product(21L, TypeProduct.FISH, "Лососевые", CoolingType.CHILLED, "Таймень", null, null));
            productService.createProduct(new Product(22L, TypeProduct.FISH, "Лососевые", CoolingType.LIVE, "Ленок", null, null));
            productService.createProduct(new Product(23L, TypeProduct.FISH, "Осетровые", CoolingType.LIVE, "Осетр", null, null));
            productService.createProduct(new Product(24L, TypeProduct.FISH, "Осетровые", CoolingType.FROZEN, "Севрюга", null, null));
            productService.createProduct(new Product(25L, TypeProduct.FISH, "Осетровые", CoolingType.FROZEN, "Стерлядь", null, null));
            productService.createProduct(new Product(26L, TypeProduct.FISH, "Осетровые", CoolingType.LIVE, "Белуга", null, null));
            productService.createProduct(new Product(27L, TypeProduct.FISH, "Осетровые", CoolingType.CHILLED, "Шип", null, null));
            productService.createProduct(new Product(28L, TypeProduct.FISH, "Окуневые", CoolingType.CHILLED, "Судак", null, null));
            productService.createProduct(new Product(29L, TypeProduct.FISH, "Окуневые", CoolingType.FROZEN, "Окунь", null, null));
            productService.createProduct(new Product(30L, TypeProduct.FISH, "Окуневые", CoolingType.CHILLED, "Ёрш", null, null));
            productService.createProduct(new Product(31L, TypeProduct.FISH, "Сельдевые", CoolingType.CHILLED, "Сельдь", null, null));
            productService.createProduct(new Product(32L, TypeProduct.FISH, "Сельдевые", CoolingType.CHILLED, "Сардины", null, null));
            productService.createProduct(new Product(33L, TypeProduct.FISH, "Сельдевые", CoolingType.LIVE, "Шпроты", null, null));
        }
        return "Products are added";
    }

    @GetMapping("/companies")
    public String createCompanies() {
        if (companyService.getAllCompanies().isEmpty()) {
            companyService.createCompany(new Company(0L, "Рыба и хозяева", "Москва", null, null, 0D));
            companyService.createCompany(new Company(1L, "Рыбный лов", "Волгоград", null, null, 0D));
            companyService.createCompany(new Company(2L, "Рыба-север", "Мурманск", null, null, 0D));
            companyService.createCompany(new Company(3L, "Рыболовы", "Самара", null, null, 0D));
        }
        return "Companies are added";
    }

    @GetMapping("/positions")
    public String createPositions() {
        if (positionService.getAllPositions().isEmpty()) {
            positionService.createPosition(new Position(0L, LocalDateTime.of(2021, 11, 10, 14, 20),
                    LocalDateTime.of(2021, 11, 15, 14, 20), null, null, 800, 5, 4));
            positionService.createPosition(new Position(1L, LocalDateTime.of(2021, 11, 20, 15, 30),
                    LocalDateTime.of(2021, 11, 25, 15, 30), null, null, 700, 4, 3));
            positionService.createPosition(new Position(2L, LocalDateTime.of(2021, 12, 8, 19, 15),
                    LocalDateTime.of(2021, 12, 12, 18, 15), null, null, 600, 7, 2));
        }
        return "Positions are added";
    }
}
