package com.example.persistence.dao;

import com.example.persistence.entities.Officer;
import com.example.persistence.entities.Rank;
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
public class JdbcOfficerDaoImplTest {

    @Autowired
    private JdbcOfficerDaoImpl jdbcOfficerDao;


    @Test
    public void save(){
        Officer officer = jdbcOfficerDao.save(new Officer("Shekhar", "Gawade", Rank.ADMIRAL));
        System.out.println("New Id: "+officer.getId());
        assertNotNull(officer.getId());
    }

    @Test
    public void delete(){
        IntStream.rangeClosed(1, 5).forEach(id ->{
                    Optional<Officer> officer = jdbcOfficerDao.findById(id);
                    assertTrue(officer.isPresent());
                    jdbcOfficerDao.delete(officer.get());
                }
        );
        assertEquals(0, jdbcOfficerDao.count());
    }

    @Test
    public void findById(){
        Optional<Officer> byId = jdbcOfficerDao.findById(1);
        assertEquals(1, byId.get().getId());
    }

    @Test
    public void findAll(){
        List<Officer> all = jdbcOfficerDao.findAll();
        assertEquals(5, all.stream().count());
    }

    @Test
    public void count(){
        long count = jdbcOfficerDao.count();
        assertEquals(5, count);
    }

}
