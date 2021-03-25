package controller;

import model.*;
import service.*;
import service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {

    IEmployeeService employeeService = new EmployeeServiceImpl();
    IPositionService positionService = new PositionServiceImpl();
    IEducationService educationService = new EducationServiceImpl();
    IDepartmentService departmentService = new DepartmentServiceImpl();
    IUserService userService = new UserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
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

                break;
            default:
                listAllEmployees(request, response);
                break;
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String fullName = request.getParameter("fullname");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String idNumber = request.getParameter("idnumber");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int flag = 1;
        Long positionId = Long.parseLong(request.getParameter("positionid"));
        Position position = positionService.findById(positionId);
        Long educationId = Long.parseLong(request.getParameter("educationid"));
        Education education = educationService.findById(educationId);
        Long departmentId = Long.parseLong(request.getParameter("departmentid"));
        Department department = departmentService.findById(departmentId);
        String username = request.getParameter("username");
        User user = userService.findByUsername(username);

        Employee employee = new Employee(fullName, birthday, idNumber, salary, phoneNumber, email, address, flag, position, education, department, user);
        employeeService.save(employee);

        List<Employee> employeeList = employeeService.findAll();

        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllEmployees(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAll();
        List<Position> positionList = positionService.findAll();
        List<Education> educationList = educationService.findAll();
        List<Department> departmentList = departmentService.findAll();
//        List<User> userList = userService.findAll();
        List<User> userList = userService.findAvailable();

        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationList", educationList);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("userList", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("old-id"));
        String fullName = request.getParameter("old-fullname");
        Date birthday = Date.valueOf(request.getParameter("old-birthday"));
        String idNumber = request.getParameter("old-idnumber");
        double salary = Double.parseDouble(request.getParameter("old-salary"));
        String phoneNumber = request.getParameter("old-phonenumber");
        String email = request.getParameter("old-email");
        String address = request.getParameter("old-address");
        Long positionId = Long.parseLong(request.getParameter("old-positionid"));
        Position position = positionService.findById(positionId);
        Long educationId = Long.parseLong(request.getParameter("old-educationid"));
        Education education = educationService.findById(educationId);
        Long departmentId = Long.parseLong(request.getParameter("old-departmentid"));
        Department department = departmentService.findById(departmentId);

        Employee employee = employeeService.findById(id);
        employee.setFullName(fullName);
        employee.setBirthday(birthday);
        employee.setIdNumber(idNumber);
        employee.setSalary(salary);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setEducation(education);
        employee.setDepartment(department);
        employeeService.update(id, employee);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeService.remove(id);
        listAllEmployees(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String txtSearch = request.getParameter("txtSearch");
        List<Employee> employeeList = employeeService.search(txtSearch);

        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
