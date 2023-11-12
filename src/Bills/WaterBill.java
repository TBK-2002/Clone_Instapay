package Bills;

import Accounts.Account;

public class WaterBill extends Bill{
    public WaterBill(double amount, BillProvider provider, Account account) {
        super(amount, provider, account);
    }

    @Override
    public String getDeductionData() {
        return null;
    }
}
