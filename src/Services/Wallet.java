package Services;

import Accounts.Account;

import java.util.Random;

public class Wallet implements ServiceProviderBehavior {

    @Override
    public boolean transfer(Account from, Account to, String address, double amount) {
        String mobileNumber = to.getVerficicationData().get("mobileNumber");
        double  currBalance = inquire(from);


        if(to.getVerficicationData().containsKey("accountNumber")){
            System.out.println("Error: Cannot transfer from Wallet to Bank Account");
            return false;
        }
        else if(to.getVerficicationData().containsKey("providerAccountNumber")){
            if(amount > currBalance){
                System.out.println("Insufficient Balance");
                return false;
            }
            return true;
        }
        else{
            if(amount > currBalance){
                System.out.println("Insufficient Balance");
                return false;
            }
            System.out.println("Transfering to Wallet with mobile number: " + mobileNumber);
            return true;
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
