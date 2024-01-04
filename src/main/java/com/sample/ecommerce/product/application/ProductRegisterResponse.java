package com.sample.ecommerce.product.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "물품 등록 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisterResponse {

    @Schema(description = "물품 ID")
    private Long productId;
}
