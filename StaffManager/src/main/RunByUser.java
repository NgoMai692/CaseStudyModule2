package main;

import account.Account;
import manager.AccountManager;
import manager.StaffManager;
import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;
import readandwritefile.IOFile;

import java.util.ArrayList;
import java.util.Scanner;

public class RunByUser {
    private final IOFile<Account> ioFile = new IOFile<>();
    private final IOFile<Staff> ioFile1 = new IOFile<>();
    private final AccountManager accountManager = new AccountManager();
    private final StaffManager staffManager = new StaffManager();
    private final ArrayList<Account> userAccounts = accountManager.readUserAccountList();
    private final ArrayList<Staff> staffs = staffManager.readStaffList();
    private final String PATHNAME_OF_USER_ACCOUNT = "src/file/UserAccount";
    private final String PATHNAME_OF_STAFF_INF = "src/file/StaffList";
    Scanner scanner = new Scanner(System.in);

    public RunByUser() {
    }

    public void displayMyInf(Account displayAccount) {
        int displayIndex = getIndex(displayAccount);
        System.out.println(staffs.get(displayIndex));
    }

    private int getIndex(Account getIndexAccount) {
        int displayIndex = -1;
        for (int i = 0; i < userAccounts.size(); i++) {
            if (userAccounts.get(i).getUserName().equals(getIndexAccount.getUserName())) {
                displayIndex = i;
            }
        }
        return displayIndex;
    }

    public double displayMySalary(Account displayAccount) {
        double totalSalary;
        int displayIndex = getIndex(displayAccount);
        if (staffs.get(displayIndex) instanceof StaffFullTime) {
            totalSalary = ((StaffFullTime) staffs.get(displayIndex)).getBaseSalary() * ((StaffFullTime) staffs.get(displayIndex)).getRankSalary() + ((StaffFullTime) staffs.get(displayIndex)).getBonus();
        } else {
            totalSalary = ((StaffPartTime) staffs.get(displayIndex)).getSalaryPerHour() * ((StaffPartTime) staffs.get(displayIndex)).getWorkingHourPerMoth();
        }
        return totalSalary;
    }

    public void changeMyPassWord(Account changeAccount) {
        int changeIndex = getIndex(changeAccount);
        System.out.println("Enter old password please!");
        String oldPassWord = scanner.nextLine();
        if (changeAccount.getPassWord().equals(oldPassWord)) {
            System.out.println("Enter new passWord please!");
            String newPassWord = scanner.nextLine();
            userAccounts.get(changeIndex).setPassWord(newPassWord);
            ioFile.writerFileData(userAccounts, PATHNAME_OF_USER_ACCOUNT);
            System.out.println(accountManager.readUserAccountList());
            System.out.println("Change password successful");
        } else {
            System.out.println("Old password is wrong, cannot change password ");
        }
    }

    public void updatePersonalInf(Account updateAccount) {
        int updateIndex = getIndex(updateAccount);
        int choice = -1;
        do {
            System.out.println("-----Enter new information-----");
            System.out.println("-------------------------------");
            System.out.println("-------Enter you choice--------");
            System.out.println("    1.Change staff name");
            System.out.println("    2.Change staff age");
            System.out.println("    3.Change staff gender");
            System.out.println("    4.Change staff phone number");
            System.out.println("    5.Change staff email");
            System.out.println("    6.Change staff address");
            System.out.println("    0.Exit");
            System.out.println("-------------------------------");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter new name:");
                    String staffName = scanner.nextLine();
                    staffs.get(updateIndex).setStaffName(staffName);
                    break;
                case 2:
                    System.out.println("Enter new age:");
                    int staffAge = scanner.nextInt();
                    scanner.nextLine();
                    staffs.get(updateIndex).setStaffAge(staffAge);
                    break;
                case 3:
                    String gender = staffManager.setGender();
                    staffs.get(updateIndex).setStaffGender(gender);
                    break;
                case 4:
                    System.out.println("Enter new phone number :");
                    String phoneNumber = scanner.nextLine();
                    staffs.get(updateIndex).setStaffPhoneNumber(phoneNumber);
                    break;
                case 5:
                    System.out.println("Enter staff email:");
                    String email = scanner.nextLine();
                    staffs.get(updateIndex).setStaffEmail(email);
                    break;
                case 6:
                    System.out.println("Enter staff address:");
                    String address = scanner.nextLine();
                    staffs.get(updateIndex).setStaffAddress(address);
                    break;
            }
        } while (choice != 0);
        ioFile1.writerFileData(staffs,PATHNAME_OF_USER_ACCOUNT);
    }

}
