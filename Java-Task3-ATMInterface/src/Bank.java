import java.util.HashMap;

public class Bank {

    private HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();

        accounts.put("user1001",
                new Account("user1001", "1234", 10000));

        accounts.put("user1002",
                new Account("user1002", "5678", 5000));
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }
}