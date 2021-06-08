package com.example.persistence.dao;

import com.example.persistence.entities.Officer;
import com.example.persistence.entities.Rank;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Officer> {

    @Override
    public Officer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Officer(rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                Rank.valueOf(rs.getString("rank")));
    }
}
