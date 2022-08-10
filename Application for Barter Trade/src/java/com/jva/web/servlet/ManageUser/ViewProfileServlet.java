/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.web.servlet.ManageUser;

import com.jva.entity.User;
import com.jva.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolas
 */
@WebServlet(name = "ViewProfileServlet", urlPatterns = {"/user/profile"})
public class ViewProfileServlet extends HttpServlet {

    @EJB
    private UserService userservice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userservice.GetUserByUsername(request.getSession().getAttribute("username").toString());
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        response.sendRedirect(request.getContextPath());
    }
}
