package Database;

import Accounts.Account;
import Bills.BillProvider;
import Bills.BillProviderType;
import Services.ServiceProvider;
import Services.ServiceProviderType;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase implements Database {
    protected HashMap<String,Account> accounts;
    protected HashMap<String,ServiceProvider> serviceProviders;
    protected HashMap<String,BillProvider>billProviders;

    @Override
    public Account getAccount(String username) {
        return accounts.get(username);
    }

    @Override
    public void addAccount(Account account) {
        accounts.put(account.getUserName(),account);
    }

    @Override
    public void addBillProvider(BillProvider billProvider) {
        billProviders.put(billProvider.getAddress(),billProvider);
    }



    @Override
    public HashMap<String, BillProvider> getBillProviders(BillProviderType billProviderType) {
        HashMap<String,BillProvider> billProviders1 = new HashMap<>();
        for (Map.Entry<String,BillProvider> entry: billProviders.entrySet()){
            if (entry.getValue().getBillProviderType() == billProviderType){
                billProviders1.put(entry.getKey(),entry.getValue());
            }
        }
        return billProviders1;
    }

    @Override
    public void addServiceProvider(ServiceProvider serviceProvider) {
        serviceProviders.put(serviceProvider.getAddress(),serviceProvider);
    }

    @Override
    public HashMap<String, ServiceProvider> getServiceProviders(ServiceProviderType serviceProviderType) {
        HashMap<String,ServiceProvider> serviceProviders1 = new HashMap<>();
        for (Map.Entry<String,ServiceProvider> entry: serviceProviders.entrySet()){
            if (entry.getValue().getServiceProviderType()==serviceProviderType){
                serviceProviders1.put(entry.getKey(), entry.getValue());
            }
        }
        return serviceProviders1;
    }
}
