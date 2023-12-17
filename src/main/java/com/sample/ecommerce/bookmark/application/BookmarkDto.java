package com.sample.ecommerce.bookmark.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Schema(description = "북마크")
public class BookmarkDto {

    @Schema(description = "북마크 ID")
    private Long bookmarkId;

    @Schema(description = "유저 ID")
    private String userId;

    @Schema(description = "물품 ID")
    private Long productId;

    public BookmarkRegisterResponse toRegisterResponse() {return new BookmarkRegisterResponse(bookmarkId);};
}
