package com.example.CoffeeSystemKapetalista.entity;

import javax.persistence.*;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "membership_id")
    private int membershipID;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "contact", length = 100)
    private String contact;

    @Column(name = "email", length = 100)
    private String email;

    public Membership(String name, String contact, String email) {
        this.name = name;
        this.contact = contact;
        this.email = email;
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

    @Override
    public String toString() {
        return "Membership{" +
                "membershipID=" + membershipID +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}