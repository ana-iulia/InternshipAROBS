package lab7.exercise3;

import week1.lab7.exercise2.CharCounter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestCharCipher {
    public static void main(String[] args) {
        String path = "C:\\Users\\anaiu\\GitHub\\InternshipAROBS\\src\\week1\\lab7\\exercise3\\";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a file name: ");
        String fileName = scanner.nextLine();
        System.out.println("Insert a command (encrypt/decrypt): ");
        String type = scanner.nextLine();
        path += fileName;
        try {
            FileReader file = new FileReader(path);
            CharCipher charCipher = new CharCipher(file);
            charCipher.cipher(type);
            System.out.println("Operation is done!");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File could not be found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
