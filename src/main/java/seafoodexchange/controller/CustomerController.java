package seafoodexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seafoodexchange.controller.dto.CustomerDTO;
import seafoodexchange.controller.dto.CustomerResponseDTO;
import seafoodexchange.model.Customer;
import seafoodexchange.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //test +
    @GetMapping("/{customerId}")
    public CustomerResponseDTO getById(@PathVariable Long customerId) {
        return new CustomerResponseDTO(customerService.getCustomById(customerId));
    }

    //test +
    @PostMapping
    public String create(@RequestBody CustomerDTO customerRequestDTO) {
        customerService.createCustomer(Customer.builder().name(customerRequestDTO.getName())
        .country(customerRequestDTO.getCountry()).balance(0D).orders(null).build());
        return "Success";
    }
}
