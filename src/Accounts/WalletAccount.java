package Accounts;

import Accounts.Account;
import Services.ServiceProvider;

import java.util.HashMap;

public class WalletAccount extends Account {
    public WalletAccount(int accountId, String mobileNumber, String userName, String password, ServiceProvider provider) {
        super(accountId, mobileNumber, userName, password, provider);
    }

    @Override
    public HashMap<String, String> getVerficicationData() {
        return null;
    }
}
