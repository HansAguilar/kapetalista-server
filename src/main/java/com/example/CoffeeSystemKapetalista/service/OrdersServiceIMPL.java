package com.example.CoffeeSystemKapetalista.service;
import org.springframework.http.ResponseEntity;
import com.example.CoffeeSystemKapetalista.dto.OrderRequestDTO;
import com.example.CoffeeSystemKapetalista.dto.OrderUpdateDTO;
import com.example.CoffeeSystemKapetalista.entity.Orders;
import com.example.CoffeeSystemKapetalista.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceIMPL implements OrdersService{
    @Autowired
    private OrdersRepo ordersRepo;
    @Override
    public ResponseEntity<Map<String, String>> addOrder(OrderRequestDTO orderRequestDTO) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Orders order = new Orders(
                formattedDate,
                orderRequestDTO.nickname,
                orderRequestDTO.amount,
                "pending",
                orderRequestDTO.order,
                orderRequestDTO.quantity,
                orderRequestDTO.size,
                orderRequestDTO.notes
        );
        ordersRepo.save(order);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Order Added!");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, String>> editOrder(int orderId, OrderRequestDTO orderRequestDTO) {
        Orders existingOrder = ordersRepo.findById(orderId).orElse(null);
        if (existingOrder != null) {
            existingOrder.setNickname(orderRequestDTO.nickname);
            existingOrder.setAmount(orderRequestDTO.amount);
            existingOrder.setCoffeeOrder(orderRequestDTO.order);
            existingOrder.setQuantity(orderRequestDTO.quantity);
            existingOrder.setSize(orderRequestDTO.size);
            existingOrder.setNotes(orderRequestDTO.notes);

            ordersRepo.save(existingOrder);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Order Updated!");
            return ResponseEntity.ok(response);
        }
        else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Order not found");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @Override
    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    @Override
    public ResponseEntity<Map<String, String>> updateOrder(OrderUpdateDTO orderUpdateDTO) {
        Map<String, String> response = new HashMap<>();
        if (ordersRepo.existsById(orderUpdateDTO.getOrderID())) {
            Orders orderToUpdate = ordersRepo.findById(orderUpdateDTO.getOrderID()).orElse(null);

            if (orderToUpdate != null) {
                orderToUpdate.setOrder_status("Served");
                ordersRepo.save(orderToUpdate);
                response.put("message", "Order updated successfully.");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Order not found.");
                return ResponseEntity.ok(response);
            }
        } else {
            response.put("message", "Order with ID \" + orderUpdateDTO.getOrderID() + \" does not exist.");
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteOrder(int orderId) {
        Map<String, String> response = new HashMap<>();

        if (ordersRepo.existsById(orderId)) {
            ordersRepo.deleteById(orderId);
            response.put("message", "Deleted Successfully!");
            return ResponseEntity.ok(response);
        }
        else{
            response.put("message", "ID not found!");
            return ResponseEntity.ok(response);
        }
    }
}
