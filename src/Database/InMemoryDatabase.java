package Database;

import Accounts.Account;
import Bills.BillProvider;
import Bills.BillProviderType;
import Services.*;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase implements Database {
    protected HashMap<String,Account> accounts;
    protected HashMap<String,ServiceProvider> serviceProviders;
    protected HashMap<String,BillProvider>billProviders;


    public InMemoryDatabase() {
        this.accounts = new HashMap<>();
        this.serviceProviders = new HashMap<>();
        this.billProviders = new HashMap<>();
        demoData();
    }
    void demoData(){

        ServiceProviderBehavior serviceProviderBehavior1 = new Wallet();
        ServiceProviderBehavior serviceProviderBehavior2 = new Bank();
        ServiceProvider vodafoneCash = new ServiceProvider("VodafoneCash.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider fawry = new ServiceProvider("Fawry.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider orangeCash = new ServiceProvider("OrangeCash.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider CIBWallet = new ServiceProvider("CIBWallet.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider CIB = new ServiceProvider("CIB.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        ServiceProvider HSBC = new ServiceProvider("HSBC.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        ServiceProvider Ahly = new ServiceProvider("Ahly.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        ServiceProvider Misr = new ServiceProvider("Misr.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        serviceProviders.put(vodafoneCash.getAddress(),vodafoneCash);
        serviceProviders.put(fawry.getAddress(),fawry);
        serviceProviders.put(orangeCash.getAddress(),orangeCash);
        serviceProviders.put(CIBWallet.getAddress(),CIBWallet);
        serviceProviders.put(CIB.getAddress(),CIB);
        serviceProviders.put(HSBC.getAddress(),HSBC);
        serviceProviders.put(Ahly.getAddress(),Ahly);
        serviceProviders.put(Misr.getAddress(),Misr);


    }
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

    @Override
    public Account getAccountBankNumber(String bankNumber) {
        for (Map.Entry<String,Account> entry: accounts.entrySet()){
            if(entry.getValue().getVerficicationData().get("accountNumber").equals(bankNumber))
                return entry.getValue();
        }
        return null;
    }

    @Override
    public Account getAccountMobileNumber(String mobileNumber) {
        for (Map.Entry<String,Account> entry: accounts.entrySet()){
            if(entry.getValue().getVerficicationData().get("mobileNumber").equals(mobileNumber))
                return entry.getValue();
        }
        return null;
    }
}
