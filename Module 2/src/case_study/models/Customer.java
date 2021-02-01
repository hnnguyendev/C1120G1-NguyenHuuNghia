package case_study.models;

public class Customer {

    private String id;
    private String name;
    private String birthday;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private String customerService;

    public Customer() {
    }

    public Customer(String id, String name, String birthday, String gender, String idNumber, String phoneNumber,
                    String email, String customerType, String address, String customerService) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.customerService = customerService;
    }

    public Customer(String[] strings) {
        this.id = strings[0];
        this.name = strings[1];
        this.birthday = strings[2];
        this.gender = strings[3];
        this.idNumber = strings[4];
        this.phoneNumber = strings[5];
        this.email = strings[6];
        this.customerType = strings[7];
        this.address = strings[8];
        this.customerService = strings[9];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerService() {
        return customerService;
    }

    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    @Override
    public String toString() {
        return id + "," +
                name + "," +
                birthday + "," +
                gender + "," +
                idNumber + "," +
                phoneNumber + "," +
                email + "," +
                customerType + "," +
                address + "," +
                customerService;
    }

    public String showInfo() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                ", customerService='" + customerService + '\'' +
                '}';
    }
}
