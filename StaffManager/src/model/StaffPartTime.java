package model;

import java.io.Serializable;


public class StaffPartTime extends Staff implements Serializable {
    private double salaryPerHour;
    private double workingHourPerMoth;


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

    @Override
    public String toString() {
        return "StaffPartTime{ Id=" +super.getStaffId() + ", Name=" + super.getStaffName() + ", Age= " + super.getStaffAge() +
                ", Gender=" + super.getStaffGender() + ", PhoneNumber=" + super.getStaffPhoneNumber() + ", Email=" + super.getStaffEmail() +
                ", Address="+super.getStaffAddress() + ", StartDay=" + super.getStartDay() + ", Status=" + super.isStaffStatus() +
                ", salaryPerHour=" + salaryPerHour +", workingHourPerMoth=" + workingHourPerMoth +'}';
    }
}
