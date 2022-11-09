package com.springboot.live_comm.model;

public class Hello {
    private String start;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String sayHello() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Hello{" +
                "start='" + start + '\'' +
                ", book=" + book +
                '}';
    }
}
