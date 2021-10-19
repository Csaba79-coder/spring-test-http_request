package csaba79coder.springtesthttp_request.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/home")
    public String getGreeting() {
        return "Hello World from Spring Boot!";
    }
}
