package controller;

import common.Validate;
import model.PaymentMethod;
import model.RentRoom;
import service.IPaymentMethodService;
import service.IRentRoomService;
import service.impl.PaymentMethodServiceImpl;
import service.impl.RentRoomServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "")
public class ControllerServlet extends HttpServlet {

    IRentRoomService rentRoomService = new RentRoomServiceImpl();
    IPaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "delete":
                delete(request, response);
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
                listAll(request, response);
                break;
        }

    }

    private void listAll(HttpServletRequest request, HttpServletResponse response) {
        List<RentRoom> rentRoomList = rentRoomService.findALl();
        List<PaymentMethod> paymentMethodList = paymentMethodService.findAll();

        request.setAttribute("rentRoomList", rentRoomList);
        request.setAttribute("paymentMethodList", paymentMethodList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String message2 = Validate.validatePhoneNumber(phone);
        String startDay = request.getParameter("startDay");
        Long paymentMethodId = Long.parseLong(request.getParameter("paymentMethodId"));
        PaymentMethod paymentMethod = paymentMethodService.findById(paymentMethodId);
        String note = request.getParameter("note");

        RentRoom rentRoom = new RentRoom(fullName, phone, startDay, paymentMethod, note);

        List<RentRoom> rentRoomList = rentRoomService.findALl();

        if (message2 == null) {
            rentRoomService.create(rentRoom);
        }

        request.setAttribute("rentRoom", rentRoom);
        request.setAttribute("rentRoomList", rentRoomList);
        request.setAttribute("message2", message2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String txtSearch = request.getParameter("txtSearch");
        List<RentRoom> rentRoomList = rentRoomService.search(txtSearch);

        request.setAttribute("rentRoomList", rentRoomList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        rentRoomService.delete(id);
        listAll(request, response);
    }
}
