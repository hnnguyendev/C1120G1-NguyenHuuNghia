package controller;

import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeServiceImpl;
import utils.validation.CustomerValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    ICustomerService customerService = new CustomerServiceImpl();
    ICustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                viewCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
                listAllCustomers(request, response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<String> messages = new ArrayList<>();

        String customerCode = request.getParameter("customercode");
        String message1 = CustomerValidation.validateCustomerCode(customerCode);
        messages.add(message1);

        String fullName = request.getParameter("fullname");
        String message2 = CustomerValidation.validateCustomerName(fullName);
        messages.add(message2);

        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String message3 = null;
        messages.add(message3);

        int gender = Integer.parseInt(request.getParameter("gender"));
        String message4 = null;
        messages.add(message4);

        String idNumber = request.getParameter("idnumber");
        String message5 = CustomerValidation.validateIdNumber(idNumber);
        messages.add(message5);

        String phoneNumber = request.getParameter("phonenumber");
        String message6 = null;
        messages.add(message6);

        String email = request.getParameter("email");
        String message7 = CustomerValidation.validateEmail(email);
        messages.add(message7);

        String address = request.getParameter("address");
        String message8 = CustomerValidation.validateAddress(address);
        messages.add(message8);

        int flag = 1;

        Long customerTypeId = Long.parseLong(request.getParameter("customerTypeId"));
        CustomerType customerType = customerTypeService.findById(customerTypeId);

        Customer customer = new Customer(customerCode, fullName, birthday, gender, idNumber, phoneNumber, email, address, flag, customerType);

        int check = 0;
        for (String message : messages) {
            if (message != null) {
                check = 1;
                break;
            }
        }
        if (check == 0) {
            customerService.save(customer);
            // reset customer sau khi thêm
            customer = null;
        }

        // Khi them thanh cong thi tra ve list customer de hien thi
        List<Customer> customerList = customerService.findAll();
        // Xử lý modal hiển thị lại customerType
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        request.setAttribute("messages", messages);
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void listAllCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {

    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("old-id"));
        String customerCode = request.getParameter("old-customercode");
        String fullName = request.getParameter("old-fullname");
        Date birthday = Date.valueOf(request.getParameter("old-birthday"));
        int gender = Integer.parseInt(request.getParameter("old-gender"));
        String idNumber = request.getParameter("old-idnumber");
        String phoneNumber = request.getParameter("old-phonenumber");
        String email = request.getParameter("old-email");
        String address = request.getParameter("old-address");
        Long customerTypeId = Long.parseLong(request.getParameter("old-customertypeid"));
        CustomerType customerType = customerTypeService.findById(customerTypeId);

        Customer customer = customerService.findById(id);
        customer.setCustomerCode(customerCode);
        customer.setFullName(fullName);
        customer.setBirthday(birthday);
        customer.setGender(gender);
        customer.setIdNumber(idNumber);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setCustomerType(customerType);
        customerService.update(id, customer);

        try {
            response.sendRedirect(request.getContextPath() + "/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        customerService.remove(id);
        listAllCustomers(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String txtSearch = request.getParameter("txtSearch");
        List<Customer> customerList = customerService.search(txtSearch);

        // gửi customerTypeList qua để binding data lên modal update
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
