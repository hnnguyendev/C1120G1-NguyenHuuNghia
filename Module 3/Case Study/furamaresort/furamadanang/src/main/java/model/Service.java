package model;

public class Service {

    private Long id;
    private String serviceCode;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String roomStandard;
    private String description;
    private int poolArea;
    private int numberOfFloor;
    private int flag;
    private RentType rentType;
    private ServiceType serviceType;

    public Service() {
    }

    public Service(Long id, String serviceCode, String name, int area, double cost, int maxPeople, String roomStandard, String description, int poolArea, int numberOfFloor, int flag, RentType rentType, ServiceType serviceType) {
        this.id = id;
        this.serviceCode = serviceCode;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.roomStandard = roomStandard;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.flag = flag;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Service(String serviceCode, String name, int area, double cost, int maxPeople, String roomStandard, String description, int poolArea, int numberOfFloor, int flag, RentType rentType, ServiceType serviceType) {
        this.serviceCode = serviceCode;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.roomStandard = roomStandard;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.flag = flag;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
