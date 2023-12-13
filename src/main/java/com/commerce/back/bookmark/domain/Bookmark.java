package com.commerce.back.bookmark.domain;

import com.commerce.back.bookmark.application.BookmarkDto;
import com.commerce.back.bookmark.application.BookmarkRegisterRequest;
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

    private String userId;

    private Long productId;

    public Bookmark(BookmarkRegisterRequest bookmarkRegisterRequest) {
        this.userId = bookmarkRegisterRequest.getUserId();
        this.productId = bookmarkRegisterRequest.getProductId();
    }

    public BookmarkDto toDto() { return new BookmarkDto(bookmarkId, userId, productId); }
}
