package ro.dragomiralin.microservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.dragomiralin.microservice.model.Order;
import ro.dragomiralin.microservice.repository.OrderRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order add(Order order) {
        log.info("Add new order.");
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        log.info("Get all orders.");
        return orderRepository.findAll();
    }

    public Order getById(String id) {
        log.info("Get order by id.");
        return orderRepository.findById(id)
                .orElseThrow();
    }

    public void delete(String id){
        log.info("Delete order.");
        orderRepository.deleteById(id);
    }
}
