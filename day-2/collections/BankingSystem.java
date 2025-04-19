import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalRequests = new LinkedList<>();

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalRequests.offer(new WithdrawalRequest(accountNumber, amount));
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void processWithdrawals() {
        System.out.println("\n--- Processing Withdrawal Requests ---");
        while (!withdrawalRequests.isEmpty()) {
            WithdrawalRequest request = withdrawalRequests.poll();
            String accountNumber = request.getAccountNumber();
            double amount = request.getAmount();
            if (accounts.containsKey(accountNumber)) {
                if (accounts.get(accountNumber) >= amount) {
                    accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                    System.out.println("Withdrawal of $" + amount + " from account " + accountNumber + " successful. Remaining balance: $" + accounts.get(accountNumber));
                } else {
                    System.out.println("Insufficient funds for withdrawal from account " + accountNumber + ". Requested: $" + amount + ", Available: $" + accounts.get(accountNumber));
                }
            } else {
                System.out.println("Account not found: " + accountNumber);
            }
        }
        System.out.println("--- All withdrawal requests processed ---");
    }

    public void displayAccountsSortedByBalance() {
        TreeMap<Double, String> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedAccounts.computeIfAbsent(entry.getValue(), k -> "").equals("") ?
                    sortedAccounts.put(entry.getValue(), entry.getKey()) :
                    sortedAccounts.put(entry.getValue(), sortedAccounts.get(entry.getValue()) + ", " + entry.getKey());
        }
        System.out.println("\n--- Accounts Sorted by Balance ---");
        sortedAccounts.forEach((balance, accountNumbers) ->
                System.out.println("Balance: $" + String.format("%.2f", balance) + " - Accounts: " + accountNumbers));
    }

    public void displayAllAccounts() {
        System.out.println("\n--- All Accounts ---");
        accounts.forEach((accountNumber, balance) ->
                System.out.println("Account: " + accountNumber + ", Balance: $" + String.format("%.2f", balance)));
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount("12345", 1000.00);
        bank.createAccount("67890", 500.00);
        bank.createAccount("13579", 2000.00);

        bank.deposit("12345", 200.00);
        bank.requestWithdrawal("67890", 600.00);
        bank.requestWithdrawal("12345", 100.00);
        bank.requestWithdrawal("99999", 50.00); // Non-existent account
        bank.requestWithdrawal("13579", 2500.00); // Insufficient funds

        bank.displayAllAccounts();
        bank.displayAccountsSortedByBalance();

        bank.processWithdrawals();

        bank.displayAllAccounts();
        bank.displayAccountsSortedByBalance();
    }
}

class WithdrawalRequest {
    private String accountNumber;
    private double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}