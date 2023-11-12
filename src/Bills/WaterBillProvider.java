package Bills;

public class WaterBillProvider extends BillProvider{
    @Override
    public boolean deduct(Bill bill) {
        return false;
    }
}
