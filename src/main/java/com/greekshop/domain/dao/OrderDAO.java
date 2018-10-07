package com.greekshop.domain.dao;

import java.util.Date;
import java.util.List;

import com.greekshop.domain.data.*;
import com.greekshop.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.greekshop.pagination.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Repository
public class OrderDAO {

    @Autowired
    private EntityManager em;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductDAO productDAO;

    private int getMaxOrderNum() {
        String sqlQuery = "SELECT max(o.orderNum) from " + Order.class.getName() + " o ";
        Integer value = em.createQuery(sqlQuery, Order.class).getSingleResult().getOrderNum();
        if (value == null) {
            return 0;
        }
        return value;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(CartInfo cartInfo) {

        int orderNum = this.getMaxOrderNum() + 1;
        Order order = new Order();

        order.setOrderNum(orderNum);
        order.setOrderDate(new Date());
        order.setAmountNett(cartInfo.getAmountTotalNett());

        // invoice ??
        // set amount gross

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        Customer customer = new Customer();

        customer.setCreateDate(new Date());
        customer.setCustomerCompanyName(customerInfo.getCompanyName());
        customer.setCustomerFirstName(customerInfo.getFirstName());
        customer.setCustomerLastName(customerInfo.getLastName());
        customer.setCustomerEmail(customerInfo.getEmail());
        customer.setCustomerPhone(customerInfo.getPhone());

        order.setCustomer(customer);

        AddressInfo addressInfo = cartInfo.getAddressInfo();
        Address address = new Address();

        address.setCustomer(customer);

        address.setCustomerCountry(addressInfo.getCountry());
        address.setCustomerCity(addressInfo.getCity());
        address.setCustomerZipCode(addressInfo.getZipCode());
        address.setCustomerStreet(addressInfo.getZipCode());
        address.setCustomerHouseNumber(addressInfo.getHouseNumber());

        order.setAddress(address);

        em.persist(customer);
        em.persist(address);
        em.persist(order);

        List<CartLineInfo> lines = cartInfo.getCartLines();

        for (CartLineInfo line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setPriceNett(line.getProductInfo().getPriceNett());
            detail.setAmountNett(line.getAmountNett());
            detail.setQuantity(line.getQuantity());

            String code = line.getProductInfo().getCode();
            Product product = this.productDAO.findProduct(code);
            detail.setProduct(product);

            em.persist(detail);
        }

        // Order Number!
        cartInfo.setOrderNum(orderNum);
        // Flush
        em.flush();
    }

    // @page = 1, 2, ...
    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
        String sql = "SELECT new " + OrderInfo.class.getName()//
                + "(ord.id, ord.orderNum, ord.orderDate, ord.amountGross, ord.amountNett, "
                + "ord.isInvoice, ord.customer, ord.address, ord.invoiceData, ord.invoice) "
                + " FROM " + Order.class.getName() + " ord "//
                + " ORDER BY ord.orderNum DESC";

        Session session = this.sessionFactory.getCurrentSession();
        Query<OrderInfo> query = session.createQuery(sql, OrderInfo.class);
        return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
    }

    public Order findOrder(String orderId) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Order.class, orderId);
    }

    public OrderInfo getOrderInfo(String orderId) {
        Order order = this.findOrder(orderId);
        if (order == null) {
            return null;
        }
        return new OrderInfo(order.getId(), order.getOrderDate(), //
                order.getOrderNum(), order.getAmountGross(), order.getAmountNett(), //
                order.isInvoice(), order.getCustomer(), order.getAddress(), //
                order.getInvoiceData(), order.getInvoice());
    }

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
        String sql = "SELECT new " + OrderDetailInfo.class.getName() //
                + "(d.id, d.order, d.product, d.quantity, d.priceNett, //"
                + "d.amountGross, d.amountNett) " //
                + " FROM " + OrderDetail.class.getName() + " d " //
                + " WHERE d.order.id = :orderId ";

        Session session = this.sessionFactory.getCurrentSession();
        Query<OrderDetailInfo> query = session.createQuery(sql, OrderDetailInfo.class);
        query.setParameter("orderId", orderId);

        return query.getResultList();
    }

}