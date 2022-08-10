/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jva.service;

import com.jva.dao.ItemDao;
import com.jva.entity.Item;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ItemService {
    @EJB
    private ItemDao itemDao;
    
    public void AddItem(Item objects) {
       itemDao.AddItem(objects);
    }
    
    public void UpdateItem(Item objects) {
        itemDao.UpdateItem(objects);
    }
    
    public Item GetItemByTitle(String title) {
        return itemDao.GetItemByTitle(title);
    }
    
    public Item GetItems() {
        return itemDao.GetItem();
    }
    
    public Long CountItems() {
        return itemDao.CountItems();
    }
    
    public List<Item> ListItems () {
        return itemDao.ListItems();
    }
    public void DeleteItem(Item object) {
        itemDao.DeleteItem(object);
    }
}
