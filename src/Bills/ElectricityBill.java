package Bills;

import Accounts.Account;

public class ElectricityBill extends Bill{
    public ElectricityBill(double amount, BillProvider provider, Account account) {
        super(amount, provider, account);
    }

    @Override
    public String getDeductionData() {
        return null;
    }
}
