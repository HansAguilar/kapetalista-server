package com.example.CoffeeSystemKapetalista.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id")
    private int membershipID;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "contact", length = 100)
    private String contact;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "date", length = 100)
    private String date;

    public Membership(){}

    public Membership(String name, String contact, String email, String date) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.date = date;
    }

    public Membership(int membershipID, String name, String contact, String email, String date) {
        this.membershipID = membershipID;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.date = date;
    }

    public int getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(int membershipID) {
        this.membershipID = membershipID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
