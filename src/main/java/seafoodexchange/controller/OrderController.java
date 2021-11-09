package seafoodexchange.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.OrderRequestDTO;
import seafoodexchange.controller.dto.OrderResponseDTO;
import seafoodexchange.model.Order;
import seafoodexchange.service.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private CustomerService customerService;
    private CompanyService companyService;
    private ProductService productService;
    private PositionService positionService;

    //test -
    @PostMapping
    public String create(@RequestBody OrderRequestDTO orderRequestDTO) {
        //логика для определения статуса заказа -- создать для этого метод сервиса
        String status = orderService.setOrderStatus (orderRequestDTO);
        orderService.createOrder(
                Order.builder()
                        .dateCreate(LocalDateTime.now())
                        .customer(customerService.getCustomById(orderRequestDTO.getCustomerId()))
                        .company(companyService.getCompanyById(orderRequestDTO.getCompanyId()))
                        .product(positionService.getPositionById(orderRequestDTO.getPositionId()).getProduct())
                        .priceForKilogram(orderRequestDTO.getPriceForKilogram())
                        .boxes(orderRequestDTO.getBoxes())
                        .boxWeight(orderRequestDTO.getBoxWeight())
                        .status(null)
                        .sentTo(null)
                        .build());
        return "Success";
    }

    //test -
    @GetMapping("{id}")
    public OrderResponseDTO getById(@PathVariable Long id) {
        return new OrderResponseDTO(orderService.getOrdersById(id));
    }

    //test -
    @GetMapping("/customer_id={customId}")
    public List<OrderResponseDTO> getAllByCustomerId(@PathVariable Long customId) {
        return orderService.getOrdersByCustomerId(customId).stream()
                .map(OrderResponseDTO::new).collect(Collectors.toList());
    }

    //test -
    @GetMapping("/company_id={coId}")
    public List<OrderResponseDTO> getAllByCompanyId(@PathVariable Long coId) {
        return orderService.getOrdersByCompanyId(coId).stream()
                .map(OrderResponseDTO::new).collect(Collectors.toList());
    }
}
