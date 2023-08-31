package com.example.CoffeeSystemKapetalista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequestDTO {
    public String nickname;
    public double amount;
    public String order;
    public int quantity;
    public String size;
    public String notes;
}
