package security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/customers", "/employees", "/services", "/contracts", "/contractdetails"})
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpSession session = servletRequest.getSession(false);

        if (session != null && session.getAttribute("username") != null){
            chain.doFilter(req, resp);
        } else {
            RequestDispatcher dispatcher = servletRequest.getServletContext().getRequestDispatcher("/WEB-INF/views/web/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
