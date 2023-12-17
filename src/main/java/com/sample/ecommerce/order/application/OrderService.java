package com.sample.ecommerce.order.application;

import com.sample.ecommerce.order.domain.Order;
import com.sample.ecommerce.order.domain.OrderProduct;
import com.sample.ecommerce.order.domain.OrderProductRepository;
import com.sample.ecommerce.order.domain.OrderRepository;
import com.sample.ecommerce.product.application.ProductService;
import com.sample.ecommerce.product.application.ProductWithStoreDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;
    OrderProductRepository orderProductRepository;

    ProductService productService;

    public OrderDto registerOrder(OrderRegisterRequest orderRegisterRequest) {
        List<ProductWithStoreDto> orderProductDtoList = productService.orderProduct(orderRegisterRequest.getProductList());
        Long orderAmount = orderProductDtoList.stream().mapToLong(product -> product.getProductPrice() * product.getProductOrderQuantity()).sum();
        final Order order = orderRepository.save(new Order(orderRegisterRequest, orderAmount));
        OrderDto orderDto = order.toDto();
        List<OrderProduct> orderProductList = orderProductDtoList.stream().map(orderProductDto -> new OrderProduct(orderDto,  orderProductDto)).toList();
        orderProductRepository.saveAll(orderProductList);
        return orderDto;
    }
}
