package ru.academit.maslenkin.range.range;

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

    public Range getIntersection(Range range) {
        if (from < range.to && to > range.from) {
            return new Range((Math.max(from, range.from)), Math.min(to, range.to));
        }
        return null;
    }
    public Range[] getAssociation(Range range) {
        if (Math.min(to, range.to) < Math.max(from, range.from)) {
            return new Range[]{new Range(Math.min(from, range.from), Math.min(to, range.to)),
                    new Range(Math.max(from, range.from), Math.max(to, range.to))};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }
    public static void print(Range[] arrayAssociation) {
        for (Range elementArrayAssociation : arrayAssociation) {
            System.out.printf("Результат объединения %.1f %.1f%n", elementArrayAssociation.getFrom(), elementArrayAssociation.getTo());
        }
    }
    public void print() {
        System.out.println("Длина интервала " + getLength());
    }
}