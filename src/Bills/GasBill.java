package Bills;

import Accounts.Account;

public class GasBill extends Bill{

    public GasBill(double amount, BillProvider provider, Account account) {
        super(amount, provider, account);
    }

    @Override
    public String getDeductionData() {
        return null;
    }
}
