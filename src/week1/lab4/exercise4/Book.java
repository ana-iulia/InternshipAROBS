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

class TestBook {
    public static void main(String[] args) {
        Author author = new Author("Jordi Picoult", "jordipi@yahoo.com", 'f');
        Author author1 = new Author("Samanthe van Leer", "samleer@yahoo.com", 'f');
        List<Author> authors=new ArrayList<>();
        authors.add(author);
        authors.add(author1);
        Book book = new Book("Between the lines", authors, 24.0);
        System.out.println(book.getName() + " " + book.getPrice() + " " + book.getQtyInStock());
        book.printAuthors();
        book.setPrice(26.0);
        book.setQtyInStock(100);
        System.out.println(book);

    }

}