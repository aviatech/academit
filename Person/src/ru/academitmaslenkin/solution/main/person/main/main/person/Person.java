package ru.academitmaslenkin.solution.main.person.main.main.person;

/**
 * Created by Александр on 20.11.2017.
 */
public class Person {
    private String name;
    private int age;

    public Person (String name, int age){
        this.name= name;
        this.age = age;
    }
    public void setName(){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
