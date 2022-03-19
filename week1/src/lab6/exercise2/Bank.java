package lab6.exercise2;

import java.util.*;

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
                .forEach(x -> {
                    if (x.getBalance() >= minBalance && x.getBalance() <= maxBalance)
                        System.out.println(x);
                });
    }

    public Optional<BankAccount> getBankAccount(String owner) {
        for (BankAccount bankAccount : bankAccounts) {
            if (Objects.equals(bankAccount.getOwner(), owner)) {
                return Optional.of(bankAccount);
            }
        }
       return Optional.empty();
    }

    public List<BankAccount> getAllAccounts() {
        return this.bankAccounts;
    }

}
