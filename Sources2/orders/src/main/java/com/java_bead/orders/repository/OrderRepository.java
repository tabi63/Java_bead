package com.java_bead.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_bead.orders.model.Order;
import com.java_bead.orders.model.OrderState;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
   /*  @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.customerName = :customerName, o.customerAddress = :customerAddress, o.orderDate = :orderDate, o.amount = :amount, " +
        "o.lastModifiedBy = :lastModifiedBy, o.lastModifiedOn = :lastModifiedOn, o.orderState = :orderState " +
        "WHERE o.id = :id")
    int updateOrderFields(@Param("id") Long id, 
                    @Param("customerName") String customerName,
                    @Param("customerAddress") String customerAddress,
                    @Param("orderDate") java.sql.Date orderDate,
                    @Param("amount") Integer amount,
                    @Param("lastModifiedBy") String lastModifiedBy,
                    @Param("lastModifiedOn") java.sql.Timestamp lastModifiedOn,
                    @Param("orderState") OrderState orderState); */
}
