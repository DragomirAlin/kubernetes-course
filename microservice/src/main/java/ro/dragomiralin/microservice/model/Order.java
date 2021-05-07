package ro.dragomiralin.microservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Order {
    private String id;
    private String nameClient;
    private String phoneNumber;
    private String details;
}
