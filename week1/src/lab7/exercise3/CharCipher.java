package lab7.exercise3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class CharCipher {
    private FileReader file;
    private String data;

    public CharCipher(FileReader file) {
        this.data = "";
        this.file = file;
    }

    private void readFile() {
        String data = "";
        Scanner reader = new Scanner(this.file);
        while (reader.hasNextLine()) {
            data += reader.nextLine();
        }
        reader.close();
        this.data = data;
    }

    private void encryption() {
        String encrypted = "";
        for (int i = 0; i < this.data.length(); i++) {
            char letter = this.data.charAt(i);
            if (letter != " ".charAt(0)) {
                int ascii = (int) letter - 1;
                encrypted += Character.toString(ascii);
            } else {
                encrypted += " ";
            }
        }

        this.data = encrypted;

    }

    private void decryption() {
        String decrypted = "";
        for (int i = 0; i < this.data.length(); i++) {
            char letter = this.data.charAt(i);
            if (letter != " ".charAt(0)) {
                int ascii = (int) letter + 1;
                decrypted += Character.toString(ascii);
            } else {
                decrypted += " ";
            }
        }

        this.data = decrypted;

    }

    private void writeFile(String type) throws Exception {
        FileWriter writer = null;
        if (type.equals("encrypt")) {
            writer = new FileWriter("C:\\Users\\anaiu\\GitHub\\InternshipAROBS\\src\\week1\\lab7\\exercise3\\encrypted.enc");
        } else if (type.equals("decrypt")) {
            writer = new FileWriter("C:\\Users\\anaiu\\GitHub\\InternshipAROBS\\src\\week1\\lab7\\exercise3\\decrypted.dec");
        } else {
            throw new Exception("Command doesn't exist!");
        }
        writer.write(this.data);
        writer.close();
    }

    public void cipher(String type) throws Exception {
        this.readFile();
        if (Objects.equals(type, "encrypt")) {
            this.encryption();
        } else if (Objects.equals(type, "decrypt")) {
            this.decryption();
        } else {
            throw new Exception("Command doesn't exist!");
        }
        this.writeFile(type);

    }
}
