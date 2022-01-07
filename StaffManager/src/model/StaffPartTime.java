package model;

import java.io.Serializable;
import java.time.LocalDate;

public class StaffPartTime extends Staff implements Serializable {
    private double salaryPerHour;
    private double workingHourPerMoth;

    public StaffPartTime() {
    }

    public StaffPartTime(int staffId, String staffName, int staffAge, String staffGender, String staffPhoneNumber, String staffEmail, String staffAddress, String startDay, boolean staffStatus, double salaryPerHour, double workingHourPerMoth) {
        super(staffId, staffName, staffAge, staffGender, staffPhoneNumber, staffEmail, staffAddress, startDay, staffStatus);
        this.salaryPerHour = salaryPerHour;
        this.workingHourPerMoth = workingHourPerMoth;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public double getWorkingHourPerMoth() {
        return workingHourPerMoth;
    }

    public void setWorkingHourPerMoth(double workingHourPerMoth) {
        this.workingHourPerMoth = workingHourPerMoth;
    }

    public String display() {
        return super.getStaffId() + "," + super.getStaffName() + "," + super.getStaffAge() + "," +
                super.getStaffGender() + "," + super.getStaffPhoneNumber() + "," + super.getStaffEmail() +
                super.getStaffAddress() + "," + super.getStartDay() + "," + super.isStaffStatus() +
                salaryPerHour + "," + workingHourPerMoth + "\n";
    }
}
