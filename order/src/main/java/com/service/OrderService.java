package com.service;

import com.domain.Order;
import com.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.repository.OrderRepository;
import com.transfer.OrderGetDto;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;

    public OrderGetDto getOrder(UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("No such order!"));
        User user = getOrdersUser(order.getUserId());
        return OrderGetDto
                .builder().orderId(orderId)
                .userId(user.getId())
                .userName(user.getName())
                .build();
    }

    private User getOrdersUser(UUID userId) {
        return userService.findUser(userId);
    }


}
