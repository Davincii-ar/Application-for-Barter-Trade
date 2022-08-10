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

@WebServlet(name = "EditProfileServlet", urlPatterns = {"/user/editProfile"})
public class EditProfile extends HttpServlet {

    @EJB
    private UserService userservice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userservice.GetUserByUsername(request.getSession().getAttribute("username").toString());
        request.setAttribute("user", user);
        request.getRequestDispatcher("/jsp/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getSession().getAttribute("username").toString());
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setZipcode(Long.parseLong(request.getParameter("zipcode"), 10));
        user.setPassword(request.getParameter("password"));
        
        userservice.UpdateUser(user);
        
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
