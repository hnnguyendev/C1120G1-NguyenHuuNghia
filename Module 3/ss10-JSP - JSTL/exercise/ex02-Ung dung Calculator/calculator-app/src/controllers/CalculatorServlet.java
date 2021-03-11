package controllers;

import services.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("first-operand"));
        double secondOperand = Double.parseDouble(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);

        try {
            double result = Calculator.calculate(firstOperand, secondOperand, operator);
            request.setAttribute("firstO", firstOperand);
            request.setAttribute("secondO", secondOperand);
            request.setAttribute("operator", operator);
            request.setAttribute("result", result);


        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
