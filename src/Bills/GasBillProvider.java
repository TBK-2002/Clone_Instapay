package Bills;

public  class GasBillProvider extends BillProvider{

    @Override
    public boolean deduct(Bill bill) {
        return false;
    }
}
