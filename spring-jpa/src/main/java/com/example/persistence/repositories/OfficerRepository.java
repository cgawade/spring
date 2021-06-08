package com.example.persistence.repositories;

import com.example.persistence.entities.OfficerJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OfficerRepository extends JpaRepository<OfficerJpa, Integer> {
}
