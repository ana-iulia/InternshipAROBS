package week1.lab4.exercise4;

import week1.lab4.exercise2.Author;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private List<Author> authors = new ArrayList<>();
    private double price;
    private int qtyInStock;

    public Book(String name, List<Author> authors, double price, int qtyInStock) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public Book(String name, List<Author> authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qtyInStock = 0;
    }

    public String getName() {
        return name;
    }


    public List<Author> getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public void printAuthors() {
        for (Author author : this.authors) {
            System.out.println(author);

        }
    }

    @Override
    public String toString() {
        return name + " by " + authors.size() + " authors";
    }
}

