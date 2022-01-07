package manager;

import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;
import readandwritefile.IOFile;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffManager {


    Scanner scanner = new Scanner(System.in);
    private final IOFile<Staff> ioFile = new IOFile<>();
    private ArrayList<Staff> staffList = getStaffs();
    private final String PATHNAME_OF_STAFF_INF = "src/file/StaffList";

    public StaffManager() {
    }

    public StaffManager(ArrayList<Staff> staffs) {
        staffList = staffs;
    }

    public ArrayList<Staff> getStaffs() {
        return ioFile.readFileData(PATHNAME_OF_STAFF_INF);
    }

    public void addStaff() {
        Staff newStaff = creatStaff();
        this.staffList.add(newStaff);
        writeStaffList(staffList);
        System.out.println(ioFile.readFileData(PATHNAME_OF_STAFF_INF));
    }

    public Staff creatStaff() {
        System.out.println("Enter staff Id:");
        int staffId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter staff name:");
        String staffName = scanner.nextLine();
        System.out.println("Enter staff age:");
        int staffAge = scanner.nextInt();
        scanner.nextLine();
        String gender = setGender();
        System.out.println("Enter staff phone number :");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter staff email:");
        String email = scanner.nextLine();
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

    private String setStaffType() {
        int choiceType = -1;
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
        int choiceStatus = -1;
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
        String gender = "";
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
        int choice = -1;
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
        } while (choice !=0);
        return displayList;
    }

    public void checkStaffStatusByName(String name) {
        for (Staff staff : getStaffs()) {
            if (staff.getStaffName().equals(name)) {
                if (staff.isStaffStatus()) {
                    System.out.println("This Staff is working");;
                } else {
                    System.out.println("This Staff was retired");
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

}
