package Services;

public class ServiceProvider {
    public String address;
    private ServiceProviderBehavior serviceProviderBehavior;
    public ServiceProviderType serviceProviderType;

    public ServiceProviderType getServiceProviderType() {
        return serviceProviderType;
    }

    public void setServiceProviderType(ServiceProviderType serviceProviderType) {
        this.serviceProviderType = serviceProviderType;
    }
}
