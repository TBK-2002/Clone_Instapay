package Bills;

import Accounts.Account;

public abstract class BillProvider {
    protected String address;
    private Account account;
    private BillProviderType providerType;

    public Account getAccount() {
        return account;
    }

    public BillProviderType getProviderType() {
        return providerType;
    }

    public abstract boolean deduct(Bill bill);

}
