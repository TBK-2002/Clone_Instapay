package Accounts;

import Accounts.Account;
import Services.ServiceProvider;

import java.util.HashMap;

public class BillProviderAccount extends Account {
    private String accountNumber;
    public BillProviderAccount(int accountId, String mobileNumber, String userName, String password, ServiceProvider provider) {
        super(accountId, mobileNumber, userName, password, provider);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public HashMap<String, String> getVerficicationData() {
        return null;
    }
}
