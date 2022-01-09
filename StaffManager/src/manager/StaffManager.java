package manager;

import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;
import readandwritefile.IOFile;
import regex.RegexEmail;
import regex.RegexPhoneNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffManager {


    Scanner scanner = new Scanner(System.in);
    private final IOFile<Staff> ioFile = new IOFile<>();
    private final ArrayList<Staff> staffList = getStaffs();
    private final String PATHNAME_OF_STAFF_INF = "src/file/StaffList";

    public StaffManager() {
    }

    public ArrayList<Staff> getStaffs() {
        return ioFile.readFileData(PATHNAME_OF_STAFF_INF);
    }

    public void addStaff() {
        Staff newStaff = creatStaff();
        this.staffList.add(newStaff);
        writeStaffList(staffList);
    }

    public Staff creatStaff() {
        boolean checkId;
        int staffId;
        do{
            System.out.println("Enter staff Id:");
            staffId = scanner.nextInt();
            scanner.nextLine();
            checkId = isExistId(staffId);
        }while (!checkId);
        System.out.println("Enter staff name:");
        String staffName = scanner.nextLine();
        System.out.println("Enter staff age:");
        int staffAge = scanner.nextInt();
        scanner.nextLine();
        String gender = setGender();
        boolean checkPhoneNumber;
        String phoneNumber;
        do {
            System.out.println("Enter staff phone number :");
            phoneNumber = scanner.nextLine();
            checkPhoneNumber = RegexPhoneNumber.validate(phoneNumber);
        }while (!checkPhoneNumber);
        boolean checkEmail;
        String email;
        do {
            System.out.println("Enter staff email:");
            email = scanner.nextLine();
            checkEmail = RegexEmail.validate(email);
        }while (!checkEmail);
        System.out.println("Enter staff address:");
        String address = scanner.nextLine();
        System.out.println("Enter staff start day:");
        String startDay = scanner.nextLine();
        boolean status = setStaffStatus();
        String staffType = setStaffType();
        if (staffType.equals("Full time")) {
            System.out.println("Enter staff base salary");
            double baseSalary = scanner.nextDouble();
            System.out.println("Enter staff bonus");
            double bonus = scanner.nextDouble();
            System.out.println("Enter staff rank salary");
            double rankSalary = scanner.nextDouble();
            scanner.nextLine();
            return new StaffFullTime(staffId, staffName, staffAge, gender, phoneNumber, email, address, startDay, status, baseSalary, bonus, rankSalary);
        } else {
            System.out.println("Enter staff salary per hour");
            double salaryPerHour = scanner.nextDouble();
            System.out.println("Enter staff working per month");
            double workingHourPerMonth = scanner.nextDouble();
            scanner.nextLine();
            return new StaffPartTime(staffId, staffName, staffAge, gender, phoneNumber, email, address, startDay, status, salaryPerHour, workingHourPerMonth);
        }

    }
    private boolean isExistId(int staffId) {
        for (Staff staff: staffList) {
            if(staff.getStaffId()==staffId){
                System.out.println("This Id already exists");
                return false;
            }
        }
        return true;
    }
    private String setStaffType() {
        int choiceType ;
        do {
            System.out.println("Enter staff type:");
            System.out.println("1.Full time");
            System.out.println("2.Past time");
            System.out.println("0.Exit");
            System.out.println("Enter your choice:");
            choiceType = scanner.nextInt();
            scanner.nextLine();
            switch (choiceType) {
                case 1:
                    return "Full time";
                case 2:
                    return "Past time";
            }
        } while (choiceType != 0);
        return "Full time";
    }

    private Boolean setStaffStatus() {
        int choiceStatus;
        do {
            System.out.println("Choice staff status:");
            System.out.println("1.Working");
            System.out.println("2.Retired");
            System.out.println("0.Exit");
            System.out.println("Enter your choice:");
            choiceStatus = scanner.nextInt();
            scanner.nextLine();
            switch (choiceStatus) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
        } while (choiceStatus != 0);
        return true;
    }

    public String setGender() {
        System.out.println("Choice staff gender:");
        System.out.println("1.Female");
        System.out.println("2.Male");
        System.out.println("3.Other");
        System.out.println("Enter your choice:");
        String gender ;
        int choiceGender = scanner.nextInt();
        scanner.nextLine();
        if (choiceGender == 1) {
            gender = "Female";
        } else if (choiceGender == 2) {
            gender = "Male";
        } else {
            gender = "Other";
        }
        return gender;
    }

    public void writeStaffList(ArrayList<Staff> staffList) {
        ioFile.writerFileData(staffList, PATHNAME_OF_STAFF_INF);
    }

    public ArrayList<Staff> readStaffList() {
        return ioFile.readFileData(PATHNAME_OF_STAFF_INF);
    }

    public void deleteStaff(int deleteIndex) {
        staffList.remove(deleteIndex);
        writeStaffList(staffList);
    }

    public ArrayList<Staff> findStaffByName(String name) {
        ArrayList<Staff> findStaffList = new ArrayList<>();
        for (Staff staff : staffList) {
            if (staff.getStaffName().equals(name)) {
                findStaffList.add(staff);
            }
        }
        return findStaffList;
    }

    public ArrayList<Staff> displayStaffByStaffStatus() {
        ArrayList<Staff> displayList = new ArrayList<>();
        int choice ;
        do {
            System.out.println("Enter Status to display");
            System.out.println("1.Working");
            System.out.println("2.Retied");
            System.out.println("0.Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    for (Staff staff : getStaffs()) {
                        if (staff.isStaffStatus()) {
                            displayList.add(staff);
                        }
                    }
                    return displayList;
                case 2:
                    for (Staff staff : getStaffs()) {
                        if (!staff.isStaffStatus()) {
                            displayList.add(staff);
                        }
                    }
                    return displayList;
            }
        } while (choice != 0);
        return displayList;
    }

    public void checkStaffStatusByName(String name) {
        for (Staff staff : getStaffs()) {
            if (staff.getStaffName().equals(name)) {
                if (staff.isStaffStatus()) {
                    System.out.println("Staff "+name+(" Id ")+staff.getStaffId()+" is working");
                } else {
                    System.out.println("Staff "+name+(" Id ")+staff.getStaffId()+" was retired");
                }
            }
        }
    }

    public void updateStaffStatusById(int id) {
        boolean checkId = false;
        int updateIndex = -1;
        for (int i = 0; i < getStaffs().size(); i++) {
            if (getStaffs().get(i).getStaffId() == id) {
                checkId = true;
                updateIndex = i;
            }
        }
        if (checkId) {
            if (staffList.get(updateIndex).isStaffStatus()) {
                staffList.get(updateIndex).setStaffStatus(false);
                writeStaffList(staffList);
                System.out.println(staffList.get(updateIndex));
                System.out.println("Update Status successful!");
            } else {
                System.out.println("This staff is retied");
            }
        } else {
            System.out.println("This Id no exist!");
        }
    }

    public void updateStaffInformation() {
        System.out.println("Enter Staff id to update information");
        int updateId = scanner.nextInt();
        int updateIndex = -1;
        boolean checkId = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getStaffId() == updateId) {
                updateId = i;
                checkId = true;
            }
        }
        if(checkId){
            int choice;
            do {
                System.out.println("-----Enter new information-----");
                System.out.println("-------------------------------");
                System.out.println("-------Enter you choice--------");
                System.out.println("    1.Change staff id");
                System.out.println("    2.Change staff Start day");
                System.out.println("    3.Change staff salary");
                System.out.println("    0.Exit");
                System.out.println("-------------------------------");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new id:");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        staffList.get(updateIndex).setStaffId(newId);
                        break;
                    case 2:
                        System.out.println("Enter new start day:");
                        String startDay = scanner.nextLine();
                        scanner.nextLine();
                        staffList.get(updateIndex).setStartDay(startDay);
                        break;
                    case 3:
                        if(staffList.get(updateIndex) instanceof StaffFullTime){
                            System.out.println("Enter new base salary");
                            double newBaseSalary = scanner.nextDouble();
                            ((StaffFullTime) staffList.get(updateIndex)).setBaseSalary(newBaseSalary);
                            System.out.println("Enter new bonus");
                            double newBonus = scanner.nextDouble();
                            ((StaffFullTime) staffList.get(updateIndex)).setBonus(newBonus);
                            System.out.println("Enter new rank salary");
                            double newRankSalary = scanner.nextDouble();
                            ((StaffFullTime) staffList.get(updateIndex)).setRankSalary(newRankSalary);
                        }else if(staffList.get(updateIndex) instanceof StaffPartTime){
                            System.out.println("Enter new salary per hour");
                            double newSalaryPerHour = scanner.nextDouble();
                            ((StaffPartTime) staffList.get(updateIndex)).setSalaryPerHour(newSalaryPerHour);
                            System.out.println("Enter new working hour per month");
                            double newWorkingHourPerMonth = scanner.nextDouble();
                            scanner.nextLine();
                            ((StaffPartTime) staffList.get(updateIndex)).setWorkingHourPerMoth(newWorkingHourPerMonth);
                        }
                        break;
                }
            } while (choice != 0);
            writeStaffList(staffList);
            System.out.println("Update information successful");
        }
    }

    public void calculatorStaffSalary(){
        ArrayList<Double> salaryList= new ArrayList<>();
        for (Staff staff:staffList) {
            if (staff instanceof StaffFullTime){
                salaryList.add(((StaffFullTime) staff).getBaseSalary()*((StaffFullTime) staff).getRankSalary()+((StaffFullTime) staff).getBonus());
            }else if(staff instanceof StaffPartTime){
                salaryList.add(((StaffPartTime) staff).getSalaryPerHour()*((StaffPartTime) staff).getWorkingHourPerMoth());
            }
        }

        int length = salaryList.size();
        double totalSalary = 0;
        for (Double aDouble : salaryList) {
            totalSalary += aDouble;
        }
        System.out.println("Total all Staff Salary: "+ totalSalary);
        for (int i = 0; i < length; i++) {
            System.out.printf("Staff Id: %s has salary: %s",staffList.get(i).getStaffId(),salaryList.get(i));
            System.out.println();
        }
    }
}
