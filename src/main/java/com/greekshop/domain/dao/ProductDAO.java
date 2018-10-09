package com.greekshop.domain.dao;


import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.greekshop.domain.data.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.greekshop.domain.data.Product;
import com.greekshop.form.ProductForm;
import com.greekshop.model.ProductInfo;
import com.greekshop.pagination.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductDAO {

    @Autowired
    private EntityManager em;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CategoryDAO categoryDAO;

    public Product findProduct(String code) {
        try {
            String sql = "SELECT e FROM " + Product.class.getName() //
                    + " e WHERE e.code =:code ";

            Session session = this.sessionFactory.getCurrentSession();
            Query<Product> query = session.createQuery(sql, Product.class);
            query.setParameter("code", code);
            return (Product) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public ProductInfo findProductInfo(String code) {
        Product product = this.findProduct(code);
        if (product == null) {
            return null;
        }
        return new ProductInfo(product);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void save(ProductForm productForm) {

        Session session = this.sessionFactory.getCurrentSession();
        String code = productForm.getCode();

        Product product = null;

        boolean isNew = false;
        if (code != null) {
            product = this.findProduct(code);
        }
        if (product == null) {
            isNew = true;
            product = new Product();
            product.setCreateDate(new Date());
        }

        // temporary setting default category "1" - 23%
        Category category = categoryDAO.findCategory(1);
        product.setCategory(category);

        product.setCode(code);
        product.setName(productForm.getName());
        product.setPriceNett(productForm.getPriceNett());
        product.setDescription(productForm.getDescription());
        product.setManufacturer(productForm.getManufacturer());
        product.setUnitsInStock(productForm.getUnitsInStock());
        product.setVatType(productForm.getVatType());
        product.setPromotion(productForm.isPromotion());

        if (productForm.getFileData() != null) {
            byte[] image = null;
            try {
                image = productForm.getFileData().getBytes();
            } catch (IOException e) {
            }
            if (image != null && image.length > 0) {
                product.setImage(image);
            }
        }
        if (isNew) {
            session.persist(product);
        }
        // If error in DB, Exceptions will be thrown out immediately
        session.flush();
    }

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, //
                                                       int maxNavigationPage, //
                                                       String likeName) {
        String sql = "SELECT new " + ProductInfo.class.getName() //
                + "(p.code, p.name, p.priceNett, p.description, p.manufacturer,"
                + "p.unitsInStock, p.vatType, p.createDate, p.category, p.isPromotion) "
                + " FROM " + Product.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " WHERE lower(p.name) like :likeName ";
        }
        sql += " ORDER BY p.createDate DESC ";

        Session session = this.sessionFactory.getCurrentSession();
        Query<ProductInfo> query = session.createQuery(sql, ProductInfo.class);

        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
        return queryProducts(page, maxResult, maxNavigationPage, null);
    }

}