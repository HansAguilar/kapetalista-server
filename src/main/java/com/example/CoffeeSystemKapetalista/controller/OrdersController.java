package com.example.CoffeeSystemKapetalista.controller;

import com.example.CoffeeSystemKapetalista.dto.OrderRequestDTO;
import com.example.CoffeeSystemKapetalista.dto.OrderUpdateDTO;
import com.example.CoffeeSystemKapetalista.entity.Orders;
import com.example.CoffeeSystemKapetalista.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;  // new instance

    // GET METHOD
    @GetMapping(path = "/get-orders")
    public List<Orders> getOrders(){
        return ordersService.getAllOrders();
    }

    // POST METHOD
    @PostMapping(path = "/create-order")
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        return ordersService.addOrder(orderRequestDTO);
    }

    // PUT METHOD
    @PutMapping(path = "/edit-order/{orderId}")
    public ResponseEntity<Map<String, String>> editOrder(@PathVariable int orderId, @RequestBody OrderRequestDTO orderRequestDTO){
        return ordersService.editOrder(orderId, orderRequestDTO);
    }

    // UPDATE METHOD
    @PutMapping(path = "/update-order/{orderId}")
    public ResponseEntity<Map<String, String>> updateOrder(@PathVariable int orderId, @RequestBody OrderUpdateDTO orderUpdateDTO){
        orderUpdateDTO.setOrderID(orderId);
        return ordersService.updateOrder(orderUpdateDTO);
    }

    // DELETE METHOD
    @DeleteMapping(path = "/delete-order/{orderId}")
    public  ResponseEntity<Map<String, String>> deleteOrder(@PathVariable int orderId){
        return ordersService.deleteOrder(orderId);
    }
}
