package com.model.bean;

/**
 * Created by zhouweitao on 16/8/29.
 */
public class JSONTest {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "JSONTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
