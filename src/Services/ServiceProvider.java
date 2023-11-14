package Services;
import Accounts.Account;
import java.util.ArrayList;
import java.util.List;

public class ServiceProvider {
    private String address;
    private String name;
    private ServiceProviderBehavior serviceProviderBehavior;
    public ServiceProviderType serviceProviderType;
    private List<ServiceProviderType>availableTransfers;

    public ServiceProvider(String name, String address , ServiceProviderType serviceProviderType , ServiceProviderBehavior serviceProviderBehavior){
        this.name = name;
        this.address = address;
        this.serviceProviderBehavior = serviceProviderBehavior;
        this.serviceProviderType = serviceProviderType;
        this.availableTransfers = this.serviceProviderBehavior.getAvailableTransfers();
    }
    public boolean transfer(Account from, Account to, double amount){
        return serviceProviderBehavior.transfer(from,to,address,amount);
    }
    public List<ServiceProviderType> getAvailableTransfers(){
        return this.availableTransfers;
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
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
