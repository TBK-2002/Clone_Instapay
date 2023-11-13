package Bills;

import Accounts.Account;

import java.util.HashMap;

public abstract class Bill {
    private double amount;
    private BillProvider provider;
    private Account account;

    public Bill(double amount, BillProvider provider, Account account) {
        this.amount = amount;
        this.provider = provider;
        this.account = account;
    }

    public abstract HashMap<String,String> getDeductionData();

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
