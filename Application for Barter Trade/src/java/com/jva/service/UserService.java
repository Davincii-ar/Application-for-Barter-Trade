/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.service;

import com.jva.dao.UserDao;
import com.jva.entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService {
    
    @EJB
    private UserDao userdao;
    
    public void AddUser(User user) {
        userdao.AddUser(user);
    }
    
    public void UpdateUser(User user) {
        userdao.UpdateUser(user);
    }
    
    public User GetUserByUsername(String username) {
        return userdao.GetUserByUsername(username);
    }
    
    public User GetUser(String username, String password) {
        return userdao.GetUser(username, password);
    }
    
    public Long CountUsers() {
        return userdao.CountUsers();
    }
}
