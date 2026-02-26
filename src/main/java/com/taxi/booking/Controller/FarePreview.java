package com.taxi.booking.Controller;

public class FarePreview {
    private String from;
    private String to;
    private double baseFare;
    private double taxes;

    public FarePreview() {
    }

    public FarePreview(String from, String to, double baseFare, double taxes) {
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.taxes = taxes;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double getTaxes() {
        return taxes;
    }

}
