import Accounts.Account;
import Accounts.AccountFactory;
import Accounts.BankAccount;
import Accounts.WalletAccount;
import Bills.Bill;
import Bills.BillProvider;
import Bills.BillProviderType;
import Database.Database;
import Database.InMemoryDatabase;
import Services.ServiceProvider;
import Services.ServiceProviderType;

import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    private Database dbManager;
    private Account loggerdInAccount;

    private Scanner input;
    public Manager(){
        dbManager = new InMemoryDatabase();
        loggerdInAccount = null;
        input = new Scanner(System.in);
        System.out.println("Welcome to our InstaPay clone");
    }
    private Account login(){
        System.out.println("__________Login__________");
        System.out.print("Enter your username : ");
        String username = input.nextLine();
        System.out.print("Enter your password : ");
        String password = input.nextLine();
        Account account = dbManager.getAccount(username);
        if(account == null){
            System.out.println("Account not found");
            return null;
        }
        if(account.getPassword().equals(password)){
            loggerdInAccount = account;
            System.out.println("Welcome back mr./mrs. " + account.getUserName());
            return account;
        }
        else{
            System.out.println("Wrong password");
            return null;
        }
    }
    private String generateOTP(){
        return "1234";
    }
    private Account register(){
        System.out.println("_________Register_________");
        System.out.print("Enter your username : ");
        String username = input.nextLine();
        System.out.print("Enter your password : ");

        String password = input.nextLine();

        // complex password using regex
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+!=])"
                + "(?=\\S+$).{8,20}$";
        while (!password.matches(regex)){
            System.out.println("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit and one special character");
            System.out.print("Enter your password : ");
            password = input.nextLine();
        }
        System.out.print("Enter your mobile number : ");
        String mobileNumber = input.nextLine();
        if(dbManager.getAccountWith(mobileNumber) != null){
            System.out.println("Account with this mobile number already exists");
            return null;
        }
        String OTP = generateOTP();
        System.out.print("Enter OTP which sent to your phone : ");
        String userOTP = input.nextLine();
        int err = 0;
        while (!userOTP.equals(OTP) && err < 3){
            System.out.println("Wrong OTP , try again : ");
            userOTP = input.nextLine();
            err++;
        }
        if(err == 3){
            System.out.println("Too many wrong OTPs");
            return null;
        }
        System.out.println("Choose type of account : ");
        int i = 1;
        for(ServiceProviderType serviceProviderType : ServiceProviderType.values()){
            System.out.println(i + ". " + serviceProviderType);
            i++;
        }
        System.out.print("Enter your choice : ");
        int choice = Integer.parseInt(input.nextLine());
        err = 0;
        while ((choice > i || choice < 1) && err < 3){
            System.out.println("Wrong choice , try again : ");
            choice = Integer.parseInt(input.nextLine());
            err++;
        }
        if(err == 3){
            System.out.println("Too many wrong choices");
            return null;
        }
        ServiceProviderType type = null ;
        String BankAccountNumber = null;
        i = 1;
        for(ServiceProviderType serviceProviderType : ServiceProviderType.values()){
            if(i == choice){
                type = serviceProviderType;
                break;
            }
            i++;
        }
        HashMap<String, ServiceProvider> providers = dbManager.getServiceProviders(type);
        System.out.println("Choose your provider : ");
        i = 1;
        for(String providerName : providers.keySet()){
            System.out.println(i + ". " + providerName);
            i++;
        }
        System.out.print("Enter your choice : ");
        choice = Integer.parseInt(input.nextLine());
        err = 0;
        while ((choice > i || choice < 1) && err < 3){
            System.out.println("Wrong choice , try again : ");
            choice = Integer.parseInt(input.nextLine());
            err++;
        }
        if(err == 3){
            System.out.println("Too many wrong choices");
            return null;
        }
        i = 1;
        ServiceProvider provider = null;
        for(String providerName : providers.keySet()){
            if(i == choice){
                provider = providers.get(providerName);
                break;
            }
            i++;
        }

        HashMap<String,String> data = new HashMap<>();
        for(String requiredData : provider.getRequiredData()){
            if(requiredData.equals("mobile number")) {
                continue;
            }
            System.out.print("Enter " + requiredData + " : ");
            String value = input.nextLine();
            if(dbManager.getAccountWith(value) != null){
                System.out.println("Account with this " + requiredData + " already exists");
                return null;
            }
            data.put(requiredData, value);
        }
        data.put("mobile Number",mobileNumber);
        data.put("username",username);
        data.put("password",password);
        Account account = AccountFactory.createAccount(provider,data);
        if(provider.verifyAccount(account)){
            System.out.println("Account verified successfully");
        }else{
            System.out.println("Account verification failed");
            return null;
        }
        System.out.println("Welcome mr./mrs. " + account.getUserName() + " to our InstaPay clone");
        dbManager.addAccount(account);
        return account;
    }
    private void logout(){
        loggerdInAccount = null;
    }
    private void inquireBalance(){
        System.out.println("_____Inquire Balance_____");
        System.out.println("Your balance is : " + loggerdInAccount.getProvider().inquire(loggerdInAccount));
    }
    private void payBill(){
        System.out.println("_________Pay Bill_________");
        System.out.println("Choose the bill type : ");
        int i = 1;
        for(BillProviderType billProviderType : BillProviderType.values()){
            System.out.println(i + ". " + billProviderType);
            i++;
        }
        System.out.print("Enter your choice : ");
        int choice = Integer.parseInt(input.nextLine());
        int err = 0;
        while ((choice > i || choice < 1) && err < 3){
            System.out.println("Wrong choice , try again : ");
            choice = Integer.parseInt(input.nextLine());
            err++;
        }
        if(choice > i || choice < 1){
            System.out.println("Too many wrong choices");
            return;
        }
        i = 1;
        BillProviderType type = null;
        for(BillProviderType billProviderType : BillProviderType.values()){
            if(i == choice){
                type = billProviderType;
                break;
            }
            i++;
        }
        HashMap<String, BillProvider> providers = dbManager.getBillProviders(type);
        System.out.println("Choose your provider : ");
        i = 1;
        for(String providerName : providers.keySet()){
            System.out.println(i + ". " + providerName);
            i++;
        }
        System.out.print("Enter your choice : ");
        choice = Integer.parseInt(input.nextLine());
        err = 0;
        while ((choice > i || choice < 1) && err < 3){
            System.out.println("Wrong choice , try again : ");
            choice = Integer.parseInt(input.nextLine());
            err++;
        }
        if(choice > i || choice < 1){
            System.out.println("Too many wrong choices");
            return;
        }
        i = 1;
        BillProvider provider = null;
        for(String providerName : providers.keySet()){
            if(i == choice){
                provider = providers.get(providerName);
                break;
            }
            i++;
        }
        HashMap<String, String> data = new HashMap<>();
        for(String requiredData : provider.getRequiredData()){
            System.out.print("Enter " + requiredData + " : ");
            String value = input.nextLine();
            data.put(requiredData, value);
        }
        Bill bill = provider.createBill(loggerdInAccount, data);
        if(bill == null){
            System.out.println("Your Bill is not found.");
            return;
        }
        System.out.println("Your bill amount is : " + bill.getAmount());
        System.out.print("Enter 1 to confirm : ");
        System.out.print("Enter 2 to cancel : ");
        choice = Integer.parseInt(input.nextLine());
        err = 0;
        while ((choice > 2 || choice < 1) && err < 3){
            System.out.println("Wrong choice , try again : ");
            choice = Integer.parseInt(input.nextLine());
            err++;
        }
        if(choice > 2 || choice < 1){
            System.out.println("Too many wrong choices");
            return;
        }
        if(choice == 2){
            System.out.println("Bill canceled");
            return;
        }
        if(provider.deduct(bill)){
            System.out.println("Bill paid successfully");
        }else{
            System.out.println("Bill payment failed");
        }

    }
    private void unLoggedInMenu(){
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice : ");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice){
            case 1:
                loggerdInAccount = login();
                break;
            case 2:
                loggerdInAccount = register();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    private void transferMenu(){
        int i = 1;
        for(ServiceProviderType spt : loggerdInAccount.getProvider().getAvailableTransfers()){
            System.out.println(i + ". " + spt.toString());
            i++;
        }
        int choice = Integer.parseInt(input.nextLine());
        while (choice > i-1 || choice < 1){
            System.out.println("Wrong choice , try again : ");
            choice = Integer.parseInt(input.nextLine());
        }
        ServiceProviderType chosenSPT = null;
        i = 1;
        for(ServiceProviderType spt : loggerdInAccount.getProvider().getAvailableTransfers()){
            if(i == choice)
                chosenSPT = spt;
            i++;
        }
        ServiceProvider chosenSP = null;
        for(ServiceProvider sp : dbManager.getServiceProviders(chosenSPT).values()){
           chosenSP = sp;
           break;
        }
        if(chosenSP == null){
            System.out.println("No account with this service provider found");
            return;
        }
        Account toAccount = null;
        for(String requiredData : chosenSP.getRequiredData()){
            System.out.print("Enter " + requiredData + " : ");
            String value = input.nextLine();
            Account temp = dbManager.getAccountWith(value);
            if(toAccount == null)
                toAccount = temp;
            else if(toAccount != temp){
                System.out.println("Data doesn't match");
                return;
            }
        }
        if (toAccount == null){
            System.out.println("Account not found");
            return;
        }
        if(toAccount == loggerdInAccount){
            System.out.println("You can't transfer to yourself");
            return;
        }
        System.out.print("Enter the amount : ");
        double amount = Double.parseDouble(input.nextLine());
        if(loggerdInAccount.getProvider().transfer(loggerdInAccount,toAccount,amount)) {
            System.out.println("Transfer done successfully");
        }else{
            System.out.println("Transfer failed");
        }
    }
    private void loggedInMenu(){
        System.out.println("1. Transfer");
        System.out.println("2. Inquire Balance");
        System.out.println("3. Pay bill");
        System.out.println("4. Logout");
        System.out.print("Enter your choice : ");
        int choice = Integer.parseInt(input.nextLine());
        while (choice > 4 || choice < 1){
            System.out.println("Wrong choice , try again : ");
            choice = Integer.parseInt(input.nextLine());
        }
        switch (choice){
            case 1:
                transferMenu();
                break;
            case 2:
                inquireBalance();
                break;
            case 3:
                payBill();
                break;
            case 4:
                logout();
                break;
        }
    }
    public void mainMenu(){
        System.out.println("________Main Menu________");
        if(loggerdInAccount == null){
            unLoggedInMenu();
        }else{
            loggedInMenu();
        }
    }
}
