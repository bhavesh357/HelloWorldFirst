package com.firstspringapp.repository;

import com.firstspringapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}
