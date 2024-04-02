package com.sample.ecommerce.order.application;

import com.sample.ecommerce.order.domain.Order;
import com.sample.ecommerce.order.domain.OrderProduct;
import com.sample.ecommerce.order.domain.OrderProductRepository;
import com.sample.ecommerce.order.domain.OrderRepository;
import com.sample.ecommerce.pay.application.PayRegisterRequest;
import com.sample.ecommerce.product.application.ProductService;
import com.sample.ecommerce.product.application.ProductWithStoreDto;
import com.sample.ecommerce.user.domain.User;
import com.sample.ecommerce.user.domain.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;
    OrderProductRepository orderProductRepository;

    UserRepository userRepository;

    ProductService productService;

    public OrderDto registerOrder(OrderRegisterRequest orderRegisterRequest) {
        User user = userRepository.findByUserId(orderRegisterRequest.getUserId()).orElseThrow();

        List<ProductWithStoreDto> orderProductDtoList = productService.orderProduct(orderRegisterRequest.getProductList());
        Long orderAmount = orderProductDtoList.stream().mapToLong(product -> product.getProductPrice() * product.getProductOrderQuantity()).sum();

        Order order = new Order(orderRegisterRequest, orderAmount, user);
        orderRepository.save(order);

        OrderDto orderDto = order.toDto();
        List<OrderProduct> orderProductList = orderProductDtoList.stream().map(orderProductDto -> new OrderProduct(orderDto,  orderProductDto)).toList();
        orderProductRepository.saveAll(orderProductList);
        return orderDto;
    }

    public Order payOrder(PayRegisterRequest payRegisterRequest){
        final Order order = orderRepository.findById(payRegisterRequest.getOrderId()).orElseThrow();
        order.pay(payRegisterRequest);
        List<OrderProduct> orderProductList = orderProductRepository.findByOrder(order);
        orderProductList.forEach(OrderProduct::pay);
        return order;
    }

    public OrderGetResponse getOrder(OrderGetRequest orderGetRequest) {
        Order order = orderRepository.findById(orderGetRequest.getOrderId()).orElseThrow();
        List<OrderProductGetResponse> productGetResponseList = orderProductRepository.findByOrder(order).stream().map(OrderProduct::toDto).map(OrderProductDto::toGetResponse).toList();
        return new OrderGetResponse(order.toDto(), productGetResponseList);
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
        final Order order = orderRepository.findById(orderProduct.getOrder().getOrderId()).orElseThrow();
        order.startDelivery();
        return orderProduct.toDto().toDeliveryResponse();
    }

    public OrderProductDeliveryResponse completeDelivery(OrderProductDeliveryRequest orderProductDeliveryRequest) {
        final OrderProduct orderProduct = orderProductRepository.findById(orderProductDeliveryRequest.getOrderProductId()).orElseThrow();
        orderProduct.completeDelivery();
        final Order order = orderRepository.findById(orderProduct.getOrder().getOrderId()).orElseThrow();
        order.completeDelivery();
        return orderProduct.toDto().toDeliveryResponse();
    }
}
