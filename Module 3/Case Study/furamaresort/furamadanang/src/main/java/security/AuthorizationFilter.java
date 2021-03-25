package security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns = {"/customers", "/employees", "/services", "/contracts", "/contractdetails"})
public class AuthorizationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpSession session = servletRequest.getSession(false);

        if (session != null && session.getAttribute("role")!= null && session.getAttribute("role").equals("ROLE_ADMIN")) {
            chain.doFilter(req,resp);
        } else {
            RequestDispatcher dispatcher = servletRequest.getServletContext().getRequestDispatcher("/WEB-INF/views/web/accessdenied.jsp");
            dispatcher.forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
