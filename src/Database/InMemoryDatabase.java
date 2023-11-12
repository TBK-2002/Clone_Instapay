package Database;

import Accounts.Account;
import Bills.BillProvider;
import Bills.BillProviderType;
import Services.ServiceProvider;
import Services.ServiceProviderType;

import java.util.HashMap;

public class InMemoryDatabase implements Database {

    @Override
    public Account getAccount(String username) {
        return null;
    }

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void addBillProvider(BillProvider billProvider) {

    }

    @Override
    public HashMap<String, BillProvider> getBillProviders(BillProviderType billProviderType) {
        return null;
    }

    @Override
    public void addServiceProvider(ServiceProvider serviceProvider) {

    }

    @Override
    public HashMap<String, ServiceProvider> getServiceProviders(ServiceProviderType serviceProviderType) {
        return null;
    }
}
