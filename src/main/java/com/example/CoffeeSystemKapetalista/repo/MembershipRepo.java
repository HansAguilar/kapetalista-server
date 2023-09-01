package com.example.CoffeeSystemKapetalista.repo;

import com.example.CoffeeSystemKapetalista.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MembershipRepo extends JpaRepository<Membership, Integer> {

}
