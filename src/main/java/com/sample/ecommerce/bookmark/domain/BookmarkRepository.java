package com.sample.ecommerce.bookmark.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByUserIdAndProductId(String userId, Long productId);
}
