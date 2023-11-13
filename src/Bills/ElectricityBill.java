package Bills;

import Accounts.Account;

import java.util.HashMap;

public class ElectricityBill extends Bill{
    String electronicPaymentCode;
    HashMap<String, String> deductionData;
    public ElectricityBill(double amount, BillProvider provider, Account account, String electronicPaymentCode) {
        super(amount, provider, account);
        this.electronicPaymentCode = electronicPaymentCode;
        this.deductionData = new HashMap<>();
        this.deductionData.put("electronicPaymentCode", this.electronicPaymentCode);
    }

    @Override
    public HashMap<String,String> getDeductionData() {
        return this.deductionData;
    }
}
