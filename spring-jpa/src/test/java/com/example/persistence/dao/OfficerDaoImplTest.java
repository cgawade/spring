package com.example.persistence.dao;

import com.example.persistence.entities.Rank;
import com.example.persistence.entities.OfficerJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class OfficerDaoImplTest {

    @Autowired
    private OfficerDaoImplJpa officerDaoImplJpa;

    @Test
    public void save(){
        OfficerJpa officer = officerDaoImplJpa.save(new OfficerJpa("Shekhar", "Gawade", Rank.COMMANDER));
        assertNotNull(officer.getId());
    }

    @Test
    public void count(){
        long count = officerDaoImplJpa.count();
        assertEquals(5, count);
    }

    @Test
    public void delete(){
        IntStream.rangeClosed(1, 5).forEach(id ->{
                    Optional<OfficerJpa> officer = officerDaoImplJpa.findById(id);
                    assertTrue(officer.isPresent());
                    officerDaoImplJpa.delete(officer.get());
                }
        );
        assertEquals(0, officerDaoImplJpa.count());
    }

    @Test
    public void findAll(){
        List<OfficerJpa> all = (List) officerDaoImplJpa.findAll();
        assertEquals(5, all.stream().count());
    }

}
