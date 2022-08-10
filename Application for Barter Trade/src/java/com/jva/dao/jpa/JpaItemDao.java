package com.jva.dao.jpa;

import com.jva.dao.ItemDao;
import com.jva.entity.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class JpaItemDao implements ItemDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void AddItem(Item item) {
        em.persist(item);
    }
    
    @Override
    public Item GetItemByTitle(String title) {     
        
        Query query = em.createQuery("SELECT u FROM Item u WHERE u.title = :title");
        query.setParameter("title", title);        

        
        try {
            Item obj = (Item) query.getSingleResult();
            return obj;
        }
        catch (NoResultException exeption) {
            exeption.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Item GetItem() {
        return (Item)em.createQuery("SELECT u FROM Item")
                .getSingleResult();
    }

    @Override
    public void UpdateItem(Item item) {
        em.remove(GetItemByTitle(item.getTitle()));
        em.persist(item);
    }
    
    @Override
    public List<Item> ListItems () {
        return em.createQuery("SELECT u FROM Item u").getResultList();
    }
    
    @Override
    public Long CountItems() {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Item.class)));
        
        return em.createQuery(cq).getSingleResult();
    }
    
    @Override
    public void DeleteItem(Item item) {
        em.remove(item);
    }
}
