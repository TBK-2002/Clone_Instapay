package Accounts;

import Accounts.Account;
import Services.ServiceProvider;

import java.util.HashMap;

public class BankAccount extends Account {
    private String accountNumber;
    HashMap<String,String> verficicationData ;

    public BankAccount(int accountId, String mobileNumber, String userName, String password, ServiceProvider provider, String accountNumber) {
        super(accountId, mobileNumber, userName, password , provider);
        this.accountNumber = accountNumber;
        verficicationData = new HashMap<>();
        verficicationData.put("mobile number",this.mobileNumber);
        verficicationData.put("account number",this.accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    @Override
    public HashMap<String, String> getVerficicationData() {
        return verficicationData;
    }
}
