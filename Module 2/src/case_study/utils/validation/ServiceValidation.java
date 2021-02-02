package case_study.utils.validation;

import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;
import case_study.services.IHouseService;
import case_study.services.IRoomService;
import case_study.services.IVillaService;
import case_study.services.impl.HouseServiceImpl;
import case_study.services.impl.RoomServiceImpl;
import case_study.services.impl.VillaServiceImpl;

import java.util.List;

public class ServiceValidation {

    private static final String SERVICE_NAME = "^[A-Z](([a-z0-9])*)+(\\s[a-z0-9]+)*$";
    private static final String SERVICE_VILLA = "^SVVL-\\d{4}$";
    private static final String SERVICE_HOUSE = "^SVHO-\\d{4}$";
    private static final String SERVICE_ROOM = "^SVRO-\\d{4}$";
    private static final String SERVICE_ADDON = "^massage|karaoke|food|drink|car$";

    static IVillaService villaService = new VillaServiceImpl();
    static IHouseService houseService = new HouseServiceImpl();
    static IRoomService roomService = new RoomServiceImpl();

    public static boolean validateServiceId(String str, int serviceType) {
        switch (serviceType) {
            case 1:
                List<Villa> villaList = villaService.findAll();
                for (Villa villa : villaList) {
                    if (villa.getId().equals(str)) {
                        System.out.println(str + " already exists, please re-enter!");
                        return false;
                    }
                }
                if (!str.matches(SERVICE_VILLA)) {
                    System.out.println("Correct format: SVVL-XXXX, please re-enter!");
                    return false;
                }
                return true;
            case 2:
                List<House> houseList = houseService.findAll();
                for (House house : houseList) {
                    if (house.getId().equals(str)) {
                        System.out.println(str + " already exists, please re-enter!");
                        return false;
                    }
                }
                if (!str.matches(SERVICE_HOUSE)) {
                    System.out.println("Correct format: SVHO-XXXX, please re-enter!");
                    return false;
                }
                return true;
            case 3:
                List<Room> roomList = roomService.findAll();
                for (Room room : roomList) {
                    if (room.getId().equals(str)) {
                        System.out.println(str + " already exists, please re-enter!");
                        return false;
                    }
                }
                if (!str.matches(SERVICE_ROOM)) {
                    System.out.println("Correct format: SVRO-XXXX, please re-enter!");
                    return false;
                }
                return true;
        }
        return true;
    }

    public static boolean validateServiceName(String str) {
        if (!str.matches(SERVICE_NAME)) {
            System.out.println("Invalid value, please re-enter!");
            return false;
        }
        return true;
    }

    public static boolean validateArea(double area) {
        if (area < 30) {
            System.out.println("Area must more than or equal 30");
            return false;
        }
        return true;
    }

    public static boolean validateRentalCost(double rentalCost) {
        if (rentalCost <= 0) {
            System.out.println("Rental cost must more than 0");
            return false;
        }
        return true;
    }

    public static boolean validateMaxPeople(int maxPeople) {
        if (maxPeople <= 0 || maxPeople > 20) {
            System.out.println("Max people must more than 0 and less than or equal 20");
            return false;
        }
        return true;
    }

    public static boolean validateServiceAddon(String str) {
        if (!str.matches(SERVICE_ADDON)) {
            System.out.println("Service (massage, karaoke, food, drink, car), please re-enter!");
            return false;
        }
        return true;
    }

    public static boolean validateFloor(int floor) {
        if (floor <= 0) {
            System.out.println("Floor must more than 0");
            return false;
        }
        return true;
    }

}
