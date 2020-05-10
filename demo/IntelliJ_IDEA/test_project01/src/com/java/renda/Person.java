package com.java.renda;

/**
 * @author Renda Zhang
 * @create 2020-04-15 17:53
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        // return o.getAge() - this.getAge(); // Age descending
        // return this.getAge() - o.getAge(); // Age ascending
        int result = o.getAge() - this.getAge(); // Age descending
        if (result == 0) {
            // Descending based on the first letter of the name
            result = o.getName().charAt(0) - this.getName().charAt(0);
        }
        return result;
    }
}
