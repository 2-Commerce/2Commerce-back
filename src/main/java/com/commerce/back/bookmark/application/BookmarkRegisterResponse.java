package com.commerce.back.bookmark.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "북마크 등록 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkRegisterResponse {

    @Schema(description = "북마크 ID")
    private Long bookmarkId;
}
