package Services;

import Accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Bank implements ServiceProviderBehavior {

    @Override
    public boolean transfer(Account from, Account to, String address, double amount) {
        if(from.getProvider().getAvailableTransfers().contains(to.getProvider().serviceProviderType)){
            System.out.println("Transferring to" + to.getProvider().getServiceProviderType().toString() + "account");
            if(!to.getVerficicationData().isEmpty()){
                System.out.println("With the following data");
                for(String k : to.getVerficicationData().keySet()){
                    System.out.println(k + ": " + to.getVerficicationData().get(k));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public double inquire(Account acc) {
        Random rand = new Random();
        return rand.nextFloat() * 1000;
    }
    @Override
    public ArrayList<ServiceProviderType> getAvailableTransfers(){
        ArrayList<ServiceProviderType>options = new ArrayList<>();
        options.add(ServiceProviderType.BANK);
        options.add(ServiceProviderType.WALLET);
        return options;
    }

    @Override
    public boolean verifyAccount(Account acc) {
        return true;
    }
}
