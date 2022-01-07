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

public class RunByAdmin {
    private final IOFile<Staff> ioFile = new IOFile<>();
    private final AccountManager accountManager = new AccountManager();
    private final StaffManager staffManager = new StaffManager();
    private final ArrayList<Account> adminAccounts = accountManager.getAdminAccountList();
    private final ArrayList<Account> userAccounts = accountManager.getUserAccountList();
    private final ArrayList<Staff> staffs = staffManager.getStaffs();
    Scanner scanner = new Scanner(System.in);

    public RunByAdmin() {

    }

    public ArrayList<Account> getAdminAccounts() {
        return adminAccounts;
    }

    public ArrayList<Account> getUserAccounts() {
        return accountManager.getUserAccountList();
    }

    public ArrayList<Staff> getStaffs() {
        return staffManager.getStaffs();
    }

    public void addStaffWithNewAccount() {
        accountManager.addUserAccount();
        staffManager.addStaff();
        System.out.println("Add successful");
    }

    public void displayAllStaffByStaffType(int choice) {
        ArrayList<Staff> displayStaffList = new ArrayList<>();
        if (choice == 1) {
            for (Staff staff : staffs) {
                if (staff instanceof StaffFullTime) {
                    displayStaffList.add(staff);
                }
            }
        } else {
            for (Staff staff : staffs) {
                if (staff instanceof StaffPartTime) {
                    displayStaffList.add(staff);
                }
            }
        }

        for (Staff staff : displayStaffList) {
            System.out.println(staff);
        }
    }

    public void displayAllStaff() {
        int length= getStaffs().size();
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(getUserAccounts().get(i));
            System.out.println(getStaffs().get(i));
        }
    }

    public void displayStaffByStaffStatus(){
        ArrayList<Staff> displayStaffs = staffManager.displayStaffByStaffStatus();
        for (Staff staff: displayStaffs) {
            System.out.println(staff.toString());
        }
    }
    public void checkStaffStatusByName(){
        System.out.println("Enter the staff name to check status");
        String name = scanner.nextLine();
        staffManager.checkStaffStatusByName(name);
    }

    public void updateStatusById(){
        System.out.println("Enter the staff id to update");
        int id = scanner.nextInt();
        scanner.nextLine();
        staffManager.updateStaffStatusById(id);
    }

    public String deleteStaffById(){
        System.out.println("Enter the id to delete");
        int id = scanner.nextInt();
        boolean idExistCheck = false;
        int deleteIndex = -1;
        scanner.nextLine();
        for (Staff staff : getStaffs()) {
            if (staff.getStaffId() == id) {
                idExistCheck = true;
                deleteIndex = 1;
                break;
            }
        }
        if(idExistCheck){
            staffManager.deleteStaff(deleteIndex);
            accountManager.deleteUserAccount(deleteIndex);
            return "Delete successful";
        }
        return "This id does not exist";

    }
}
