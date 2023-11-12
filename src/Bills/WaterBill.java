package Bills;

import Accounts.Account;

import java.util.HashMap;

public class WaterBill extends Bill{
    public WaterBill(double amount, BillProvider provider, Account account) {
        super(amount, provider, account);
    }

    @Override
    public HashMap<String,String> getDeductionData() {
        return null;
    }
}
