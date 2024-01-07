package com.sample.ecommerce.order.application;

import com.sample.ecommerce.order.domain.Order;
import com.sample.ecommerce.order.domain.OrderProduct;
import com.sample.ecommerce.order.domain.OrderProductRepository;
import com.sample.ecommerce.order.domain.OrderRepository;
import com.sample.ecommerce.pay.application.PayRegisterRequest;
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

    public Order payOrder(PayRegisterRequest payRegisterRequest){
        final Order order = orderRepository.findById(payRegisterRequest.getOrderId()).orElseThrow();
        order.pay(payRegisterRequest);
        List<OrderProduct> orderProductList = orderProductRepository.findByOrderId(order.getOrderId());
        orderProductList.forEach(OrderProduct::pay);
        orderProductRepository.saveAll(orderProductList);
        return orderRepository.save(order);
    }

    public OrderGetResponse getOrder(OrderGetRequest orderGetRequest) {
        OrderDto orderDto = orderRepository.findById(orderGetRequest.getOrderId()).orElseThrow().toDto();
        List<OrderProductGetResponse> productGetResponseList = orderProductRepository.findByOrderId(orderGetRequest.getOrderId()).stream().map(OrderProduct::toDto).map(OrderProductDto::toGetResponse).toList();
        return new OrderGetResponse(orderDto, productGetResponseList);
    }

    public OrderCancelResponse cancelOrder(Long orderId) {
        final Order order = orderRepository.findById(orderId).orElseThrow();
        order.cancel();
        OrderDto orderDto = order.toDto();
        return new OrderCancelResponse(orderDto);
    }

    public List<OrderProductGetResponse> getOrderInStore(Long storeId) {
        List<OrderProduct> orderProductList = orderProductRepository.findByStoreId(storeId);
        return orderProductList.stream().map(OrderProduct::toDto).map(OrderProductDto::toGetResponse).toList();
    }

    public OrderProductDeliveryResponse startDeliveryOrderProduct(OrderProductDeliveryRequest orderProductDeliveryRequest) {
        final OrderProduct orderProduct = orderProductRepository.findById(orderProductDeliveryRequest.getOrderProductId()).orElseThrow();
        orderProduct.startDelivery();
        final Order order = orderRepository.findById(orderProduct.getOrderId()).orElseThrow();
        order.startDelivery();
        orderRepository.save(order);
        orderProductRepository.save(orderProduct);
        return orderProduct.toDto().toDeliveryResponse();
    }
}
