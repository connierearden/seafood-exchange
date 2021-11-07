package seafoodexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seafoodexchange.model.Customer;
import seafoodexchange.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public Customer getCustomById(Long id) {
        return customerRepository.getById(id);
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
