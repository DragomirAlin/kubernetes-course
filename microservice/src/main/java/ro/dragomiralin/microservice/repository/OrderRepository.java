package ro.dragomiralin.microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.dragomiralin.microservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
