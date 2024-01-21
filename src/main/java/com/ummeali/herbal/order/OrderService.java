package com.ummeali.herbal.order;


import com.ummeali.herbal.basket.BasketRepository;
import com.ummeali.herbal.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private BasketRepository basketRepository;
    private UserRepository userRepository;
    private OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository, BasketRepository basketRepository, UserRepository userRepository){
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public int create(Order order){
        if(order.getBasketId() == null){
            throw new IllegalArgumentException("Invalid basket");
        }
        if(order.getUserId() == null || !userRepository.existsById(order.getUserId())){
            throw new IllegalArgumentException("Invalid user");
        }
        if(orderRepository.existsByBasketId(order.getBasketId())){
            throw new IllegalArgumentException("Invalid order. Basket is used.");
        }
        Order newOrder = orderRepository.save(order);
        return orderRepository.findById(newOrder.getOrderId()).get().getOrderId();
    }

    public Order get(Integer orderId){
        return orderRepository.findById(orderId).get();
    }

    public void updateOrderStatus(Integer orderId, String userNotes){
        Order updatedOrder = get(orderId);
        updatedOrder.setUserNotes(userNotes);
        orderRepository.save(updatedOrder);
    }

    public void updateDeliveryAddress(Integer orderId, List<String> addressLines, String country){
        Order updatedOrder = get(orderId);
        if(addressLines == null || addressLines.isEmpty()){
            throw new IllegalArgumentException("Please enter updated address lines.");
        } else if (addressLines.size() > 3){
            throw new IllegalArgumentException("Only 3 address lines are allowed.");
        }
        if(addressLines.size() == 3){
            updatedOrder.setDeliveryAddressLine1(addressLines.get(0));
            updatedOrder.setDeliveryAddressLine1(addressLines.get(1));
            updatedOrder.setDeliveryAddressLine1(addressLines.get(2));
        } else if(addressLines.size() == 2){
            updatedOrder.setDeliveryAddressLine1(addressLines.get(0));
            updatedOrder.setDeliveryAddressLine1(addressLines.get(1));
        } else {
            updatedOrder.setDeliveryAddressLine1(addressLines.get(0));
        }
        updatedOrder.setDeliveryCountry(country);
        orderRepository.save(updatedOrder);
    }

    public void updateOrderStatus(Integer orderId, String status, String statusUpdateReason){
        Order updatedOrder = get(orderId);
        updatedOrder.setStatus(status);
        updatedOrder.getStatusUpdateReason().add(statusUpdateReason);
        updatedOrder.setStatusUpdateReason(updatedOrder.getStatusUpdateReason());
        orderRepository.save(updatedOrder);
    }
}
