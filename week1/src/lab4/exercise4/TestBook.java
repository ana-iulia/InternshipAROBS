package lab4.exercise4;

import week1.lab4.exercise2.Author;

import java.util.ArrayList;
import java.util.List;

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
