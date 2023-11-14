package Database;

import Accounts.Account;
import Bills.BillProvider;
import Bills.BillProviderType;
import Services.ServiceProvider;
import Services.ServiceProviderType;

import java.util.HashMap;

public interface Database {

    public Account getAccount(String username);
    public Account getAccountWith(String value);
    public void addAccount(Account account);
    public void addBillProvider(BillProvider billProvider);
    public HashMap<String,BillProvider> getBillProviders(BillProviderType billProviderType);
    public void addServiceProvider(ServiceProvider serviceProvider);
    public HashMap<String,ServiceProvider> getServiceProviders(ServiceProviderType serviceProviderType);
    public Account getAccountBankNumber(String bankNumber);
    public Account getAccountMobileNumber(String mobileNumber);
}
