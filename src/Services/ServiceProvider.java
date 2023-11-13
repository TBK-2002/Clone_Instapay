package Services;
import Accounts.Account;

import Accounts.Account;

public class ServiceProvider {
    private String address;
    private ServiceProviderBehavior serviceProviderBehavior;
    public ServiceProviderType serviceProviderType;

    public ServiceProvider(String address , ServiceProviderType serviceProviderType , ServiceProviderBehavior serviceProviderBehavior){
        this.address = address;
        this.serviceProviderBehavior = serviceProviderBehavior;
        this.serviceProviderType = serviceProviderType;
    }
    public boolean transfer(Account from, Account to, double amount){
        return serviceProviderBehavior.transfer(from,to,address,amount);
    }
    public double inquire(Account acc){
        return serviceProviderBehavior.inquire(acc);
    }
    public boolean verifyAccount(Account acc){
        return serviceProviderBehavior.verifyAccount(acc);
    }
    // getters
    public ServiceProviderType getServiceProviderType(){
        return serviceProviderType;
    }
    public ServiceProviderBehavior getServiceProviderBehavior(){
        return serviceProviderBehavior;
    }
    public String getAddress(){
        return address;
    }
// setters
    public void setServiceProviderType(ServiceProviderType serviceProviderType){
        this.serviceProviderType = serviceProviderType;
    }
    public void setServiceProviderBehavior(ServiceProviderBehavior serviceProviderBehavior){
        this.serviceProviderBehavior = serviceProviderBehavior;
    }
    public void setAddress(String address){
        this.address = address;
    }

}
