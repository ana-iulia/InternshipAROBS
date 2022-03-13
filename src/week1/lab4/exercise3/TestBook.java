package week1.lab4.exercise3;

import week1.lab4.exercise2.Author;

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
