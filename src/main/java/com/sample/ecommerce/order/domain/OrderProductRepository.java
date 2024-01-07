package com.sample.ecommerce.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    List<OrderProduct> findByOrder(Order order);

    List<OrderProduct> findByStoreId(Long storeId);
}
