package com.example.persistence.entities;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "officers")
public class OfficerJpa {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, name = "first_name")
    private String first;

    @Column(nullable = false, name = "last_name")
    private String last;

    @Column(nullable = false, name = "rank")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    public OfficerJpa() {
        super();
    }

    public OfficerJpa(String first, String last, Rank rank) {
        this.first = first;
        this.last = last;
        this.rank = rank;
    }

    public OfficerJpa(Integer id, String first, String last, Rank rank) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficerJpa officer = (OfficerJpa) o;
        return id.equals(officer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
