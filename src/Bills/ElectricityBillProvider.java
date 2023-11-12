package Bills;

public  class ElectricityBillProvider extends BillProvider {

    @Override
    public boolean deduct(Bill bill) {
        return false;
    }
}
