package lab7.exercise2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a character: ");
        String letter = scanner.nextLine();
        try {
            FileReader file = new FileReader("C:\\Users\\anaiu\\GitHub\\InternshipAROBS\\src\\week1\\lab7\\exercise2\\text.txt");

            CharCounter charCounter = new CharCounter(letter.charAt(0), file);
            System.out.println("The character " + letter + " appears: " + charCounter.countChar(charCounter.readFile()) + " times");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File could not be found.");

        }
    }
}
