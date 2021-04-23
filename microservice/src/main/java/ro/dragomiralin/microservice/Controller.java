package ro.dragomiralin.microservice;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class Controller {

    @PostMapping("/{name}")
    public ResponseDTO getGreetings(@PathVariable String name) {
        return ResponseDTO.builder()
                .message(String.format("Hello %s", name))
                .build();
    }
}
