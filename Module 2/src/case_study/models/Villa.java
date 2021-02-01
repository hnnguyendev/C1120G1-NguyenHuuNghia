package case_study.models;

public class Villa extends Services {

    private String roomStandard;
    private String facilities;
    private double poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usableArea, double cost, int numberOfPeople,
                 String rentalType, String roomStandard, String facilities, double poolArea, int floors) {
        super(id, serviceName, usableArea, cost, numberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.facilities = facilities;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Villa(String[] strings) {
        super(strings[0], strings[1], Double.parseDouble(strings[2]), Double.parseDouble(strings[3]),
                Integer.parseInt(strings[4]), strings[5]);
        this.roomStandard = strings[6];
        this.facilities = strings[7];
        this.poolArea = Double.parseDouble(strings[8]);
        this.floors = Integer.parseInt(strings[9]);
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return super.id + "," +
                super.serviceName + "," +
                super.usableArea + "," +
                super.cost + "," +
                super.numberOfPeople + "," +
                super.rentalType + "," +
                roomStandard + "," +
                facilities + "," +
                poolArea + "," +
                floors;
    }

    public String showInfo() {
        return "Villa{" + "id='" + super.id + '\'' +
                ", serviceName='" + super.serviceName + '\'' +
                ", usableArea=" + super.usableArea +
                ", cost=" + super.cost +
                ", numberOfPeople=" + super.numberOfPeople +
                ", rentalType='" + super.rentalType + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", facilities='" + facilities + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                '}';
    }

}
