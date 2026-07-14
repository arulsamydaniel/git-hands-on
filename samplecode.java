import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account opened with balance: $" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: $" + amount + ". New balance: $" + balance);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            addTransaction("Withdrew: $" + amount + ". New balance: $" + balance);
            return true;
        }
        addTransaction("Failed withdrawal attempt of: $" + amount);
        return false;
    }

    private void addTransaction(String message) {
        transactionHistory.add(message);
    }

    public void printHistory() {
        System.out.println("History for Account: " + accountNumber);
        for (String tx : transactionHistory) {
            System.out.println(" - " + tx);
        }
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("TXN-90210", 500.00);
        
        myAccount.deposit(150.00);
        myAccount.withdraw(200.00);
        myAccount.withdraw(1000.00); // This will fail due to insufficient funds
        
        System.out.println();
        myAccount.printHistory();
    }
}