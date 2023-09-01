package com.example.CoffeeSystemKapetalista.service;

import com.example.CoffeeSystemKapetalista.dto.MembershipRequestDTO;
import com.example.CoffeeSystemKapetalista.dto.MembershipUpdateDTO;
import com.example.CoffeeSystemKapetalista.entity.Membership;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MembershipService {
    ResponseEntity<Map<String, String>> addMember(MembershipRequestDTO membershipRequestDTO);

    List<Membership> getAllMembership();

    ResponseEntity<Map<String, String>> updateMembership(int membershipID, MembershipUpdateDTO membershipUpdateDTO);

    ResponseEntity<Map<String, String>> deleteMembership(int membershipID);
}
