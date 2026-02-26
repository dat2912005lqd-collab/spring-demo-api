package com.taxi.booking.dto;
public record FeedbackDTO(
    int userId,
    int bookingId,
    String comments
) {
    public static FeedbackDTO withDefaults(String comments) {
        return new FeedbackDTO(17, 16, comments);
    }
}