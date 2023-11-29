package com.springboot.live_comm.coding.learning;

import lombok.ToString;

import java.util.*;

@ToString
public class Person {
    private String name;
    private int age;
    private int pp;

    public Person(String name, int age, int pp) {
        this.name = name;
        this.age = age;
        this.pp = pp;
    }

    // 只重写了equals方法，没有重写hashCode方法
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }


    public static void main(String[] args) {
        Person p1 = new Person("John", 20, 1);
        Person p2 = new Person("John", 20, 2);

        // 应该输出true，但是因为没重写hashCode，所以输出false
        System.out.println(p1.equals(p2)); //

        Map<Person, Integer> map = new HashMap<>();
        map.put(p1, 1);
        System.out.println(map.containsKey(p2));
        System.out.println(map);
        map.put(p2, 2);
        System.out.println(map);
        Person p3 = new Person("John", 20, 3);
        System.out.println(map.get(p3));

        // 如果同时重写了equals和hashCode，那么输出true
        // @Override
        // public int hashCode() {
        //     return Objects.hash(name, age);
        // }
    }
}