package ru.academit.maslenkin.range;

public class Range {
    private double from;
    private double to;

   public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

   public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public double getLength() {
        return to - from;
    }

    public  void print() {
        System.out.println("Длина диапазона " + getLength());
    }
}