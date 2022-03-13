package week1.lab6.exercise1;

public class BankAccount {
    private String owner;
    private double balance;

    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return (int) (owner.hashCode() + balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount bankAccount = (BankAccount) obj;
            return (owner == bankAccount.owner && balance == bankAccount.balance);
        }
        return false;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}

