package com.springboot.personalLearning.stream.collection.iterable;

import com.springboot.live_comm.model.User;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyIterable<T> implements Iterable<T> {
    private Iterator<T> iterator;


    @Override
    public Iterator<T> iterator() {
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    public static void main(String[] args) {
        MyIterable<User> myIterable = new MyIterable<>();
        for (User user : myIterable) {

        }
    }
}
