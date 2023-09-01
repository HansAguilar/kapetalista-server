package com.example.CoffeeSystemKapetalista.controller;

import com.example.CoffeeSystemKapetalista.dto.MembershipRequestDTO;
import com.example.CoffeeSystemKapetalista.dto.MembershipUpdateDTO;
import com.example.CoffeeSystemKapetalista.entity.Membership;
import com.example.CoffeeSystemKapetalista.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/membership")
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    // GET METHOD
    @GetMapping(path = "/get-membership")
    public List<Membership> getMembership(){
        return membershipService.getAllMembership();
    }

    // POST METHOD
    @PostMapping(path = "/create-membership")
    public ResponseEntity<Map<String, String>> createMembership(@RequestBody MembershipRequestDTO membershipRequestDTO){
        return membershipService.addMember(membershipRequestDTO);
    }

    // UPDATE METHOD
    @PutMapping(path = "/update-membership/{membershipID}")
    public ResponseEntity<Map<String, String>> updateMembership(@PathVariable int membershipID, @RequestBody MembershipUpdateDTO membershipUpdateDTO){
        return membershipService.updateMembership(membershipID, membershipUpdateDTO);
    }

    // DELETE METHOD
    @DeleteMapping(path = "/delete-membership/{membershipID}")
    public ResponseEntity<Map<String, String>> deleteMembership(@PathVariable int membershipID){
        return membershipService.deleteMembership(membershipID);
    }
}
