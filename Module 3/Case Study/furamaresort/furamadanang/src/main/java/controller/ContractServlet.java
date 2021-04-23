package controller;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;
import service.IContractService;
import service.ICustomerService;
import service.IEmployeeService;
import service.IServiceService;
import service.impl.ContractServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {

    IContractService contractService = new ContractServiceImpl();
    IEmployeeService employeeService = new EmployeeServiceImpl();
    ICustomerService customerService = new CustomerServiceImpl();
    IServiceService serviceService = new ServiceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;
            case "edit":

                break;
            case "delete":

                break;
            case "search":
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
                listAllContracts(request, response);
                break;
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        Date startDay = Date.valueOf(request.getParameter("startday"));
        Date endDay = Date.valueOf(request.getParameter("endday"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalPay = Double.parseDouble(request.getParameter("totalpay"));
        Long employeeId = Long.parseLong(request.getParameter("employeeid"));
        Long customerId = Long.parseLong(request.getParameter("customerid"));
        Long serviceId = Long.parseLong(request.getParameter("serviceid"));
        Employee employee = employeeService.findById(employeeId);
        Customer customer = customerService.findById(customerId);
        Service service = serviceService.findById(serviceId);

        Contract contract = new Contract(startDay, endDay, deposit, totalPay, employee, customer, service);
        contractService.save(contract);

        //...

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/contract/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllContracts(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList = customerService.findAll();
        List<Service> serviceList = serviceService.findAll();

        request.setAttribute("contractList", contractList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("serviceList", serviceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/contract/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
