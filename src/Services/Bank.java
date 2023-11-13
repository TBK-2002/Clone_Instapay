package Services;

import Accounts.Account;

import java.util.HashMap;
import java.util.Random;

public class Bank implements ServiceProviderBehavior {

    @Override
    public boolean transfer(Account from, Account to, String address, double amount) {
        String accountNumber = to.getVerficicationData().get("accountNumber");
        double  currBalance = inquire(from);
        if(amount > currBalance){
           System.out.println("Insufficient Balance");
           return false;
        }
        if(to.getVerficicationData().containsKey("accountNumber")){
           System.out.println("Transfering to Bank Account with account number: " + accountNumber);
           return true;
        }
        else{
           System.out.println("Transfering to Wallet with mobile number: " + to.getVerficicationData().get("mobileNumber"));
           return false;
        }

    }

    @Override
    public double inquire(Account acc) {
        Random rand = new Random();
        return rand.nextFloat() * 1000;
    }

    @Override
    public boolean verifyAccount(Account acc) {
        return true;
    }
}
