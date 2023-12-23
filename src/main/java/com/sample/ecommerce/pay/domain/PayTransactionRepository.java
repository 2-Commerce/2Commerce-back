package com.sample.ecommerce.pay.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayTransactionRepository extends JpaRepository<PayTransaction, Long> {
}
