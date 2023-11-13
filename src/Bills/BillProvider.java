package Bills;

import Accounts.Account;

public abstract class BillProvider {
    private String address;
    private Account account;
    private BillProviderType providerType;

    public abstract boolean deduct(Bill bill);

    public BillProviderType getBillProviderType() {
        return providerType;
    }

    public void setBillProviderType(BillProviderType providerType) {
        this.providerType = providerType;
    }
}
