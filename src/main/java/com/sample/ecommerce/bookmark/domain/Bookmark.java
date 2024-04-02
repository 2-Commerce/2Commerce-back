package com.sample.ecommerce.bookmark.domain;

import com.sample.ecommerce.bookmark.application.BookmarkDto;
import com.sample.ecommerce.bookmark.application.BookmarkRegisterRequest;
import com.sample.ecommerce.product.domain.Product;
import com.sample.ecommerce.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`bookmark`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Bookmark(BookmarkRegisterRequest request) {

    }

    public BookmarkDto toDto() { return new BookmarkDto(bookmarkId, user.getUserId(), product.getProductId()); }

    public void assignUser(User user) {
        this.user = user;
    }

    public void assignProduct(Product product) {
        this.product = product;
    }
}
