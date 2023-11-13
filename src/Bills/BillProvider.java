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
