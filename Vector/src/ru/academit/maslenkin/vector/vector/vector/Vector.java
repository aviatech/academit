package ru.academit.maslenkin.vector.vector.vector;

import java.util.Arrays;

/**
 * Created by Александр on 22.10.2017.
 */
public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размер вектора должен быть больше нуля");
        } else {
            vector = new double[n];
        }
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.vector.length);
    }

    public Vector(double... array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля");
        } else {
            vector = Arrays.copyOf(array, array.length);
        }
    }

    public Vector(int n, double[] array) {
        if (array.length <= 0 || n <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля");
        } else {
            vector = Arrays.copyOf(array, n);
        }
    }

    public int getSize() {
        return this.vector.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double e : this.vector) {
            sb.append(e).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    public Vector multiplicationVectorScalar(double scalar) {
        for (int i = 0; i < getSize(); ++i) {
            vector[i] = scalar * vector[i];
        }
        return this;
    }

    public Vector reversVector() {
        multiplicationVectorScalar(-1);
        return this;
    }

    public Vector getSum(Vector data) {
        if (this.vector.length < data.vector.length) {
            this.vector = Arrays.copyOf(this.vector, data.vector.length);
        }
        for (int i = 0; i < data.vector.length; ++i) {
            this.vector[i] = this.vector[i] + data.vector[i];
        }
        return this;
    }

    public Vector getDifference(Vector data) {
        if (this.vector.length < data.vector.length) {
            this.vector = Arrays.copyOf(this.vector, data.vector.length);
        }
        for (int i = 0; i < data.vector.length; ++i) {
            this.vector[i] = this.vector[i] - data.vector[i];
        }
        return this;
    }

    public static Vector getSum(Vector vector, Vector vector1) {
        Vector newVector = new Vector(vector);
        return newVector.getSum(vector1);

    }

    public static Vector getDifference(Vector vector, Vector vector1) {
        Vector newVector = new Vector(vector);
        return newVector.getDifference(vector1);
    }

    public static double multiplicationScalar(Vector vector, Vector vector1) {
        double result = 0;
        int n = Math.min(vector.getSize(), vector1.getSize());
        for (int i = 0; i < n; ++i) {
            result = vector.getElement(i) * vector1.getElement(i);
        }
        return result;
    }

    @Override
    public int hashCode() {
        final int PRIME = 33;
        return PRIME * Arrays.hashCode(this.vector);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector v = (Vector) obj;
        return Arrays.equals(vector, v.vector);
    }

    public double getVectorLength(Vector data) {
        double sum = 0;
        for (double e : this.vector) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double setElement(int i, double component) {
        if (i < 0 || i > this.vector.length) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.vector[i] = component;
        }
    }

    public double getElement(int i) {
        if (i < 0 || this.vector.length < i) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.vector[i];
        }
    }
}
