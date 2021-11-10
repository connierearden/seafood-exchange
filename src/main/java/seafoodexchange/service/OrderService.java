package seafoodexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seafoodexchange.controller.dto.OrderRequestDTO;
import seafoodexchange.controller.dto.OrderResponseDTO;
import seafoodexchange.model.Order;
import seafoodexchange.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getOrdersByCustomerId(Long customId) {
        return orderRepository.getAllByCustomerId (customId);
    }

    public List<Order> getOrdersByCompanyId(Long coId) {
        return orderRepository.getAllByCompanyId(coId);
    }

    public Order getOrdersById(Long id) {
        return orderRepository.getById(id);
    }

    public String setOrderStatus(OrderRequestDTO orderRequestDTO) {
        return  null;
    }
}
