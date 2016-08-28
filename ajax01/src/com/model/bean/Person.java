package com.model.bean;

/**
 * Created by zhouweitao on 16/8/28.
 */
public class Person {
    private Integer id;
    private String name;
    private double salary;
    private Gender gender;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }

    public Person(Integer id, String name, double salary, Gender gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public Gender getGender() {

        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person() {
    }

    public Person(Integer id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
