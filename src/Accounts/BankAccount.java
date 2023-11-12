package Accounts;

import Accounts.Account;
import Services.ServiceProvider;

import java.util.HashMap;

public class BankAccount extends Account {
    private String accountNumber;

    public BankAccount(int accountId, String mobileNumber, String userName, String password, ServiceProvider provider, String accountNumber) {
        super(accountId, mobileNumber, userName, password , provider);
        this.accountNumber = accountNumber;
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
