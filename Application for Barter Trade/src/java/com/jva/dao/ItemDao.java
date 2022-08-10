package com.jva.dao;

import com.jva.entity.Item;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ItemDao {
    void AddItem(Item obj);    
    void UpdateItem(Item obj);
    public Item GetItemByTitle(String title);
    public Item GetItem();
    public Long CountItems();
    public List<Item> ListItems();
    public void DeleteItem(Item object);
}
