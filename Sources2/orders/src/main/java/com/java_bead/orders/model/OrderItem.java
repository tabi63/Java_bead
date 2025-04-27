package com.java_bead.orders.model;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "\"orderitem\"", schema = "\"Orders\"")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                 //megrendelés tételének egyedi azonosítója

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderid", referencedColumnName = "id", nullable = false)
    private Order order;            //megrendelés egyedi azonosítója

    @Column(name = "productname")
    private String productName;     //termék neve

    @Column(name = "piece")
    private Integer piece;              //darabszám

    @Column(name = "unitprice")
    private Integer unitPrice;          //egység ár

    @Column(name = "createdon")
    private Timestamp createdOn;         //Létrehozás ideje

    @Column(name = "createdby")
    private String createdBy;       //Létrehozó

    @Column(name = "lastmodifiedon")
    private Timestamp lastmodifiedOn;    //Utolsó módosítás ideje

    @Column(name = "lastmodifiedby")
    private String lastModifiedBy;  //Utolsó módosító

    public OrderItem() {}

    public OrderItem(Long id, Order order, String productName, Integer piece, Integer unitPrice, Timestamp createdOn, String createdBy, Timestamp lastmodifiedOn, String lastModifiedBy) {
        this.id = id;
        this.order = order;
        this.productName = productName;
        this.piece = piece;
        this.unitPrice = unitPrice;
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
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
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
        return lastmodifiedOn;
    }
    public void setLastModifiedOn(Timestamp lastmodifiedOn) {
        this.lastmodifiedOn = lastmodifiedOn;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
