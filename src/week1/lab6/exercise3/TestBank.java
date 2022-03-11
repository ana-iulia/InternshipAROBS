package week1.lab6.exercise3;


import week1.lab6.exercise2.BankAccount;

import java.util.Comparator;

public class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount("Maria", 23.0);
        bank.addAccount("Andrei", 27.0);
        bank.addAccount("Mihai", 20.0);
        bank.getAllAccounts().stream().forEach(System.out::println);
        System.out.println("Accounts sorted by balance: ");
        bank.printAccounts();
        System.out.println("Accounts in range (21.0-30.0): ");
        bank.printAccounts(21.0, 30.0);
        System.out.println("Mihai account balance: " + bank.getBankAccount("Mihai").getBalance());
        System.out.println("Accounts sorted by owner (by default): ");
        bank.getAllAccounts()
                .stream()
                .forEach(System.out::println);

    }
}