package com.larina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larina.model.Stand;

@Repository
public interface StandsRepository extends JpaRepository<Stand, Long> {

}
