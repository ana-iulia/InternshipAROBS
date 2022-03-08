package week1.lab2.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Number: ");
        int a = Integer.parseInt(br.readLine());

        System.out.print("Enter Number: ");
        int b = Integer.parseInt(br.readLine());

       int numbers=generatePrimeNumbers(a,b);
        System.out.println("Total prime numbers: "+numbers);
    }

    private static int generatePrimeNumbers(int a, int b) {
        int numbers=0;
        while(a<b){
            boolean isPrime=true;
            for(int i=2;i<=a/2;i++){
                if(a%i==0){
                    isPrime=false;
                    break;
                }
            }
            if(a!=0 && a!=1 && isPrime){
                numbers++;
                System.out.println(a);
            }
            a++;
        }
        return numbers;
    }
}
