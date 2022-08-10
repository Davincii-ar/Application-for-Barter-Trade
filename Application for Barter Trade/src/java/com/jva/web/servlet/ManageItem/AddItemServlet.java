package com.jva.web.servlet.ManageItem;

import com.jva.entity.Item;
import com.jva.entity.User;
import com.jva.service.ItemService;
import com.jva.service.UserService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "AddItemServlet", urlPatterns = {"/user/addItem"})
@MultipartConfig
public class AddItemServlet extends HttpServlet {
@EJB
    public UserService userservice;
    
    @EJB
    public ItemService objectservice;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addItem.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Item obj = new Item();
        obj.setTitle(request.getParameter("title"));
        obj.setDescription(request.getParameter("description"));
        obj.setTypeof(request.getParameter("typeof"));
        obj.setPrice(Float.parseFloat(request.getParameter("price")));
        
        Part filePart = request.getPart("fileChooser");
        String fileName = filePart.getSubmittedFileName();
        obj.setPicture(fileName);
        
        String path = getServletContext().getInitParameter("upload.location");
        File directory = new File(getServletContext().getRealPath(path));
        
        File file = new File(directory, fileName);
        
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath());
        }
        
        User user = userservice.GetUserByUsername(request.getSession().getAttribute("username").toString());
        obj.setUser(user);
        
        objectservice.AddItem(obj);
        
        response.sendRedirect(request.getContextPath() + "/index");
    }    
}
