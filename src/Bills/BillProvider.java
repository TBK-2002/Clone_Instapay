package Bills;

import Accounts.Account;

public abstract class BillProvider {
    public BillProvider(String address, Account account, BillProviderType providerType) {
        this.address = address;
        this.account = account;
        this.providerType = providerType;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BillProviderType getBillProviderType() {
        return providerType;
    }

    public void setBillProviderType(BillProviderType providerType) {
        this.providerType = providerType;
    }
}
