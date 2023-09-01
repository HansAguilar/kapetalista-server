package com.example.CoffeeSystemKapetalista.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderID;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "order_date", length = 50)
    private String orderDate;

    @Column(name = "coffee_order", length = 100)
    private String coffeeOrder;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "size", length = 50)
    private String size;

    @Column(name = "order_status", length = 50)
    private String orderStatus;

    @Column(name = "notes", length = 50)
    private String notes;

    @Column(name = "amount")
    private double amount;

    public Orders(){

    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setCoffeeOrder(String coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Orders(int orderID, String nickname, String order_date, double amount, String order_status, String order, int quantity, String size, String notes) {
        this.orderID = orderID;
        this.nickname = nickname;
        this.orderDate = order_date;
        this.amount = amount;
        this.orderStatus = order_status;
        this.coffeeOrder = order;
        this.notes = notes;
        this.quantity = quantity;
        this.size = size;
    }

    public Orders(String order_date, String nickname, double amount, String order_status, String order, int quantity, String size, String notes) {
        this.orderDate = order_date;
        this.nickname = nickname;
        this.amount = amount;
        this.orderStatus = order_status;
        this.coffeeOrder = order;
        this.notes = notes;
        this.quantity = quantity;
        this.size = size;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrder_status(String order_status) {
        this.orderStatus = order_status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", nickname='" + nickname + '\'' +
                ", order_date='" + orderDate + '\'' +
                ", order='" + coffeeOrder + '\'' +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                ", order_status='" + orderStatus + '\'' +
                ", notes='" + notes + '\'' +
                ", amount=" + amount +
                '}';
    }
}
