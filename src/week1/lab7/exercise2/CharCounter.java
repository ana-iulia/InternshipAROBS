package week1.lab7.exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CharCounter {
    private FileReader file;
    private char letter;

    public CharCounter(char letter, FileReader file) {
        this.letter = letter;
        this.file = file;
    }

    public String readFile() {
        String data = "";
        Scanner reader = new Scanner(this.file);
        while (reader.hasNextLine()) {
            data += reader.nextLine();
        }
        reader.close();
        return data;
    }

    public int countChar(String data) {
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == this.letter) {
                count++;
            }
        }
        return count;

    }
}
