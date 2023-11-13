package Bills;

import Accounts.Account;

import java.util.HashMap;

public class Bill {
    private double amount;
    private BillProvider provider;
    private Account account;

    private HashMap<String, String> deductionData;

    public Bill(double amount, BillProvider provider, Account account, HashMap<String, String> deductionData) {
        this.amount = amount;
        this.provider = provider;
        this.account = account;
        this.deductionData = deductionData;
    }

    public HashMap<String, String> getDeductionData() {
        return deductionData;
    }
    public double getAmount() {
        return amount;
    }

    public BillProvider getProvider() {
        return provider;
    }

    public Account getAccount() {
        return account;
    }
}
