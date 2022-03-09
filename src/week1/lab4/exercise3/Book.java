package week1.lab4.exercise3;

import week1.lab4.exercise2.Author;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;

    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = 0;
    }

    public String getName() {
        return name;
    }


    public Author getAuthor() {
        return author;
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

    @Override
    public String toString() {
        return name + " by " + author;
    }
}

class TestBook {
    public static void main(String[] args) {
        Author author = new Author("Jane Austen", "janeausten@yahoo.com", 'f');
        Book book = new Book("Pride and Prejudice", author, 24.0);
        System.out.println(book.getAuthor() + " " + book.getName() + " " + book.getPrice() + " " + book.getQtyInStock());
        book.setPrice(26.0);
        Book book1 = new Book("Emma", author, 15.0, 150);
        book1.setQtyInStock(100);
        System.out.println(book);
        System.out.println(book1);

    }

}