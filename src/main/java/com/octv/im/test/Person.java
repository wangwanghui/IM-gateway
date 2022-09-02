package com.octv.im.test;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

@Data
public class Person {
    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    private String username;
    private int age;
}
