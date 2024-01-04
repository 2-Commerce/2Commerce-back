package com.sample.ecommerce.store.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "가게 등록 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRegisterResponse {

    @Schema(description = "가게 ID")
    private Long storeId;
}
