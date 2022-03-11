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

class TestBankAccount {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Maria", 12.0);
        BankAccount bankAccount1 = new BankAccount("Maria", 12.0);
        System.out.println(bankAccount1.equals(bankAccount));
        BankAccount bankAccount2 = new BankAccount("Andrei", 12.0);
        System.out.println(bankAccount1.equals(bankAccount2));
    }
}
