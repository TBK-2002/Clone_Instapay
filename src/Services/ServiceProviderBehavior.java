package Services;

import Accounts.Account;

public interface ServiceProviderBehavior {
    public boolean transfer(Account from, Account to, String address, double amount);
    public void inquire(Account acc);
    public boolean verifyAccount(Account acc);
}
