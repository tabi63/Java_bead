package com.java_bead.orders.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "\"order\"", schema = "\"Orders\"")
//Megrendelések osztálya
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                     //Egyedi azonosító

    @Column(name = "customerName") //Vevő neve
    private String customerName;
    
    @Column(name = "customerAddress") //Vevő címe
    private String customerAddress;
    
    @Column(name = "orderdate") //Megrendelés ideje
    private Date orderDate;
    
    @Column(name = "amount") //Fizetendő összeg
    private Integer amount;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderstateid", referencedColumnName = "id")
    private OrderState orderState; // Megrendelés állapota
    
    @Column(name = "createdon") //Létrehozás ideje
    private Timestamp createdOn;
    
    @Column(name = "createdby") //Létrehozó
    private String createdBy;
    
    @Column(name = "lastmodifiedon") //Utolsó módosítás ideje
    private Timestamp lastModifiedOn;
    
    @Column(name = "lastmodifiedby") //Utolsó módosító
    private String lastModifiedBy;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems; // Rendeles tételek listája

    public Order() {}

    public Order(Long id, String customerName, String customerAddress, Date orderDate, Integer amount, OrderState orderState, Timestamp createdOn, String createdBy,
        Timestamp lastModifiedOn, String lastModifiedBy) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.amount = amount;
        this.orderState = orderState;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastModifiedOn = lastModifiedOn;
        this.lastModifiedBy =lastModifiedBy;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public OrderState getOrderState() {
        return orderState;
    }
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
    public Timestamp getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Timestamp getLastModifiedOn() {
        return lastModifiedOn;
    }
    public void setLastModifiedOn(Timestamp lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
