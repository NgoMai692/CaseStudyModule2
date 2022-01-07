package manager;

import account.Account;
import model.Staff;
import readandwritefile.IOFile;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
   public Scanner scanner = new Scanner(System.in);
   private final IOFile<Account> ioFile = new IOFile<>();
   private final ArrayList<Account> adminAccountList = creatAdminList();
   private final ArrayList<Account> userAccountList = getUserAccountList();

   private final String PATHNAME_OF_USER_ACCOUNT = "src/file/UserAccount";

   public ArrayList<Account> getAdminAccountList() {
      return adminAccountList;
   }

   public ArrayList<Account> getUserAccountList() {
      return ioFile.readFileData(PATHNAME_OF_USER_ACCOUNT);
   }

   public ArrayList<Account> creatAdminList(){
      ArrayList<Account> adminAccount = new ArrayList<>();
      Account admin1account = new Account("admin1","12345");
      Account admin2account = new Account("admin2","12345");
      adminAccount.add(admin1account);
      adminAccount.add(admin2account);
      return adminAccount;
   }

   public void addUserAccount(){
      Account newAccount = creatUserAccount();
      this.userAccountList.add(newAccount);
      writeUserAccountList(userAccountList);
      System.out.println(ioFile.readFileData(PATHNAME_OF_USER_ACCOUNT));
   }
   public Account creatUserAccount(){
      System.out.println("Enter userName:");
      String userName = scanner.nextLine();
      System.out.println("Enter passWord:");
      String passWord = scanner.nextLine();
      return  new Account(userName,passWord);
   }

   public void writeUserAccountList(ArrayList<Account> userAccountList){
      ioFile.writerFileData(userAccountList,PATHNAME_OF_USER_ACCOUNT);
   }

   public ArrayList<Account> readUserAccountList() {
         return ioFile.readFileData(PATHNAME_OF_USER_ACCOUNT);
   }
   public void deleteUserAccount(int deleteIndex){
      userAccountList.remove(deleteIndex);
      writeUserAccountList(userAccountList);
   }
   public void editUserAccount(){
      System.out.println("Enter userName edit:");
      String editUserName = scanner.nextLine();
      int editIndex = -1;
      for (int i = 0; i < userAccountList.size(); i++) {
         if(userAccountList.get(i).getUserName().equals(editUserName)){
            editIndex = i;
            break;
         }
      }
      Account newAccount = creatUserAccount();
      userAccountList.remove(editIndex);
      userAccountList.add(editIndex,newAccount);
      (new IOFile<Account>()).writerFileData(userAccountList,PATHNAME_OF_USER_ACCOUNT);
   }
}
