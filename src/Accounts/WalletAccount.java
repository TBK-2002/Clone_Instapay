package Accounts;

import Accounts.Account;
import Services.ServiceProvider;

import java.util.HashMap;

public class WalletAccount extends Account {
    HashMap<String,String> verficicationData ;

    public WalletAccount(int accountId, String mobileNumber, String userName, String password, ServiceProvider provider) {
        super(accountId, mobileNumber, userName, password, provider);
        verficicationData = new HashMap<>();
        verficicationData.put("mobile number",this.mobileNumber);

    }

    @Override
    public HashMap<String, String> getVerficicationData() {
        return verficicationData;
    }
}
