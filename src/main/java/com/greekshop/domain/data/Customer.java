package com.greekshop.domain.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Customers_Info")
public class Customer {

    private static final long serialVersionUID = -7483956206389564990L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Customer_First_Name", length = 255, nullable = false)
    private String customerFirstName;

    @Column(name = "Customer_Last_Name", length = 255, nullable = false)
    private String customerLastName;

    @Column(name = "Customer_Email", length = 128, nullable = false)
    private String customerEmail;

    @Column(name = "Customer_Phone", length = 128, nullable = false)
    private String customerPhone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
    private Date createDate;

}
