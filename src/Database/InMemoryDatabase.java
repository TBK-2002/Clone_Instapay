package Database;

import Accounts.Account;
import Accounts.BillProviderAccount;
import Bills.*;
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
        ServiceProvider vodafoneCash = new ServiceProvider("Vodafone Cash","VodafoneCash.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider fawry = new ServiceProvider("Fawry","Fawry.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider orangeCash = new ServiceProvider("Orange Cash","OrangeCash.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider CIBWallet = new ServiceProvider("CIB Wallet","CIBWallet.API", ServiceProviderType.WALLET,serviceProviderBehavior1);
        ServiceProvider CIB = new ServiceProvider("CIB","CIB.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        ServiceProvider HSBC = new ServiceProvider("HSBC","HSBC.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        ServiceProvider Ahly = new ServiceProvider("Ahly Bank","Ahly.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        ServiceProvider Misr = new ServiceProvider("Misr Bank","Misr.API", ServiceProviderType.BANK,serviceProviderBehavior2);
        addServiceProvider(vodafoneCash);
        addServiceProvider(fawry);
        addServiceProvider(orangeCash);
        addServiceProvider(CIBWallet);
        addServiceProvider(CIB);
        addServiceProvider(HSBC);
        addServiceProvider(Ahly);
        addServiceProvider(Misr);
        Account northDeltaAccount = new BillProviderAccount(122,"0123456789","northDelta","123456",fawry, "123456");
        BillProvider northDelta = new ElectricityBillProvider("northDelta","northDelta",northDeltaAccount,BillProviderType.ELECTRICITY);
        Account southDeltaAccount = new BillProviderAccount(123,"0123456789","southDelta","123456",fawry, "12345");
        BillProvider southDelta = new ElectricityBillProvider("southDelta","southDelta",southDeltaAccount,BillProviderType.ELECTRICITY);
        Account petrojet = new BillProviderAccount(124,"0123456789","northCairo","123456",fawry, "1234");
        BillProvider northCairo = new GasBillProvider("northCairo","northCairo",petrojet,BillProviderType.GAS);
        Account aquaDelta = new BillProviderAccount(124,"0123456789","northCairo","123456",fawry, "1234");
        BillProvider southSinai = new WaterBillProvider("southSinai","southSinai",aquaDelta,BillProviderType.WATER);
        addBillProvider(northDelta);
        addBillProvider(southDelta);
        addBillProvider(northCairo);
        addBillProvider(southSinai);

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
        billProviders.put(billProvider.getName(),billProvider);
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
        serviceProviders.put(serviceProvider.getName(),serviceProvider);
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
