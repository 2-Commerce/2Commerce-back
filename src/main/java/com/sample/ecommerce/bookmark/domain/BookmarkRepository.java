package com.sample.ecommerce.bookmark.domain;

import com.sample.ecommerce.product.domain.Product;
import com.sample.ecommerce.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByUserAndProduct(User user, Product product);
}
