package Services;

import Accounts.Account;

public class ServiceProvider {
    public String address;
    private ServiceProviderBehavior serviceProviderBehavior;
    public ServiceProviderType serviceProviderType;
    public boolean transfer(Account from, Account to, double amount) {
        return serviceProviderBehavior.transfer(from,to,address,amount);
    }
}
