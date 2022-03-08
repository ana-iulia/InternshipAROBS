package week1.lab2.exercise5;


import java.io.IOException;

import java.util.Random;


public class BubbleSort {
    public static void main(String[] args) throws IOException {
        int vector[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            vector[i] = rand.nextInt(1000);
        }
        bubbleSort(vector);
        for (int i = 0; i < 10; i++) {
            System.out.println(vector[i] + " ");
        }
    }

    private static void bubbleSort(int[] vector) {
        int n = vector.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
    }


}
