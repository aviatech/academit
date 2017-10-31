package ru.academit.maslenkin.vector.vector.main;

import ru.academit.maslenkin.vector.vector.vector.Vector;

import static ru.academit.maslenkin.vector.vector.vector.Vector.getDifference;
import static ru.academit.maslenkin.vector.vector.vector.Vector.getSum;
import static ru.academit.maslenkin.vector.vector.vector.Vector.multiplicationVector;

/**
 * Created by Александр on 24.10.2017.
 */
public class Main {
    public static void main(String[] args) {

        Vector vector = new Vector(2, 3, 4);
        Vector vector1 = new Vector(5, 58, 8);

        System.out.println("Произведение векторов " + multiplicationVector(vector, vector1));

        System.out.println("Длина вектора =" + vector.getVectorLength(vector1));

        System.out.println("Установка компонента " + vector.setElement(1, 123));
        System.out.println("Получение компонента " + vector.getElement(2));

        System.out.println("Размер вектора = " + vector.getSize());

        System.out.println(vector.toString());
        System.out.println(vector1.toString());

        System.out.println("Умножение на скаляр " + vector.multiplicationScalar(5.2));

        System.out.println("Разворот " + vector.reverseVector());

        System.out.println("Сумма " + vector.getSum(vector1));
        System.out.println("Разность " + vector.getDifference(vector1));

        System.out.println("Сумма(static) " + getSum(vector, vector1));
        System.out.println("Разность(static) " + getDifference(vector, vector1));


    }
}
