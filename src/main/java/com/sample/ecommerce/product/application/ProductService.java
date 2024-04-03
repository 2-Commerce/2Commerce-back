package com.sample.ecommerce.product.application;

import com.sample.ecommerce.order.application.OrderProductRegisterRequest;
import com.sample.ecommerce.product.domain.Product;
import com.sample.ecommerce.product.domain.ProductRepository;
import com.sample.ecommerce.store.application.StoreService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepository;

    StoreService storeService;

    public List<ProductDto> searchProductList(ProductSearchRequest productSearchRequest) {
        return productRepository.searchProduct(productSearchRequest.getKeyword(), productSearchRequest.getCategory()).stream().map(Product::toDto).collect(Collectors.toList());
    }

    public List<ProductWithStoreDto> orderProduct(List<OrderProductRegisterRequest> orderProductList){
        List<Long> productIdList = orderProductList.stream().map(OrderProductRegisterRequest::getProductId).toList();
        List<Product> productList=  productRepository.findAllByIdWithStore(productIdList);
        Map<Long, Long> orderProductMap = orderProductList.stream().collect(Collectors.toMap(OrderProductRegisterRequest::getProductId, OrderProductRegisterRequest::getProductOrderQuantity));
        productList.forEach(product -> product.order(orderProductMap.get(product.getProductId())));
        return productList.stream().map(Product::toDtoWithStore).toList();
    }

    public ProductDto registerProduct(ProductRegisterRequest productRegisterRequest) {
        final Product product = productRepository.save(new Product(productRegisterRequest, storeService.findStore(productRegisterRequest.getStoreId())));
        return product.toDto();
    }

    public List<ProductDto> getProductInStore(Long storeId) {
        return productRepository.findProductsByStoreId(storeId).stream().map(Product::toDto).toList();
    }

    public ProductUpdateResponse updateProduct(ProductUpdateRequest productUpdateRequest) {
        final Product product = productRepository.findById(productUpdateRequest.getProductId()).orElseThrow();
        product.update(productUpdateRequest);
        return product.toDto().toUpdateResponse();
    }

    public Product getProduct(Long productId){
        return productRepository.findById(productId).orElseThrow();
    }
}
