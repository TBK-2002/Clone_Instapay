package Bills;

import Accounts.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public  class GasBillProvider extends BillProvider{
    public GasBillProvider(String name , String address, Account account, BillProviderType providerType) {
        super(address, name, account, providerType);
    }
    @Override
    public boolean deduct(Bill bill) {
        if(bill.getAccount().getProvider().transfer(bill.getAccount(), super.getAccount(), bill.getAmount())){
            try {
                // Reach the bill provider to deduct the bill
                // send(address, bill.getDeductionData()["CRN"], bill.getAmount());
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
    @Override
    public List<String> getRequiredData() {
        return List.of("CRN");
    }
    @Override
    public double inquireAmount(HashMap<String, String> data) {
        try{
            // Reach the bill provider to inquire the amount
            // return inquire(address, data["CRN"]);
            Random rand = new Random();
            return rand.nextFloat() * 1000;
        } catch (Exception e) {
            System.out.println("Error happened. Please Check the CRN and try again.");
            throw e;
        }
    }
}
