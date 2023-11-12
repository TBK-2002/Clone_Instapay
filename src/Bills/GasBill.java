package Bills;

import Accounts.Account;

import java.util.HashMap;

public class GasBill extends Bill{

    public GasBill(double amount, BillProvider provider, Account account) {
        super(amount, provider, account);
    }

    @Override
    public HashMap<String,String> getDeductionData() {
        return null;
    }
}
