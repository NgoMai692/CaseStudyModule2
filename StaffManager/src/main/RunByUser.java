package main;

import account.Account;
import manager.AccountManager;
import manager.StaffManager;
import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;

import java.util.ArrayList;
import java.util.Scanner;

public class RunByUser {
    private final AccountManager accountManager = new AccountManager();
    private final StaffManager staffManager = new StaffManager();
    private final ArrayList<Account> userAccounts = accountManager.getUserAccountList();
    private final ArrayList<Staff> staffs = staffManager.readStaffList();
    Scanner scanner = new Scanner(System.in);

    public RunByUser() {
    }

    public void displayMyInf(Account displayAccount){
        int displayIndex = getIndex(displayAccount);
        System.out.println(staffs.get(displayIndex));
    }

    private int getIndex(Account getIndexAccount) {
        int displayIndex = -1;
        for (int i = 0; i < userAccounts.size(); i++) {
            if(userAccounts.get(i).getUserName().equals(getIndexAccount.getUserName())){
                displayIndex = i;
            }
        }
        return displayIndex;
    }

    public double displayMySalary(Account displayAccount){
        double totalSalary;
        int displayIndex = getIndex(displayAccount);
        if(staffs.get(displayIndex) instanceof StaffFullTime){
            totalSalary = ((StaffFullTime) staffs.get(displayIndex)).getBaseSalary()*((StaffFullTime) staffs.get(displayIndex)).getRankSalary()+((StaffFullTime) staffs.get(displayIndex)).getBonus();
        }else {
            totalSalary = ((StaffPartTime) staffs.get(displayIndex)).getSalaryPerHour()*((StaffPartTime) staffs.get(displayIndex)).getWorkingHourPerMoth();
        }
        return totalSalary ;
    }

    public void changeMyPassWord(Account changeAccount){
        System.out.println("Enter old password please!");
        String oldPassWord = scanner.nextLine();
        if(changeAccount.getPassWord().equals(oldPassWord)){
            System.out.println("Enter new passWord please!");
            String newPassWord = scanner.nextLine();
            changeAccount.setPassWord(newPassWord);
            accountManager.writeUserAccountList(userAccounts);
            System.out.println("Change password successful");
        }else {
            System.out.println("Old password is wrong, cannot change password ");
        }
    }

    public void updatePersonalInf(Account updateAccount){
        int updateIndex = getIndex(updateAccount);
        System.out.println("---Enter new information---");
        System.out.println("---------------------------");
        System.out.println("Enter staff name:");
        String staffName = scanner.nextLine();
        staffs.get(updateIndex).setStaffName(staffName);
        System.out.println("Enter staff age:");
        int staffAge = scanner.nextInt();
        scanner.nextLine();
        staffs.get(updateIndex).setStaffAge(staffAge);
        String gender = staffManager.setGender();
        staffs.get(updateIndex).setStaffGender(gender);
        System.out.println("Enter staff phone number :");
        String phoneNumber = scanner.nextLine();
        staffs.get(updateIndex).setStaffPhoneNumber(phoneNumber);
        System.out.println("Enter staff email:");
        String email = scanner.nextLine();
        staffs.get(updateIndex).setStaffEmail(email);
        System.out.println("Enter staff address:");
        String address = scanner.nextLine();
        staffs.get(updateIndex).setStaffAddress(address);
    }

}
