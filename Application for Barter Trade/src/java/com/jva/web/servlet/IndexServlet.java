/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.web.servlet;

import com.jva.entity.Item;
import com.jva.service.ItemService;
import com.jva.service.UserService;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    @EJB
    private UserService userservice;
    
    @EJB
    private ItemService itemservice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long countUsers = userservice.CountUsers();
        Long countObjects = itemservice.CountItems();
        List<Item> listItems = itemservice.ListItems();
        
        request.setAttribute("listItems", listItems);
        request.setAttribute("countUsers", countUsers);
        request.setAttribute("countObjects", countObjects);

        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // pas de do post pour l'instant
    }
}