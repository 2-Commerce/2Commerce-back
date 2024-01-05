package com.sample.ecommerce.product.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Schema(description = "가게 물품 응답")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInStoreGetResponse {

    @Schema(description = "물품 리스트")
    private List<ProductDto> productList;
}
