package ru.academit.maslenkin.vector.vector.vector;

import java.util.Arrays;

/**
 * Created by Александр on 22.10.2017.
 */
public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размер вектора должен быть больше нуля");
        } else {
            components = new double[n];
        }
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double... array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля");
        } else {
            components = Arrays.copyOf(array, array.length);
        }
    }

    public Vector(int n, double[] array) {
        if (array.length <= 0 || n <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля");
        } else {
            components = Arrays.copyOf(array, n);
        }
    }

    public int getSize() {
        return this.components.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(components).replace("[", "{").replace("]", "}");
    }

    public Vector multiplicationScalar(double scalar) {
        for (int i = 0; i < getSize(); ++i) {
            components[i] = scalar * components[i];
        }
        return this;
    }

    public Vector reverseVector() {
        multiplicationScalar(-1);
        return this;
    }

    public Vector getSum(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; ++i) {
            this.components[i] += vector.components[i];
        }
        return this;
    }

    public Vector getDifference(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; ++i) {
            this.components[i] -= vector.components[i];
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

    public static double multiplicationVector(Vector vector, Vector vector1) {
        double result = 0;
        int n = Math.min(vector.getSize(), vector1.getSize());
        for (int i = 0; i < n; ++i) {
            result += (vector.getElement(i) * vector1.getElement(i));
        }
        return result;
    }


    @Override
    public int hashCode() {
        final int PRIME = 33;
        return PRIME * Arrays.hashCode(this.components);
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
        return Arrays.equals(components, v.components);
    }

    public double getVectorLength(Vector vector) {
        double sum = 0;
        for (double e : this.components) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double setElement(int i, double component) {
        if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.components[i] = component;
        }
    }

    public double getElement(int i) {
        if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException();
        } else {
            return this.components[i];
        }
    }
}
