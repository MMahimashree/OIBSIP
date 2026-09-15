import java.util.ArrayList;

public class Account {

    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;

        transactions.add(new Transaction(
                "WITHDRAW",
                amount,
                "Cash withdrawn"
        ));

        return true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;

        transactions.add(new Transaction(
                "DEPOSIT",
                amount,
                "Money deposited"
        ));

        return true;
    }

    public boolean transferTo(Account receiver, double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        receiver.balance += amount;

        transactions.add(new Transaction(
                "TRANSFER",
                amount,
                "Transferred to " + receiver.userId
        ));

        receiver.transactions.add(new Transaction(
                "TRANSFER RECEIVED",
                amount,
                "Received from " + userId
        ));

        return true;
    }

    public void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        System.out.println("==========================================");
    }
}