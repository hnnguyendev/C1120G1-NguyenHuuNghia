package case_study.controllers;

import case_study.models.*;
import case_study.services.*;
import case_study.services.impl.*;
import case_study.utils.exception.*;
import case_study.utils.standardization.Standardization;
import case_study.utils.validation.CustomerValidation;
import case_study.utils.validation.ServiceValidation;

import java.util.*;

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
    static IFilingCabinetService filingCabinetService = new FilingCabinetServiceImpl();

    public static void displayMainMenu() {

        do {
            System.out.println("-----Welcome to Furama Resort-----\n" +
                    "1. Add New Services\n" +
                    "2. Show Services\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information of Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Show Customer Buy Cinema Ticket\n" +
                    "8. Search Filling Cabinet\n" +
                    "9. Exit\n" +
                    "Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
                case "3":
                    addNewCustomer();
                    break;
                case "4":
                    showAllCustomer();
                    break;
                case "5":
                    addNewBooking();
                    break;
                case "6":
                    showAllEmployee();
                    break;
                case "7":
                    showAllCustomerBuyTicket();
                    break;
                case "8":
                    searchFilingCabinet();
                    break;
                case "9":
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid!");
            }
        } while (true);
    }

    public static void addNewServices() {

        do {
            System.out.println("-----Add New Service-----\n" +
                    "1. Add New Villa\n" +
                    "2. Add New House\n" +
                    "3. Add New Room\n" +
                    "4. Back to Menu\n" +
                    "5. Exit\n" +
                    "Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewService(SERVICE_VILLA);
                    break;
                case "2":
                    addNewService(SERVICE_HOUSE);
                    break;
                case "3":
                    addNewService(SERVICE_ROOM);
                    break;
                case "4":
                    displayMainMenu();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid!");
            }
        } while (true);
    }

    public static void showServices() {

        do {
            System.out.println("-----Show Services-----\n" +
                    "1. Show all Villa\n" +
                    "2. Show all House\n" +
                    "3. Show all Room\n" +
                    "4. Show all Name Villa Not Duplicate\n" +
                    "5. Show all Name House Not Duplicate\n" +
                    "6. Show all Name Room Not Duplicate\n" +
                    "7. Back to Menu\n" +
                    "8. Exit\n" +
                    "Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAllService(SERVICE_VILLA);
                    break;
                case "2":
                    showAllService(SERVICE_HOUSE);
                    break;
                case "3":
                    showAllService(SERVICE_ROOM);
                    break;
                case "4":
                    showAllServiceNotDuplicateName(SERVICE_VILLA);
                    break;
                case "5":
                    showAllServiceNotDuplicateName(SERVICE_HOUSE);
                    break;
                case "6":
                    showAllServiceNotDuplicateName(SERVICE_ROOM);
                    break;
                case "7":
                    displayMainMenu();
                    break;
                case "8":
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid!");
            }
        } while (true);
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
        boolean check;

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
                check = true;

            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                check = false;
            }
        } while (!ServiceValidation.validateArea(usableArea) || !check);

        do {
            System.out.print("Enter cost: ");
            try {
                cost = Double.parseDouble(scanner.nextLine());
                check = true;
            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                check = false;
            }
        } while (!ServiceValidation.validateRentalCost(cost) || !check);

        do {
            System.out.print("Enter max people: ");
            try {
                maxPeople = Integer.parseInt(scanner.nextLine());
                check = true;
            } catch (Exception e) {
                System.out.println("Invalid value, please re-enter!");
                check = false;
            }
        } while (!ServiceValidation.validateMaxPeople(maxPeople) || !check);

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
                        check = true;
                    } catch (Exception e) {
                        System.out.println("Invalid value, please re-enter!");
                        check = false;
                    }
                } while (!ServiceValidation.validateArea(poolArea) || !check);

                do {
                    System.out.print("Enter villa floor: ");
                    try {
                        floor = Integer.parseInt(scanner.nextLine());
                        check = true;
                    } catch (Exception e) {
                        System.out.println("Invalid value, please re-enter!");
                        check = false;
                    }
                } while (!ServiceValidation.validateFloor(floor) || !check);

                Villa villa = new Villa(id, serviceName, usableArea, cost, maxPeople, rentalType, serviceStandard, facility,
                        poolArea, floor);
                villaService.save(villa);
                break;
            case 2:
                do {
                    System.out.print("Enter house floor: ");
                    try {
                        floorHouse = Integer.parseInt(scanner.nextLine());
                        check = true;
                    } catch (Exception e) {
                        System.out.println("Invalid value, please re-enter!");
                        check = false;
                    }
                } while (!ServiceValidation.validateFloor(floorHouse) || !check);

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
        String birthday;
        String gender;
        String idNumber;
        String phoneNumber;
        String email;
        String customerType;
        String address;
        boolean check;

        List<Customer> customerList = customerService.findAll();
        // auto increment
        if (customerList.size() == 0) {
            id = "1";
        } else {
            int tempId = Integer.parseInt(customerList.get(customerList.size() - 1).getId()) + 1;
            id = String.valueOf(tempId);
        }

        do {
            System.out.print("Enter customer name: ");
            name = scanner.nextLine();
            try {
                CustomerValidation.validateCustomerName(name);
                check = true;
            } catch (NameException e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);

        do {
            System.out.print("Enter customer birthday: ");
            birthday = scanner.nextLine();
            try {
                CustomerValidation.validateBirthday(birthday);
                check = true;
            } catch (BirthdayException e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);

        do {
            System.out.print("Enter customer gender: ");
            gender = scanner.nextLine();
            try {
                CustomerValidation.validateGender(gender);
                gender = Standardization.standardizedName(gender);
                check = true;
            } catch (GenderException e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);

        do {
            System.out.print("Enter customer id number: ");
            idNumber = scanner.nextLine();
            try {
                CustomerValidation.validateIdNumber(idNumber);
                check = true;
            } catch (IdNumberException e) {
                check = false;
                System.out.println(e.getMessage());
            }
        } while (!check);

        do {
            System.out.print("Enter customer phone number: ");
            phoneNumber = scanner.nextLine();
        } while (!CustomerValidation.validatePhoneNumber(phoneNumber));

        do {
            System.out.print("Enter customer email: ");
            email = scanner.nextLine();
            try {
                CustomerValidation.validateCustomerEmail(email);
                check = true;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
                check = false;
            }
        } while (!check);

        do {
            System.out.print("Enter customer type: ");
            customerType = scanner.nextLine();
        } while (!CustomerValidation.validateCustomerType(customerType));

        do {
            System.out.print("Enter customer address: ");
            address = scanner.nextLine();
        } while (!CustomerValidation.validateAddress(address));

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

        Customer customer;
        do {
            System.out.print("Customer booking by id: ");
            String customerId = scanner.nextLine();
            customer = customerService.findById(customerId);
        } while (customer == null);

        String serviceType;
        do {
            System.out.print("1. Booking Villa\n" +
                    "2. Booking House\n" +
                    "3. Booking Room\n" +
                    "4. Back to Menu\n" +
                    "Your choice: ");
            serviceType = scanner.nextLine();
            switch (serviceType) {
                case "1":
                    List<Villa> villaList = villaService.findAll();
                    for (int i = 0; i < villaList.size(); i++) {
                        System.out.println((i + 1) + ". " + villaList.get(i).showInfo());
                    }
                    int villaNo;
                    String villaId;

                    do {
                        System.out.print("Booking villa: ");
                        villaNo = Integer.parseInt(scanner.nextLine());
                        villaId = villaList.get(villaNo - 1).getId();
                        if (bookingService.isBookingService(villaId)) {
                            bookingService.save(customer, villaId);
                        } else {
                            System.out.println("Villa is not available!");
                        }
                    } while (villaNo < 1 || villaNo > villaList.size() || !bookingService.isBookingService(villaId));

                    break;
                case "2":
                    List<House> houseList = houseService.findAll();
                    for (int i = 0; i < houseList.size(); i++) {
                        System.out.println((i + 1) + ". " + houseList.get(i).showInfo());
                    }
                    int houseNo;
                    String houseId;

                    do {
                        System.out.print("Booking house: ");
                        houseNo = Integer.parseInt(scanner.nextLine());
                        houseId = houseList.get(houseNo - 1).getId();
                        if (bookingService.isBookingService(houseId)) {
                            bookingService.save(customer, houseId);
                        } else {
                            System.out.println("House is not available!");
                        }
                    } while (houseNo < 1 || houseNo > houseList.size() || !bookingService.isBookingService(houseId));

                    break;
                case "3":
                    List<Room> roomList = roomService.findAll();
                    for (int i = 0; i < roomList.size(); i++) {
                        System.out.println((i + 1) + ". " + roomList.get(i).showInfo());
                    }
                    int roomNo;
                    String roomId;

                    do {
                        System.out.print("Booking room: ");
                        roomNo = Integer.parseInt(scanner.nextLine());
                        roomId = roomList.get(roomNo - 1).getId();
                        if (bookingService.isBookingService((roomId))) {
                            bookingService.save(customer, roomId);
                        } else {
                            System.out.println("Room is not available!");
                        }
                    } while (roomNo < 1 || roomNo > roomList.size() || bookingService.isBookingService(roomId));

                    break;
                case "4":
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Your choice is invalid!");
            }
        } while (true);

    }

    public static void showAllEmployee() {
        Map<String, Employee> employeeList = employeeService.findAll();

        Set<String> keySet = employeeList.keySet();

        for (String key : keySet) {
            System.out.println(key + " = " + employeeList.get(key).showInfo());
        }
    }

    public static void showAllCustomerBuyTicket() {
        Queue<Customer> customerQueue = cinemaService.findAll();
        while (true) {
            Customer customer = customerQueue.poll();
            if (customer == null) {
                break;
            }
            System.out.println(customer);
        }
    }

    public static void searchFilingCabinet() {
        System.out.print("Search by employee id: ");
        String id = scanner.nextLine();
        Employee employee = filingCabinetService.findEmployeeById(id);
        System.out.println(employee.showInfo());

    }

}
