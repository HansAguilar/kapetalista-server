package com.example.CoffeeSystemKapetalista.service;

import com.example.CoffeeSystemKapetalista.dto.OrderRequestDTO;
import com.example.CoffeeSystemKapetalista.dto.OrderUpdateDTO;
import com.example.CoffeeSystemKapetalista.entity.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    ResponseEntity<Map<String, String>> addOrder(OrderRequestDTO orderRequestDTO); // Update the return type
    ResponseEntity<Map<String, String>> editOrder(int orderId, OrderRequestDTO orderRequestDTO);

    List<Orders> getAllOrders();
    ResponseEntity<Map<String, String>> updateOrder(OrderUpdateDTO orderUpdateDTO);

    ResponseEntity<Map<String, String>> deleteOrder(int orderId);
}
