package Bills;

import Accounts.Account;

public abstract class Bill {
    private double amount;
    private BillProvider provider;
    private Account account;

    public Bill(double amount, BillProvider provider, Account account) {
        this.amount = amount;
        this.provider = provider;
        this.account = account;
    }

    public abstract String getDeductionData();
}
