package com.example.persistence.dao;

import com.example.persistence.entities.OfficerJpa;
import com.example.persistence.repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OfficerDaoImplJpa implements OfficerDaoJpa {

    @Autowired
    private OfficerRepository repository;

    @Override
    public OfficerJpa save(OfficerJpa officer) {
        repository.save(officer);
        return officer;
    }

    @Override
    public Optional<OfficerJpa> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<OfficerJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return repository.count(); //.createQuery("select count(o.id) from officers o", Long.class).getSingleResult();
    }

    @Override
    public void delete(OfficerJpa officer) {
        repository.delete(officer);
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }
}
