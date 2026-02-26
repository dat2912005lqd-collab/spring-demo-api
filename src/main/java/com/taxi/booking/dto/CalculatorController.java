package com.taxi.booking.dto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public ResponseEntity<?> add(
        @RequestParam(required = true) Double a,
        @RequestParam(required = true) Double b
    ) {
        if (a == null || b == null) {
            return ResponseEntity.badRequest().body("400 Bad Request: Missing required query parameters 'a' and 'b'.");
        }
        return ResponseEntity.ok(a + b);
    }
    
    @GetMapping("/subtract/{a}/{b}")
    public ResponseEntity<Double> subtract(
        @PathVariable double a,
        @PathVariable double b
    ) {
        return ResponseEntity.ok(a - b);
    }
    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(
       @RequestBody CalculatorRequest request
    ) {
        return ResponseEntity.ok(request.a() * request.b());
    }
    @PostMapping("/divide/{a}/{b}")
    public ResponseEntity<?> divide(
        @RequestBody CalculatorRequest request 
    ) {
        if (request.b() == 0) {
            return ResponseEntity.badRequest().body("400 Bad Request: Division by zero is not allowed.");
        }
        return ResponseEntity.ok(request.a() / request.b());
    }
}
