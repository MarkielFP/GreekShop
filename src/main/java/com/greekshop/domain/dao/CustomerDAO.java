package com.greekshop.domain.dao;

import com.greekshop.domain.data.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Customer findCustomer(long customerId) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Customer.class, customerId);
    }


}
