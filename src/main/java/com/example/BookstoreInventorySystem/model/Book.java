package com.example.bookstore.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private int quantityInStock;

    public Book(String id, String title, String author, int quantityInStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantityInStock = quantityInStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}