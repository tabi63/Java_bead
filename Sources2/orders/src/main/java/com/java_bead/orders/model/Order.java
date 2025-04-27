package com.java_bead.orders.model;

import java.sql.Date;
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
    
    @Column(name = "orderstateid") //Megrendelés állapota
    private Integer orderStateId;
    
    @Column(name = "createdon") //Létrehozás ideje
    private Date createdOn;
    
    @Column(name = "createdby") //Létrehozó
    private String createdBy;
    
    @Column(name = "lastmodifiedon") //Utolsó módosítás ideje
    private Date lastmodifiedOn;
    
    @Column(name = "lastmodifiedby") //Utolső mődosító
    private String lastModifiedBy;    

    public Order() {}

    public Order(Long id, String customerName, String customerAddress, Date orderDate, Integer amount, Integer orderStateId, Date createdOn, String createdBy,
                    Date lastmodifiedOn, String lastModifiedBy) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.amount = amount;
        this.orderStateId = orderStateId;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastmodifiedOn = lastmodifiedOn;
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
    public Integer getOrderStateId() {
        return orderStateId;
    }
    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getLastModifiedOn() {
        return lastmodifiedOn;
    }
    public void setLastModifiedOn(Date lastmodifiedOn) {
        this.lastmodifiedOn = lastmodifiedOn;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
