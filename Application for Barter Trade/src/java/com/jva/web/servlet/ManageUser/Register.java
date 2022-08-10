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


@WebServlet(name = "AddUser", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    @EJB
    private UserService userservice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setZipcode(Long.parseLong(request.getParameter("zipcode"), 10));
        user.setPassword(request.getParameter("password"));
        
        userservice.AddUser(user);
        
        response.sendRedirect(request.getContextPath() + "/index");
    }
}