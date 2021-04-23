package model;

import java.sql.Date;

public class Customer {

    private Long id;
    private String customerCode;
    private String fullName;
    private Date birthday;
    private int gender;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String address;
    private int flag;
    private CustomerType customerType;

    public Customer(Long id, String customerCode, String fullName, Date birthday, int gender, String idNumber, String phoneNumber, String email, String address, int flag, CustomerType customerType) {
        this.id = id;
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.flag = flag;
        this.customerType = customerType;
    }

    public Customer(String customerCode, String fullName, Date birthday, int gender, String idNumber, String phoneNumber, String email, String address, int flag, CustomerType customerType) {
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.flag = flag;
        this.customerType = customerType;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

}
