package com.greekshop.domain.dao;

import com.greekshop.domain.data.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Repository
public class AccountDAO {

    @Autowired
    private EntityManager em;

    public Account findAccount(String userName) {

        return em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username", Account.class).
                setParameter("username", userName).getSingleResult();
    }

}