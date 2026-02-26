package com.taxi.booking.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.taxi.booking.dto.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class BookingController {
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
       return List.of();
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody BookingRequestDTO booking) {
        return null;
    }

    @PutMapping("/bookings/{id}")
    public ResponseEntity<Void> updateBooking(
        @PathVariable Long id,
        @RequestParam String status
    ) {
        bookingService.updateStatus(id,status);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
    }

    @GetMapping("/users/{userId}/bookings/{bookingId}")
    public ResponseEntity<Booking> getBookingForUser(
        @PathVariable int userId,
        @PathVariable Long bookingId
    ) {
        Booking b = new Booking();
        return ResponseEntity.ok(b);
    }

    @GetMapping("/users/{userId}/bookings/{bookingId}/feedback")
    public ResponseEntity<FeedbackDTO> getFeedback(
        @PathVariable int userId,
        @PathVariable int bookingId
    ) {
        FeedbackDTO dto = FeedbackDTO.withDefaults("Default feedback for user " + userId + " and booking " + bookingId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/calculator")
    public ResponseEntity<CalculatorResponse> addCalculation(@RequestBody CalculatorRequest request) {
        int result = request.number() + 10;
        CalculatorResponse response = new CalculatorResponse(
            request.idrequest(),
            request.number(),
            request.codeRequest(),
            request.nameCustomer(),
            result
        );
        return ResponseEntity.ok(response);
    }
    @PostMapping("/calculator/divide")
    public ResponseEntity<String>divide(@RequestBody DivideRequest request)
    {
        if(request.divisor() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Divisor cannot be zero.");
        }
        double result = request.dividend() / request.divisor();
        return ResponseEntity.ok("Ket qua: " + result);
    }
    
}