package Services;

import Accounts.Account;

public interface ServiceProviderBehavior {
    public boolean transfer(Account from, Account to, String address, double amount);
    public double inquire(Account acc);
    public boolean verifyAccount(Account acc);
}
