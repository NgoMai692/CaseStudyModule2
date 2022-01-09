package login;

import account.Account;
import main.RunByAdmin;
import main.RunByUser;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    private final RunByAdmin runByAdmin = new RunByAdmin();
    private final RunByUser runByUser = new RunByUser();
    public Login() {
    }

    public void login() {
        System.out.println("------------------------------");
        System.out.println("-----STAFF MANAGER SYSTEM-----");
        System.out.println("----Login Account Please!-----");
        System.out.println("------------------------------");
        System.out.println("    Enter your userName: ");
        String userName = scanner.nextLine();
        System.out.println("    Enter your password:");
        String passWord = scanner.nextLine();
        Account loginAccount = new Account(userName, passWord);
        if (isAdminAccount(loginAccount, runByAdmin.getAdminAccounts())) {
            adminLogin();
        } else if (isUserAccount(loginAccount, runByAdmin.getUserAccounts())) {
            userLogin(loginAccount);
        } else {
            System.out.println("This account does not exist or entered the wrong password, please login again!");
        }
    }
    private void userLogin(Account loginAccount) {
        int userChoice ;
        do {
            welcomeStaffScreen();   //input command: 1-info, 2-salary, 3-password change, 4-update info, 0-exit
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    runByUser.displayMyInf(loginAccount);
                    break;
                case 2:
                    System.out.println("Your total salary is: " + runByUser.displayMySalary(loginAccount));
                    break;
                case 3:
                    runByUser.changeMyPassWord(loginAccount);
                    break;
                case 4:
                    runByUser.updatePersonalInf(loginAccount);
                    break;
            }
        } while (userChoice != 0);
    }
//Function to display user command: 1-info, 2-salary, 3-password change, 4-update info, 0-exit
    private void welcomeStaffScreen() {
        System.out.println("---------------------------------");
        System.out.println("-----Welcome Staff to System-----");
        System.out.println("---------------------------------");
        System.out.println("    1.Display my information");
        System.out.println("    2.Display my salary");
        System.out.println("    3.Change password");
        System.out.println("    4.Update personal information");
        System.out.println("    0.Exit");
        System.out.println("---------------------------------");
        System.out.println("-------Enter your choice:--------");
    }

    private void adminLogin() {
        int adminChoice ;
        do {
            welcomeAdminScreen();   //input command: 1-All staff info, 2-Staff status, 3-Check Staff of status by name, 4-Add staff
                                    //5-Update status, 6-Update info, 7-Salary, 8-Delete staff, 9-Search staff, 0-exit
            adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1:
                    runByAdmin.displayAllStaff();
                    break;
                case 2:
                    runByAdmin.displayStaffByStaffStatus();
                    break;
                case 3:
                    runByAdmin.checkStaffStatusByName();
                    break;
                case 4:
                    runByAdmin.addStaffWithNewAccount();
                    break;
                case 5:
                    runByAdmin.updateStatusById();
                    break;
                case 6:
                    runByAdmin.updateStaffInfByAdmin();
                    break;
                case 7:
                    runByAdmin.calculatorStaffSalary();
                    break;
                case 8:
                    System.out.println(runByAdmin.deleteStaffById());
                    break;
                case 9:
                    runByAdmin.findStaffByName();
                    break;
                case 10:
                    int choiceType;
                    do{
                        System.out.println("----------------------");
                        System.out.println("Enter Staff type");
                        System.out.println("1. Staff Full Time");
                        System.out.println("2. Staff Part Time");
                        System.out.println("0. Exit");
                        System.out.println("Enter you choice");
                        choiceType = scanner.nextInt();
                        scanner.nextLine();
                        switch (choiceType){
                            case 1:
                                runByAdmin.displayAllStaffByStaffType(1);
                                break;
                            case 2:
                                runByAdmin.displayAllStaffByStaffType(2);
                                break;
                        }
                    }while (choiceType!=0);

                    break;
            }
        } while (adminChoice != 0);
    }

    //Function to display Admin command:
    //1-All staff info, 2-Staff status, 3-Check Staff of status by name, 4-Add staff
    //5-Update status, 6-Update info, 7-Salary, 8-Delete staff, 9-Search staff, 0-exit
    private void welcomeAdminScreen() {
        System.out.println("-------------------------------------------");
        System.out.println("---Welcome Admin to Staff Manager System---");
        System.out.println("-------------------------------------------");
        System.out.println("    1.Display all Staff");
        System.out.println("    2.Display Staff by status");
        System.out.println("    3.Check Staff of status by name");
        System.out.println("    4.Add a Staff");
        System.out.println("    5.Update Staff status by Id");
        System.out.println("    6.Update Staff information");
        System.out.println("    7.Staff salary calculation");
        System.out.println("    8.Delete Staff by id");
        System.out.println("    9.Search a Staff by name");
        System.out.println("    10.Display Staff by Staff type");
        System.out.println("    0.Exit");
        System.out.println("-------------------------------------------");
        System.out.println("-------------Enter your choice:------------");
    }

    public boolean isAdminAccount(Account checkAccount, ArrayList<Account> adminAccountList) {
        for (Account adminAccount : adminAccountList) {
            if (adminAccount.getUserName().equals(checkAccount.getUserName()) && adminAccount.getPassWord().equals(checkAccount.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserAccount(Account checkAccount, ArrayList<Account> userAccountList) {
        for (Account userAccount : userAccountList) {
            if (userAccount.getUserName().equals(checkAccount.getUserName()) && userAccount.getPassWord().equals(checkAccount.getPassWord())) {
                return true;
            }
        }
        return false;
    }

}
