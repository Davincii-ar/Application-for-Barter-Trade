package com.jva.dao;

import com.jva.entity.User;
import javax.ejb.Local;

@Local
public interface UserDao {
    public void AddUser(User user);    
    public void DeleteUser(User user);
    public void UpdateUser(User user);
    public User GetUserByUsername(String username);
    public User GetUser(String username, String password);
    public Long CountUsers();
}
