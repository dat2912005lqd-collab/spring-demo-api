package com.taxi.booking.dto;

public record CalculatorRequest(
    double a,
    double b,
    int idrequest,
    String codeRequest,
    String nameCustomer,
    int number
) {}

