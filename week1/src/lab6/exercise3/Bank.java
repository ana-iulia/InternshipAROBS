package lab6.exercise3;

import week1.lab6.exercise2.BankAccount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Bank {
    private TreeSet<BankAccount> bankAccounts = new TreeSet<>(Comparator.comparing(BankAccount::getOwner));

    public void addAccount(String owner, double balance) {
        BankAccount bankAccount = new BankAccount(owner, balance);
        bankAccounts.add(bankAccount);
    }

    public void printAccounts() {
        this.bankAccounts
                .stream()
                .sorted(Comparator.comparingDouble(BankAccount::getBalance))
                .forEach(System.out::println);
    }

    public void printAccounts(double minBalance, double maxBalance) {
        this.bankAccounts
                .stream()
                .forEach(x -> {
                    if (x.getBalance() >= minBalance && x.getBalance() <= maxBalance)
                        System.out.println(x);
                });
    }

    public BankAccount getBankAccount(String owner) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getOwner() == owner) {
                return bankAccount;
            }
        }
        return null;
    }

    public TreeSet<BankAccount> getAllAccounts() {
        return this.bankAccounts;
    }

}
