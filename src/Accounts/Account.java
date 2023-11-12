package Accounts;

import Services.ServiceProvider;

import java.util.HashMap;
import java.util.List;

public abstract class Account {
    protected int accountId;
    protected String mobileNumber;
    protected String userName;
    protected String password;
    protected ServiceProvider provider;


    public Account(int accountId, String mobileNumber, String userName, String password, ServiceProvider provider) {
        this.accountId = accountId;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.password = password;
        this.provider = provider;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public abstract HashMap<String,String> getVerficicationData();

}