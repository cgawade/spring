package com.example.persistence.dao;

import com.example.persistence.entities.OfficerJpa;

import java.util.Optional;

public interface OfficerDaoJpa {
    OfficerJpa save(OfficerJpa officer);
    Optional<OfficerJpa> findById(Integer id);
    Iterable<OfficerJpa> findAll();
    long count();
    void delete(OfficerJpa officer);
    boolean existsById(Integer id);
}
