package com.greekshop.domain.dao;

import com.greekshop.domain.data.Account;
import com.greekshop.domain.data.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Category findCategory(long id) {
        String sql = "Select a FROM " + Category.class.getName() + " a "//
                + " WHERE a.id = :id";

        Session session = this.sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery(sql, Category.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


}