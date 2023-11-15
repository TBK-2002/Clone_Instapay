package Accounts;

import Services.ServiceProvider;
import Services.ServiceProviderType;

import java.util.HashMap;

public class AccountFactory {
    public static Account createAccount(ServiceProvider serviceProvider, HashMap<String,String> data){
        if(serviceProvider.getServiceProviderType() == ServiceProviderType.BANK){
            return new BankAccount(0,data.get("mobile number"),data.get("username"),data.get("password"),serviceProvider,data.get("account number"));
        }
        else if(serviceProvider.getServiceProviderType() == ServiceProviderType.WALLET){
            return new WalletAccount(0,data.get("mobile number"),data.get("username"),data.get("password"),serviceProvider);
        }
        else{
            return null;
        }
    }
}
