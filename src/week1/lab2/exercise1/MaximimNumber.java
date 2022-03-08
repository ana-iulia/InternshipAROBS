package week1.lab2.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximimNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Number: ");
        int nr1 = Integer.parseInt(br.readLine());

        System.out.print("Enter Number: ");
        int nr2 = Integer.parseInt(br.readLine());

        if (nr1 > nr2) {
            System.out.println("Maximum of the numbers is: " + nr1);
        } else {
            System.out.println("Maximum of the numbers is: " + nr2);
        }

    }
}
