package week1.lab2.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintNumberInWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Number: ");
        int nr1 = Integer.parseInt(br.readLine());
        String number = Integer.toString(nr1);
        String wordNumber = "";
        String wordNumber2 = "";
        for (int i = 0; i < number.length(); i++) {
            wordNumber += nrToWord(number.charAt(i));
            wordNumber2 += nrToWord2(number.charAt(i));
        }
        System.out.println(wordNumber);
        System.out.println(wordNumber2);

    }


    static String nrToWord(char digit) {
        if (digit == '1') {
            return "One ";
        } else if (digit == '2') {

            return "Two ";
        } else if (digit == '3') {

            return "Three ";
        } else if (digit == '4') {

            return "Four ";
        } else if (digit == '5') {

            return "Five ";
        } else if (digit == '6') {

            return "Six ";
        } else if (digit == '7') {

            return "Seven ";
        } else if (digit == '8') {

            return "Eight ";
        } else if (digit == '9') {

            return "Nine ";
        }
        return "Zero ";
    }

    private static String nrToWord2(char digit) {
        switch (digit) {
            case '1':
                return "One ";
            case '2':
                return "Two ";

            case '3':
                return "Three ";

            case '4':
                return "Four ";

            case '5':
                return "Five ";

            case '6':
                return "Six ";

            case '7':
                return "Seven ";

            case '8':
                return "Eight ";

            case '9':
                return "Nine ";

            default:
                return "Zero ";


        }
    }
}
