package com.jva.web.servlet.ManageUser;

import com.jva.entity.User;
import com.jva.service.UserService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
    @EJB
    private UserService userservice;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = userservice.GetUser(username, password);
        
        if(user != null) {
            //cookies
            request.getSession().setAttribute("username", username);
            
            response.sendRedirect(getServletContext().getContextPath() + "/index");
        }else {
            doGet(request, response);
        }
    }
}
