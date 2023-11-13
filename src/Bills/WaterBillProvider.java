package Bills;

public class WaterBillProvider extends BillProvider{
    @Override
    public boolean deduct(Bill bill) {
        if(bill.getAccount().getProvider().transfer(bill.getAccount(), super.getAccount(), bill.getAmount())){
            try {
                // Reach the bill provider to deduct the bill
                // send(address, bill.getDeductionData()["electronicPaymentBill"], bill.getAmount());
                return true;
            } catch (Exception e) {
                System.out.println("The Bill provider is not responding.");
                // Reverse the transaction
                bill.getAccount().getProvider().transfer(super.getAccount(), bill.getAccount(), bill.getAmount());
                return false;
            }
        }
        else{
            System.out.println("The transaction was not successful. Please check your balance and try again.");
            return false;
        }
    }
}
