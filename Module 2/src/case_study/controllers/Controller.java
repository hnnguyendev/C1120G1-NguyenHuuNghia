package case_study.controllers;

import case_study.models.*;
import case_study.services.*;
import case_study.services.impl.*;
import case_study.utils.exception.NameException;
import case_study.utils.validation.CustomerValidation;
import case_study.utils.validation.ServiceValidation;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * methods controller
 * interact with service
 */
public class Controller {

    static Scanner scanner = new Scanner(System.in);

    private static final int SERVICE_VILLA = 1;
    private static final int SERVICE_HOUSE = 2;
    private static final int SERVICE_ROOM = 3;

    static IVillaService villaService = new VillaServiceImpl();
    static IHouseService houseService = new HouseServiceImpl();
    static IRoomService roomService = new RoomServiceImpl();
    static ICustomerService customerService = new CustomerServiceImpl();
    static IBookingService bookingService = new BookingServiceImpl();
    static IEmployeeService employeeService = new EmployeeServiceImpl();
    static ICinemaService cinemaService = new CinemaServiceImpl();

    public static void displayMainMenu() {
        int choice = 1;
        boolean checkMainMenu;
        System.out.println("-----Welcome to Furama Resort-----\n" +
                "1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Information of Employee\n" +
                "7. Show Customer Buy Cinema Ticket\n" +
                "9. Exit");
        do {
            System.out.print("Your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                checkMainMenu = true;
            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                checkMainMenu = false;
            }
        } while (choice < 1 || choice > 9 || !checkMainMenu);

        switch (choice) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showAllCustomer();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                showAllEmployee();
                break;
            case 7:
                showAllCustomerBuyTicket();
                break;
            case 9:
                System.exit(0);
        }
    }

    public static void addNewServices() {
        int choice = 1;
        boolean checkSubMenu;
        System.out.println("-----Add New Service-----\n" +
                "1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to Menu\n" +
                "5. Exit");

        do {
            System.out.print("Your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                checkSubMenu = true;
            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                checkSubMenu = false;
            }
        } while (choice < 1 || choice > 5 || !checkSubMenu);

        switch (choice) {
            case 1:
                addNewService(SERVICE_VILLA);
                break;
            case 2:
                addNewService(SERVICE_HOUSE);
                break;
            case 3:
                addNewService(SERVICE_ROOM);
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
        }
    }

    public static void showServices() {
        int choice = 1;
        boolean checkSubMenu;
        System.out.println("-----Show Services-----\n" +
                "1. Show all Villa\n" +
                "2. Show all House\n" +
                "3. Show all Room\n" +
                "4. Show all Name Villa Not Duplicate\n" +
                "5. Show all Name House Not Duplicate\n" +
                "6. Show all Name Room Not Duplicate\n" +
                "7. Back to Menu\n" +
                "8. Exit");

        do {
            System.out.print("Your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                checkSubMenu = true;
            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                checkSubMenu = false;
            }
        } while (choice < 1 || choice > 8 || !checkSubMenu);

        switch (choice) {
            case 1:
                showAllService(SERVICE_VILLA);
                break;
            case 2:
                showAllService(SERVICE_HOUSE);
                break;
            case 3:
                showAllService(SERVICE_ROOM);
                break;
            case 4:
                showAllServiceNotDuplicateName(SERVICE_VILLA);
                break;
            case 5:
                showAllServiceNotDuplicateName(SERVICE_HOUSE);
                break;
            case 6:
                showAllServiceNotDuplicateName(SERVICE_ROOM);
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
        }
    }

    public static void addNewService(int serviceType) {

        String id;
        String serviceName;
        double usableArea = 0;
        double cost = 0;
        int maxPeople = 0;
        String rentalType;
        String serviceStandard = null;
        String facility = null;
        double poolArea = 0;
        int floor = 0;
        int floorHouse = 0;
        String freeService;

        boolean checkUsableArea;
        boolean checkCost;
        boolean checkMaxPeople;
        boolean checkPoolArea;
        boolean checkVillaFloor;
        boolean checkHouseFloor;

        do {
            System.out.print("Enter service id: ");
            id = scanner.nextLine();
        } while (!ServiceValidation.validateServiceId(id, serviceType));

        do {
            System.out.print("Enter service name: ");
            serviceName = scanner.nextLine();
        } while (!ServiceValidation.validateServiceName(serviceName));

        do {
            System.out.print("Enter usable area: ");
            try {
                usableArea = Double.parseDouble(scanner.nextLine());
                checkUsableArea = true;

            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                checkUsableArea = false;
            }
        } while (!ServiceValidation.validateArea(usableArea) || !checkUsableArea);

        do {
            System.out.print("Enter cost: ");
            try {
                cost = Double.parseDouble(scanner.nextLine());
                checkCost = true;
            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                checkCost = false;
            }
        } while (!ServiceValidation.validateRentalCost(cost) || !checkCost);

        do {
            System.out.print("Enter max people: ");
            try {
                maxPeople = Integer.parseInt(scanner.nextLine());
                checkMaxPeople = true;
            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                checkMaxPeople = false;
            }
        } while (!ServiceValidation.validateMaxPeople(maxPeople) || !checkMaxPeople);

        do {
            System.out.print("Enter rental type: ");
            rentalType = scanner.nextLine();
        } while (!ServiceValidation.validateServiceName(rentalType));


        if (serviceType == 1 || serviceType == 2) {
            do {
                System.out.print("Enter room standard: ");
                serviceStandard = scanner.nextLine();
            } while (!ServiceValidation.validateServiceName(serviceStandard));

            do {
                System.out.print("Enter facility: ");
                facility = scanner.nextLine();
            } while (!ServiceValidation.validateServiceAddon(facility));
        }

        switch (serviceType) {
            case 1:
                do {
                    System.out.print("Enter pool area: ");
                    try {
                        poolArea = Double.parseDouble(scanner.nextLine());
                        checkPoolArea = true;
                    } catch (Exception e) {
                        System.out.println("Invalid value, please re-enter!");
                        checkPoolArea = false;
                    }
                } while (!ServiceValidation.validateArea(poolArea) || !checkPoolArea);

                do {
                    System.out.print("Enter floor: ");
                    try {
                        floor = Integer.parseInt(scanner.nextLine());
                        checkVillaFloor = true;
                    } catch (Exception e) {
                        System.out.println("Invalid value, please re-enter!");
                        checkVillaFloor = false;
                    }
                } while (!ServiceValidation.validateFloor(floor) || !checkVillaFloor);

                Villa villa = new Villa(id, serviceName, usableArea, cost, maxPeople, rentalType, serviceStandard, facility,
                        poolArea, floor);
                villaService.save(villa);
                break;
            case 2:
                do {
                    System.out.print("Enter floor: ");
                    try {
                        floorHouse = Integer.parseInt(scanner.nextLine());
                        checkHouseFloor = true;
                    } catch (Exception e) {
                        System.out.println("Invalid value, please re-enter!");
                        checkHouseFloor = false;
                    }
                } while (!ServiceValidation.validateFloor(floorHouse) || !checkHouseFloor);

                House house = new House(id, serviceName, usableArea, cost, maxPeople, rentalType, serviceStandard,
                        facility, floorHouse);
                houseService.save(house);
                break;
            case 3:
                do {
                    System.out.print("Enter free service: ");
                    freeService = scanner.nextLine();
                } while (!ServiceValidation.validateServiceAddon(freeService));

                Room room = new Room(id, serviceName, usableArea, cost, maxPeople, rentalType, freeService);
                roomService.save(room);
        }
    }

    public static void showAllService(int serviceType) {
        switch (serviceType) {
            case 1:
                List<Villa> villaList = villaService.findAll();
                for (Villa villa : villaList) {
                    System.out.println(villa.showInfo());
                }
                break;
            case 2:
                List<House> houseList = houseService.findAll();
                for (House house : houseList) {
                    System.out.println(house.showInfo());
                }
                break;
            case 3:
                List<Room> roomList = roomService.findAll();
                for (Room room : roomList) {
                    System.out.println(room.showInfo());
                }
        }
    }

    public static void showAllServiceNotDuplicateName(int serviceType) {
        switch (serviceType) {
            case 1:
                TreeSet<Villa> villaTreeSet = villaService.findAllNotDuplicateName();
                for (Villa villa : villaTreeSet) {
                    System.out.println(villa.showInfo());
                }
                break;
            case 2:
                TreeSet<House> houseTreeSet = houseService.findAllNotDuplicateName();
                for (House house : houseTreeSet) {
                    System.out.println(house.showInfo());
                }
                break;
            case 3:
                TreeSet<Room> roomTreeSet = roomService.findAllNotDuplicateName();
                for (Room room : roomTreeSet) {
                    System.out.println(room.showInfo());
                }
                break;

        }
    }

    public static void editService(int serviceType) {
        System.out.print("Edit service by id: ");
        String id = scanner.nextLine();
        Villa villa = villaService.findById(id);
        System.out.print(villa.showInfo() +
                "\nYou want to update:\n" +
                "1. Service Name\n" +
                "2. Usable Area\n" +
                "3. Cost\n" +
                "4. Max People\n" +
                "5. Rental Type\n" +
                "6. Room Standard\n" +
                "7. Facility\n" +
                "8. Pool Area\n" +
                "9. Floors\n" +
                "Your choice: ");
        int field = Integer.parseInt(scanner.nextLine());
        switch (field) {
            case 1:
                System.out.print("Enter new service name: ");
                String newName = scanner.nextLine();
                villa.setServiceName(newName);
                break;
            case 2:
                System.out.print("Enter new service name: ");
                double newUsableArea = Double.parseDouble(scanner.nextLine());
                villa.setUsableArea(newUsableArea);
                break;
            case 3:
                System.out.print("Enter new cost: ");
                double newCost = Double.parseDouble(scanner.nextLine());
                villa.setCost(newCost);
                break;
            case 4:
                System.out.print("Enter new max people: ");
                int newMaxPeople = Integer.parseInt(scanner.nextLine());
                villa.setNumberOfPeople(newMaxPeople);
                break;
            case 5:
                System.out.print("Enter new rental type: ");
                String newRentalType = scanner.nextLine();
                villa.setRentalType(newRentalType);
                break;
            case 6:
                System.out.print("Enter new room standard: ");
                String newRoomStandard = scanner.nextLine();
                villa.setRoomStandard(newRoomStandard);
                break;
            case 7:
                System.out.print("Enter new facility: ");
                String newFacility = scanner.nextLine();
                villa.setFacilities(newFacility);
                break;
            case 8:
                System.out.print("Enter new pool area: ");
                int newPoolArea = Integer.parseInt(scanner.nextLine());
                villa.setPoolArea(newPoolArea);
                break;
            case 9:
                System.out.print("Enter new floors: ");
                int newFloors = Integer.parseInt(scanner.nextLine());
                villa.setFloors(newFloors);
                break;
        }
        villaService.update(villa, id);
    }

    public static void deleteService(int serviceType) {
        System.out.print("Delete service by id: ");
        String id = scanner.nextLine();
        villaService.delete(id);
    }

    public static void searchServiceByName(int serviceType) {
        System.out.print("Search service by name: ");
        String name = scanner.nextLine();

        List<Villa> villaList = villaService.searchByName(name);

        if (!villaList.isEmpty()) {
            for (Villa villa : villaList) {
                System.out.println(villa.showInfo());
            }

        } else {
            System.out.println("No result");
        }
    }

    public static void addNewCustomer() {

        String id;
        String name;

        System.out.print("Enter customer id: ");
        id = scanner.nextLine();
        boolean check = true;
        do {
            System.out.print("Enter customer name: ");
            name = scanner.nextLine();
            try {
                CustomerValidation.validateCustomerName(name);
            } catch (NameException e) {
                check=false;
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } while (!check);

        System.out.print("Enter customer birthday: ");
        String birthday = scanner.nextLine();

        System.out.print("Enter customer gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter customer id number: ");
        String idNumber = scanner.nextLine();

        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.print("Enter customer type: ");
        String customerType = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, birthday, gender, idNumber, phoneNumber, email, customerType,
                address, null);

        customerService.save(customer);

    }

    public static void showAllCustomer() {
        List<Customer> customerList = customerService.findAllSortByNameAndBirthday();
        for (Customer customer : customerList) {
            System.out.println(customer.showInfo());
        }
    }

    public static void addNewBooking() {
        List<Customer> customerList = customerService.findAll();
        for (Customer customer : customerList) {
            System.out.println(customer.showInfo());
        }

        System.out.print("Customer booking by id: ");
        String customerId = scanner.nextLine();
        Customer customer = customerService.findById(customerId);

        System.out.print("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "Your choice: ");
        int serviceType = Integer.parseInt(scanner.nextLine());
        switch (serviceType) {
            case 1:
                List<Villa> villaList = villaService.findAll();
                for (int i = 0; i < villaList.size(); i++) {
                    System.out.println((i + 1) + ". " + villaList.get(i).showInfo());
                }
                System.out.print("Booking service: ");
                int villaNo = Integer.parseInt(scanner.nextLine());
                String villaId = villaList.get(villaNo - 1).getId();
                bookingService.save(customer, villaId);
                break;
            case 2:
                List<House> houseList = houseService.findAll();
                for (int i = 0; i < houseList.size(); i++) {
                    System.out.println((i + 1) + ". " + houseList.get(i).showInfo());
                }
                System.out.print("Booking service: ");
                int houseNo = Integer.parseInt(scanner.nextLine());
                String houseId = houseList.get(houseNo - 1).getId();
                bookingService.save(customer, houseId);
                break;
            case 3:
                List<Room> roomList = roomService.findAll();
                for (int i = 0; i < roomList.size(); i++) {
                    System.out.println((i + 1) + ". " + roomList.get(i).showInfo());
                }
                System.out.print("Booking service: ");
                int roomNo = Integer.parseInt(scanner.nextLine());
                String roomId = roomList.get(roomNo - 1).getId();
                bookingService.save(customer, roomId);
                break;
        }

    }

    public static void showAllEmployee() {
        List<Employee> employeeList = employeeService.findAll();
        for (Employee employee : employeeList) {
            System.out.println(employee.showInfo());
        }
    }

    public static void showAllCustomerBuyTicket() {
        List<Customer> customerList = cinemaService.findAll();
        for (Customer customer : customerList) {
            System.out.println(customer.showInfo());
        }
    }

}
