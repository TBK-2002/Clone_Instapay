package Bills;

import Accounts.Account;

import java.util.HashMap;

public class WaterBill extends Bill{
    String electronicPaymentCode;
    HashMap<String, String> deductionData;
    public WaterBill(double amount, BillProvider provider, Account account, String electronicPaymentCode) {
        super(amount, provider, account);
        this.electronicPaymentCode = electronicPaymentCode;
        deductionData = new HashMap<>();
        deductionData.put("electronicPaymentCode", this.electronicPaymentCode);
    }

    @Override
    public HashMap<String,String> getDeductionData() {
        return this.deductionData;
    }
}
