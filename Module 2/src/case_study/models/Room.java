package case_study.models;

public class Room extends Services {

    private String freeService;

    public Room() {
    }

    public Room(String id, String serviceName, double usableArea, double cost, int numberOfPeople,
                String rentalType, String freeService) {
        super(id, serviceName, usableArea, cost, numberOfPeople, rentalType);
        this.freeService = freeService;
    }

    public Room(String[] strings) {
        super(strings[0], strings[1], Double.parseDouble(strings[2]), Double.parseDouble(strings[3]),
                Integer.parseInt(strings[4]), strings[5]);
        this.freeService = strings[6];
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.id + "," +
                super.serviceName + "," +
                super.usableArea + "," +
                super.cost + "," +
                super.numberOfPeople + "," +
                super.rentalType + "," +
                freeService;
    }

    public String showInfo() {
        return "Room{" + "id='" + super.id + '\'' +
                ", serviceName='" + super.serviceName + '\'' +
                ", usableArea=" + super.usableArea +
                ", cost=" + super.cost +
                ", numberOfPeople=" + super.numberOfPeople +
                ", rentalType='" + super.rentalType + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }
}
