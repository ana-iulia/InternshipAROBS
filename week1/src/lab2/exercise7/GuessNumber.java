package lab2.exercise7;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Random rand = new Random();

        int number = rand.nextInt(1000) + 1;
        int nrTries = 3;
        System.out.println("Guess the number between 1 and 1000");
        for (int i = 0; i < nrTries; i++) {
            System.out.println("Number: ");
            int n = Integer.parseInt(br.readLine());
            if (n == number) {
                System.out.println("Congratulations! Your guess is right.");
                break;
            } else if (n > number) {
                System.out.println("Wrong answer, your number it too high");
            } else {
                System.out.println("Wrong answer, your number it too low");
            }


        }
        System.out.println("The correct answer is: " + number);


    }

}
