package week1.lab6.exercise2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

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

    public List<BankAccount> getAllAccounts() {
        return this.bankAccounts;
    }

}
