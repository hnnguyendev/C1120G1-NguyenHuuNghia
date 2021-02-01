package case_study.models;

public abstract class Services {

    protected String id;
    protected String serviceName;
    protected double usableArea;
    protected double cost;
    protected int numberOfPeople;
    protected String rentalType;

    public Services() {
    }

    public Services(String id, String serviceName, double usableArea, double cost, int numberOfPeople,
                    String rentalType) {
        this.id = id;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.rentalType = rentalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public abstract String showInfo();

}
