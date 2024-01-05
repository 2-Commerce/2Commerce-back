package com.sample.ecommerce.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p " +
            "WHERE (:keyword is null or :keyword = '' or p.productName like concat('%', :keyword, '%')) " +
            "AND (:category is null or :category = '' or p.productCategory = :category)")
    List<Product> searchProduct(@Param("keyword") String keyword, @Param("category") String category);

    @Query("SELECT p FROM Product p " +
            "JOIN FETCH p.store " +
            "WHERE p.productId IN :productIdList")
    List<Product> findAllByIdWithStore(@Param("productIdList") List<Long> productIdList);

    @Query("SELECT p FROM Product p " +
            "JOIN FETCH p.store " +
            "WHERE (:storeId is null or p.store.storeId = :storeId)")
    List<Product> findProductsByStoreId(@Param("storeId") Long storeId);
}
