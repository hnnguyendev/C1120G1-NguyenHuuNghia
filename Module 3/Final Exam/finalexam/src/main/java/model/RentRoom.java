package model;

public class RentRoom {

    private Long id;
    private String fullName;
    private String phone;
    private String startDay;
    private PaymentMethod paymentMethod;
    private String note;

    public RentRoom(Long id, String fullName, String phone, String startDay, PaymentMethod paymentMethod, String note) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.startDay = startDay;
        this.paymentMethod = paymentMethod;
        this.note = note;
    }

    public RentRoom(String fullName, String phone, String startDay, PaymentMethod paymentMethod, String note) {
        this.fullName = fullName;
        this.phone = phone;
        this.startDay = startDay;
        this.paymentMethod = paymentMethod;
        this.note = note;
    }

    public RentRoom() {

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
