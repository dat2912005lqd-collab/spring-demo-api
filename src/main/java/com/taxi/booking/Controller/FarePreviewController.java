package com.taxi.booking.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/fares")
public class FarePreviewController
{
    @PostMapping("/preview")
    public FarePreview previewFare(
        @RequestParam String currency,
        @RequestBody FareReviewRequest request
        
    ) {
        System.out.println("previewFare called");
        if(!"VND".equalsIgnoreCase(currency)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Chỉ hỗ trợ tiền tệ VND");
        }
        double baseFare=request.getDistanceInKm()*10000;
        double taxes=baseFare*0.1;
        return new FarePreview("HCM","HN",baseFare,taxes);
    }
}