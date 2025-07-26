package com.larina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larina.model.StandsGroupRelation;

@Repository
public interface StandsGroupRelationRepository extends JpaRepository<StandsGroupRelation, Long> {

}
