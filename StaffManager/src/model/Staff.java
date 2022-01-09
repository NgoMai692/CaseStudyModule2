package model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int staffId;
    private String staffName;
    private int staffAge;
    private String staffGender;
    private String staffPhoneNumber;
    private String staffEmail;
    private String staffAddress;
    private String startDay;
    private boolean staffStatus;

    public Staff(int staffId, String staffName, int staffAge, String staffGender, String staffPhoneNumber, String staffEmail, String staffAddress, String startDay, boolean staffStatus) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffAge = staffAge;
        this.staffGender = staffGender;
        this.staffPhoneNumber = staffPhoneNumber;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
        this.startDay = startDay;
        this.staffStatus = staffStatus;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(int staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }

    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public boolean isStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(boolean staffStatus) {
        this.staffStatus = staffStatus;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffAge=" + staffAge +
                ", staffGender='" + staffGender + '\'' +
                ", staffPhoneNumber='" + staffPhoneNumber + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", staffAddress='" + staffAddress + '\'' +
                ", startDay='" + startDay + '\'' +
                ", staffStatus=" + staffStatus +
                '}';
    }
}
