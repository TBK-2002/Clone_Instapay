package Services;

import Accounts.Account;

public class Wallet implements ServiceProviderBehavior {

    @Override
    public void transfer(Account from, Account to, String address, double amount) {

    }

    @Override
    public void inquire(Account acc) {

    }

    @Override
    public boolean verifyAccount(Account acc) {
        return false;
    }
}
