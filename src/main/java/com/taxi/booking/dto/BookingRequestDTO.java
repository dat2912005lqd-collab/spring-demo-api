package com.taxi.booking.dto;
public record BookingRequestDTO(
    int idrequest,
    int number,
    String codeRequest,
    String nameCustomer
)  {
    public static BookingRequestDTO withDefaults() {
        return new BookingRequestDTO(1, 123456, "REQ-001", "Thanh Dat");
    }
}



