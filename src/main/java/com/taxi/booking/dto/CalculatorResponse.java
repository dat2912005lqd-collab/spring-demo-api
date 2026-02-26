package com.taxi.booking.dto;

public record CalculatorResponse(
    int idrequest,
    int number,
    String codeRequest,
    String nameCustomer,
    int result
) {
}
