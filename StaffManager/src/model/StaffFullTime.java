package model;

import java.io.Serializable;

public class StaffFullTime extends Staff implements Serializable {
    private double baseSalary;
    public double bonus;
    public double rankSalary;


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

    @Override
    public String toString() {
        return "StaffFullTime{Id=" +super.getStaffId() + ", Name=" + super.getStaffName() + ", Age= " + super.getStaffAge() +
                ", Gender=" + super.getStaffGender() + ", PhoneNumber=" + super.getStaffPhoneNumber() + ", Email=" + super.getStaffEmail() +
                ", Address="+super.getStaffAddress() + ", StartDay=" + super.getStartDay() + ", Status=" + super.isStaffStatus() +
                "baseSalary=" + baseSalary +", bonus=" + bonus +", rankSalary=" + rankSalary +'}';
    }
}
