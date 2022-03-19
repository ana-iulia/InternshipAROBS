package lab2.exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class MaximulElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Vector<Integer> vector = new Vector<Integer>();
        System.out.print("Enter Number: ");
        String element = br.readLine();
        while (element != "exit") {
            try {
                int number = Integer.parseInt(element);
                vector.add(number);
            } catch (NumberFormatException ex) {
                int maximum = maximumElement(vector);
                System.out.println("Max element is: " + maximum);
                return;
            }
            System.out.println("Enter Number: ");
            element = br.readLine();

        }


    }

    private static int maximumElement(Vector<Integer> vector) {
        int max = vector.elementAt(0);
        for (int i = 1; i < vector.size(); i++) {
            if (vector.elementAt(i) > max) {
                max = vector.elementAt(i);
            }
        }
        return max;
    }
}
