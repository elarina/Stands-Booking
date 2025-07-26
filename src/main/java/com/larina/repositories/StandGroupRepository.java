package com.larina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larina.model.StandsGroup;
@Repository
public interface StandGroupRepository extends JpaRepository<StandsGroup, Long> {

}
