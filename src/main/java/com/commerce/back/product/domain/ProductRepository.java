package com.commerce.back.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT p FROM Product p " +
            "WHERE (:keyword is null or :keyword = '' or p.productName like concat('%', :keyword, '%')) " +
            "AND (:category is null or :category = '' or p.productCategory = :category)")
    List<Product> searchProduct(@Param("keyword") String keyword, @Param("category") String category);
}
