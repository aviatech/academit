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
        if (Math.min(to, range.to) <= Math.max(from, range.from)) {
            return null;
        } else {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }
    }

    public Range[] getUnion(Range range) {
        if (Math.min(to, range.to) < Math.max(from, range.from)) {
            return new Range[]{new Range(Math.min(from, range.from), Math.min(to, range.to)),
                    new Range(Math.max(from, range.from), Math.max(to, range.to))};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        } else if (to <= range.from || from >= range.to) {
            return new Range[]{new Range(from, to)};
        } else if (range.from <= to && range.to >= to) {
            return new Range[]{new Range(from, range.from)};
        } else if (from >= range.from && range.to <= to) {
            return new Range[]{new Range(range.to, to)};
        } else {
            return new Range[]{(new Range(from, range.from)), new Range(range.to, to)};
        }
    }

    public static void print(Range[] arrayUnion) {
        for (Range elementArrayAssociation : arrayUnion) {
            System.out.printf("Результат объединения %.1f %.1f%n", elementArrayAssociation.getFrom(), elementArrayAssociation.getTo());
        }
    }

    public static void printResultDifference(Range[] arrayDifference) {
        if (arrayDifference.length == 0) {
            System.out.println("Разность интервалов равна нулю");
        } else {
            for (Range elementArrayDifference : arrayDifference) {
                System.out.printf("Результат разности %.1f %.1f%n", elementArrayDifference.getFrom(), elementArrayDifference.getTo());
            }
        }
    }

    public void print() {
        System.out.println("Длина интервала " + getLength());
    }
}