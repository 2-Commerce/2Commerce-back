package com.sample.ecommerce.bookmark.application;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "북마크 등록 요청")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkRegisterRequest {

    @Schema(description = "물품 ID")
    @NotNull(message = "물품 ID는 필수로 입력해야 합니다.")
    private Long productId;

    @Schema(description = "유저 ID")
    @NotNull(message = "유저 ID는 필수로 입력해야 합니다.")
    private String userId;
}
