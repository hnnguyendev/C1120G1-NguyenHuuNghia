package controller;

import model.RentType;
import model.Service;
import model.ServiceType;
import service.IRentTypeService;
import service.IServiceService;
import service.IServiceTypeService;
import service.impl.RentTypeServiceImpl;
import service.impl.ServiceServiceImpl;
import service.impl.ServiceTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {

    IServiceService serviceService = new ServiceServiceImpl();
    IRentTypeService rentTypeService = new RentTypeServiceImpl();
    IServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                editService(request, response);
                break;
            case "delete":
                deleteService(request, response);
                break;
            case "search":
                searchService(request, response);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":

                break;
            case "view":

                break;
            default:
                listAllServices(request, response);
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String serviceCode = request.getParameter("servicecode");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxpeople"));
        String roomStandard = request.getParameter("roomstandard");
        String description = request.getParameter("description");
        int poolArea = Integer.parseInt(request.getParameter("poolarea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("numberoffloor"));
        int flag = 1;
        Long rentTypeId = Long.parseLong(request.getParameter("renttypeid"));
        RentType rentType = rentTypeService.findById(rentTypeId);
        Long serviceTypeId = Long.parseLong(request.getParameter("servicetypeid"));
        ServiceType serviceType = serviceTypeService.findById(serviceTypeId);

        Service service = new Service(serviceCode, name, area, cost, maxPeople, roomStandard, description, poolArea, numberOfFloor, flag, rentType, serviceType);
        serviceService.save(service);

        listAllServices(request, response);
    }

    private void listAllServices(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();

        request.setAttribute("serviceList", serviceList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("old-id"));
        String serviceCode = request.getParameter("old-servicecode");
        String name = request.getParameter("old-name");
        int area = Integer.parseInt(request.getParameter("old-area"));
        double cost = Double.parseDouble(request.getParameter("old-cost"));
        int maxPeople = Integer.parseInt(request.getParameter("old-maxpeople"));
        String roomStandard = request.getParameter("old-roomstandard");
        String description = request.getParameter("old-description");
        int poolArea = Integer.parseInt(request.getParameter("old-poolarea"));
        int numberOfFloor = Integer.parseInt(request.getParameter("old-numberoffloor"));
        Long rentTypeId = Long.parseLong(request.getParameter("old-renttypeid"));
        RentType rentType = rentTypeService.findById(rentTypeId);
        Long serviceTypeId = Long.parseLong(request.getParameter("old-servicetypeid"));
        ServiceType serviceType = serviceTypeService.findById(serviceTypeId);

        Service service = serviceService.findById(id);
        service.setServiceCode(serviceCode);
        service.setName(name);
        service.setArea(area);
        service.setCost(cost);
        service.setMaxPeople(maxPeople);
        service.setRoomStandard(roomStandard);
        service.setDescription(description);
        service.setPoolArea(poolArea);
        service.setNumberOfFloor(numberOfFloor);
        service.setRentType(rentType);
        service.setServiceType(serviceType);
        serviceService.update(id, service);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        serviceService.remove(id);

        listAllServices(request, response);
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String txtSearch = request.getParameter("txtSearch");
        List<Service> serviceList = serviceService.search(txtSearch);

        request.setAttribute("serviceList", serviceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
