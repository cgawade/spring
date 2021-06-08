package com.example.persistence.dao;

import com.example.persistence.entities.Officer;
import com.example.persistence.entities.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class JdbcOfficerDaoImpl implements OfficerDao{

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertOfficer;

    public JdbcOfficerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertOfficer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("officers")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public Officer save(Officer officer) {
        Map<String,Object> parameter = new HashMap<>();

        parameter.put("first_name", officer.getFirst());
        parameter.put("last_name", officer.getLast());
        parameter.put("rank", officer.getRank());

        Integer newId = (Integer) insertOfficer.executeAndReturnKey(parameter);
        officer.setId(newId);

        return officer;
    }

    public void saveV1(Officer officer) {
        String query = "insert into officers(first_name,last_name, rank) values(?,?,?)";
        jdbcTemplate.update(query, officer.getFirst(), officer.getLast(), officer.getRank());
    }

    @Override
    public Optional<Officer> findById(Integer id) {
        RowMapper<Officer> rowMapper = new RowMapperImpl();
        if(!existsById(id)) return Optional.empty();
        return Optional.of(jdbcTemplate.queryForObject("select * from officers where id=?", rowMapper, id));
    }

    @Override
    public List<Officer> findAll() {
        RowMapper<Officer> rowMapper = new RowMapperImpl();
        return jdbcTemplate.query("select * from officers", rowMapper);
    }

    public List<Officer> findAllV1() {
        return jdbcTemplate.query("select * from officers",
                (rs, rowNum) -> new Officer(rs.getInt("id"), // Java 8 lambda expression
                rs.getString("first_name"),
                rs.getString("last_name"),
                Rank.valueOf(rs.getString("rank"))));
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from officers", Integer.class);
    }

    @Override
    public void delete(Officer officer) {
        jdbcTemplate.update("delete from officers where id =?", officer.getId());
    }

    @Override
    public boolean existsById(Integer id) {
        return jdbcTemplate.queryForObject("select exists(select 1 from officers where id=?)", Boolean.class, id);
    }

}
