package com.greekshop.domain.dao;

import com.greekshop.domain.data.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account findAccount(String userName) {
        String sql = "Select a FROM " + Account.class.getName() + " a "//
                + " WHERE a.userName = :userName";

        Session session = this.sessionFactory.getCurrentSession();
        Query<Account> query = session.createQuery(sql, Account.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
    }


}