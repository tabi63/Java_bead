package com.java_bead.orders.model;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "\"orderitem\"", schema = "\"Orders\"")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                 //megrendelés tételének egyedi azonosítója

    @Column(name = "orderid")
    private Long orderId;            //megrendelés egyedi azonosítója

    @Column(name = "productname")
    private String productName;     //termék neve

    @Column(name = "piece")
    private Integer piece;              //darabszám

    @Column(name = "unitprice")
    private Integer unitPrice;          //egység ár

    @Column(name = "createdon")
    private Date createdOn;         //Létrehozás ideje

    @Column(name = "createdby")
    private String createdBy;       //Létrehozó

    @Column(name = "lastmodifiedon")
    private Date lastmodifiedOn;    //Utolsó módosítás ideje

    @Column(name = "lastmodifiedby")
    private String lastModifiedBy;  //Utolső mődosító

    public OrderItem() {}

    public OrderItem(Integer id, Long orderId, String productName, Integer piece, Integer unitPrice, Date createdOn, String createdBy, Date lastmodifiedOn, String lastModifiedBy) {
        this.id = id;
        this.orderId = orderId;
        this.productName = productName;
        this.piece = piece;
        this.unitPrice = unitPrice;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastmodifiedOn = lastmodifiedOn;
        this.lastModifiedBy =lastModifiedBy;
}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getPiece() {
        return piece;
    }
    public void setPiece(Integer piece) {
        this.piece = piece;
    }
    public Integer getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
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
