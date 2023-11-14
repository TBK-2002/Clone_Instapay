package Services;

import Accounts.Account;

import java.util.ArrayList;
import java.util.List;

public interface ServiceProviderBehavior {
    public boolean transfer(Account from, Account to, String address, double amount);
    public List<ServiceProviderType> getAvailableTransfers();
    public double inquire(Account acc);
    public ArrayList<String> getRequiredData() ;

    public boolean verifyAccount(Account acc);
}
