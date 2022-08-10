package com.jva.dao.jpa;

import com.jva.dao.UserDao;
import com.jva.entity.User;
import com.jva.entity.User_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
public class JpaUserDao implements UserDao{

    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void AddUser(User user) {
        em.persist(user);
    }
    
    @Override
    public void DeleteUser(User user) {
        em.remove(user);
    }
    
    @Override
    public User GetUser(String username, String password) {    
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);

        Root<User> user = query.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(user.get(User_.username), username));
        predicates.add(cb.equal(user.get(User_.password), password));

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        User userFind = new User();
        
        try {
            userFind = em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        return userFind;
    }
    
    @Override
    public User GetUserByUsername(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);

        Root<User> user = query.from(User.class);
        query.where(cb.equal(user.get(User_.username), username));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public void UpdateUser(User user) {
        em.merge(user);
    }

    @Override
    public Long CountUsers() {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(User.class)));
        
        return em.createQuery(cq).getSingleResult();
    }    
}
