package Bills;

import Accounts.Account;

import java.util.HashMap;

public class GasBill extends Bill{
    String CRN;
    HashMap<String, String> deductionData;
    public GasBill(double amount, BillProvider provider, Account account, String CRN) {
        super(amount, provider, account);
        this.CRN = CRN;
        deductionData = new HashMap<>();
        deductionData.put("CRN", this.CRN);
    }

    @Override
    public HashMap<String,String> getDeductionData() {
        return this.deductionData;
    }
}
