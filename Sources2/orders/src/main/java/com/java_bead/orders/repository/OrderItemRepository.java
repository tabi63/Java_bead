package com.java_bead.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_bead.orders.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);

 /*    @Modifying
    @Transactional
    @Query("UPDATE OrderItem o SET o.productName = :productName, o.piece = :piece, o.unitPrice = :unitPrice, " +
        "o.lastModifiedBy = :lastModifiedBy, o.lastModifiedOn = :lastModifiedOn " +
        "WHERE o.id = :id")
    int updateOrderItemFields(@Param("id") Long id, 
                    @Param("productName") String productName,
                    @Param("piece") Integer piece,
                    @Param("unitPrice") Integer unitPrice,
                    @Param("lastModifiedBy") String lastModifiedBy,
                    @Param("lastModifiedOn") java.sql.Timestamp lastModifiedOn); */
}
