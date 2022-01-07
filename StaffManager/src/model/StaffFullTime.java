package model;

import java.io.Serializable;
import java.time.LocalDate;

public class StaffFullTime extends Staff implements Serializable {
    private double baseSalary;
    public double bonus;
    public double rankSalary;

    public StaffFullTime() {
    }

    public StaffFullTime(int staffId, String staffName, int staffAge, String staffGender, String staffPhoneNumber, String staffEmail, String staffAddress, String startDay, boolean staffStatus, double baseSalary, double bonus, double rankSalary) {
        super(staffId, staffName, staffAge, staffGender, staffPhoneNumber, staffEmail, staffAddress, startDay, staffStatus);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.rankSalary = rankSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getRankSalary() {
        return rankSalary;
    }

    public void setRankSalary(double rankSalary) {
        this.rankSalary = rankSalary;
    }

    public String display() {
        return super.getStaffId() + "," + super.getStaffName() + "," + super.getStaffAge() + "," +
                super.getStaffGender() + "," + super.getStaffPhoneNumber() + "," + super.getStaffEmail() +
                super.getStaffAddress() + "," + super.getStartDay() + "," + super.isStaffStatus() +
                baseSalary + "," + bonus + "," + rankSalary + "\n";
    }
}
