package com.java_bead.orders.model;
import jakarta.persistence.*;

@Entity
@Table(name = "\"orderstate\"", schema = "\"Orders\"")
public class OrderState
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //egyedi azonosítő

    @Column(name = "description")
    private String description; //megrendelés állapota

    public OrderState() { }

    public OrderState(Integer id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }    
}
