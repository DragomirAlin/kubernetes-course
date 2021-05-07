package ro.dragomiralin.microservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.dragomiralin.microservice.model.Order;
import ro.dragomiralin.microservice.model.ResponseDTO;
import ro.dragomiralin.microservice.service.OrderService;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseDTO test() {
        log.info("Test API");
        return ResponseDTO.builder()
                .message("Test API")
                .build();
    }

    @PostMapping("/{name}")
    public ResponseDTO getGreetings(@PathVariable String name) {
        log.info("Greetings to {}.", name);
        return ResponseDTO.builder()
                .message(String.format("Hello %s", name))
                .build();
    }

    @PostMapping("/order")
    public Order add(@RequestBody Order order) {
        return orderService.add(order);
    }

    @GetMapping("/order/{id}")
    public Order getById(@PathVariable String id) {
        return orderService.getById(id);
    }

    @GetMapping("/order")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.delete(id);
    }
}
