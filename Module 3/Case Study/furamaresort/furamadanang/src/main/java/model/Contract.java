package model;

import java.sql.Date;

public class Contract {

    private Long id;
    private Date startDay;
    private Date endDay;
    private double deposit;
    private double totalPay;
    private Employee employee;
    private Customer customer;
    private Service service;

    public Contract() {
    }

    public Contract(Long id, Date startDay, Date endDay, double deposit, double totalPay, Employee employee, Customer customer, Service service) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalPay = totalPay;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Contract(Date startDay, Date endDay, double deposit, double totalPay, Employee employee, Customer customer, Service service) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalPay = totalPay;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
