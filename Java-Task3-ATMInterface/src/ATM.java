import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank, Scanner scanner) {
        this.bank = bank;
        this.scanner = scanner;
    }

    public void start() {

        System.out.println("======================================");
        System.out.println("          WELCOME TO ATM");
        System.out.println("======================================");

        Account account = login();

        if (account == null) {
            System.out.println("\nAccess denied. ATM session ended.");
            return;
        }

        boolean running = true;

        while (running) {

            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    account.showTransactionHistory();
                    break;

                case "2":
                    withdraw(account);
                    break;

                case "3":
                    deposit(account);
                    break;

                case "4":
                    transfer(account);
                    break;

                case "5":
                    System.out.printf(
                            "Current Balance: Rs.%.2f%n",
                            account.getBalance()
                    );
                    break;

                case "6":
                    running = false;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private Account login() {

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("\nEnter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            Account account = bank.getAccount(userId);

            if (account != null && account.verifyPin(pin)) {
                System.out.println("\nLogin successful!");
                return account;
            }

            System.out.println("Invalid User ID or PIN.");

            if (attempt < 3) {
                System.out.println(
                        "Attempts remaining: " + (3 - attempt)
                );
            }
        }

        System.out.println("\nToo many incorrect attempts.");
        System.out.println("Access blocked for this session.");

        return null;
    }

    private void withdraw(Account account) {

        System.out.print("Enter withdrawal amount: ");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
                System.out.printf(
                        "Remaining Balance: Rs.%.2f%n",
                        account.getBalance()
                );
            } else {
                System.out.println(
                        "Withdrawal failed. Check the amount and available balance."
                );
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }

    private void deposit(Account account) {

        System.out.print("Enter deposit amount: ");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (account.deposit(amount)) {
                System.out.println("Deposit successful.");
                System.out.printf(
                        "New Balance: Rs.%.2f%n",
                        account.getBalance()
                );
            } else {
                System.out.println("Deposit failed. Amount must be positive.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }

    private void transfer(Account account) {

        System.out.print("Enter receiver User ID: ");
        String receiverId = scanner.nextLine();

        Account receiver = bank.getAccount(receiverId);

        if (receiver == null) {
            System.out.println("Receiver account not found.");
            return;
        }

        if (receiver == account) {
            System.out.println("You cannot transfer money to yourself.");
            return;
        }

        System.out.print("Enter transfer amount: ");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (account.transferTo(receiver, amount)) {
                System.out.println("Transfer successful.");
                System.out.printf(
                        "Remaining Balance: Rs.%.2f%n",
                        account.getBalance()
                );
            } else {
                System.out.println(
                        "Transfer failed. Check the amount and available balance."
                );
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }
}