package lab2.exercise6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Number: ");
        int n = Integer.parseInt(br.readLine());

        int nrF1 = nonrecursiveFactorial(n);
        System.out.println("Non recursive factorial: " + nrF1);
        int nrF2 = recursiveFactorial(n);
        System.out.println("Recursive factorial: " + nrF2);
    }


    private static int nonrecursiveFactorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private static int recursiveFactorial(int n) {
        if(n==0){
            return 1;
        }
        return (n*recursiveFactorial(n-1));
    }
}
