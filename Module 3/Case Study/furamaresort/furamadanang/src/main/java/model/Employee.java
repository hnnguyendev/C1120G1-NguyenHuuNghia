package model;

import java.sql.Date;

public class Employee {

    private Long id;
    private String fullName;
    private Date birthday;
    private String idNumber;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private int flag;
    private Position position;
    private Education education;
    private Department department;
    private User user;

    public Employee() {
    }

    public Employee(Long id, String fullName, Date birthday, String idNumber, double salary, String phoneNumber, String email, String address, int flag, Position position, Education education, Department department, User user) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.idNumber = idNumber;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.flag = flag;
        this.position = position;
        this.education = education;
        this.department = department;
        this.user = user;
    }

    public Employee(String fullName, Date birthday, String idNumber, double salary, String phoneNumber, String email, String address, int flag, Position position, Education education, Department department, User user) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.idNumber = idNumber;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.flag = flag;
        this.position = position;
        this.education = education;
        this.department = department;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
