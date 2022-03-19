package lab6.exercise1;

class TestBankAccount {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Maria", 12.0);
        BankAccount bankAccount1 = new BankAccount("Maria", 12.0);
        System.out.println(bankAccount1.equals(bankAccount));
        BankAccount bankAccount2 = new BankAccount("Andrei", 12.0);
        System.out.println(bankAccount1.equals(bankAccount2));
    }
}

