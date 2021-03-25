package controller;

import model.UserRole;
import service.IUserRoleService;
import service.impl.UserRoleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "")
public class HomeServlet extends HttpServlet {

    IUserRoleService userRoleService = new UserRoleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                showLoginPage(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            default:
                showHomePage(request, response);
                break;
        }
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/web/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/web/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserRole userRole = userRoleService.findByUsernameAndPassword(username, password);

        if (userRole != null) {
            HttpSession session = request.getSession();
            session.setAttribute("fullname", userRole.getFullName());
            session.setAttribute("username", userRole.getUserName());
            session.setAttribute("role", userRole.getRole());

            // tao Cookie lay thong tin cua nguoi dung de nho lai
            Cookie user = new Cookie("user", userRole.getUserName());
            Cookie pass = new Cookie("pass", userRole.getPassword());

            if (request.getParameter("remember") != null) {
                user.setMaxAge(60 * 60 * 24);
                pass.setMaxAge(60 * 60 * 24);
            } else {
                user.setMaxAge(0);
                pass.setMaxAge(0);
            }
            response.addCookie(user);
            response.addCookie(pass);

            if (userRole.getRole().equals("ROLE_USER")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/web/index.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    response.sendRedirect(request.getContextPath() + "/contracts");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            request.setAttribute("message", "Username or password invalid");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/web/login.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;
        if (request.getParameter("logout") != null) {
            if (request.getParameter("logout").equals("ok")) {
                HttpSession session = request.getSession();
                session.invalidate();
                request.removeAttribute("user");
                request.removeAttribute("pass");
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/web/login.jsp");
            }
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
