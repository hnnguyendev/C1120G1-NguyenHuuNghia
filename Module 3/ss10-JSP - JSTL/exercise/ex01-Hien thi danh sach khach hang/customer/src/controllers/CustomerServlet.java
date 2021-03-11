package controllers;

import models.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer-list",""})
public class CustomerServlet extends HttpServlet {

    private static List<Customer> customerList;

    @Override
    public void init() throws ServletException {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Juan Mata Garcia", "25/05/1988", "Spain", "avatar1.jpg"));
        customerList.add(new Customer(2, "David Beckham", "20/12/1970", "England", "avatar2.jpg"));
        customerList.add(new Customer(3, "Kenvin De Bruyne", "05/07/1990", "Belgium", "avatar3.jpg"));
        customerList.add(new Customer(4, "David Degea", "25/02/1990", "Spain", "avatar4.jpg"));
        customerList.add(new Customer(5, "Lionel Messi", "25/02/1987", "Argentina", "avatar5.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.setAttribute("a", "adsad");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
}
