package com.example.CoffeeSystemKapetalista.service;

import com.example.CoffeeSystemKapetalista.dto.MembershipRequestDTO;
import com.example.CoffeeSystemKapetalista.dto.MembershipUpdateDTO;
import com.example.CoffeeSystemKapetalista.entity.Membership;
import com.example.CoffeeSystemKapetalista.entity.Orders;
import com.example.CoffeeSystemKapetalista.repo.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MembershipServiceIMPL implements MembershipService{
    @Autowired
    private MembershipRepo membershipRepo;

    @Override
    public ResponseEntity<Map<String, String>> addMember(MembershipRequestDTO membershipRequestDTO) {
        Membership membership = new Membership(
                membershipRequestDTO.name,
                membershipRequestDTO.contact,
                membershipRequestDTO.email
        );

        membershipRepo.save(membership);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Membership Added!");
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Membership> getAllMembership() {
        return membershipRepo.findAll();
    }

    @Override
    public ResponseEntity<Map<String, String>> updateMembership(int membershipID, MembershipUpdateDTO membershipUpdateDTO) {
        Membership existingMember = membershipRepo.findById(membershipID).orElse(null);
        if (existingMember != null) {
            existingMember.setName(membershipUpdateDTO.name);
            existingMember.setContact(membershipUpdateDTO.contact);
            existingMember.setEmail(membershipUpdateDTO.email);

            membershipRepo.save(existingMember);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Membership Updated!");
            return ResponseEntity.ok(response);
        }
        else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "The data is not found");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteMembership(int membershipID) {
        Map<String, String> response = new HashMap<>();

        if (membershipRepo.existsById(membershipID)) {
            membershipRepo.deleteById(membershipID);
            response.put("message", "Deleted Successfully!");
            return ResponseEntity.ok(response);
        }
        else{
            response.put("message", "ID not found!");
            return ResponseEntity.ok(response);
        }
    }
}
