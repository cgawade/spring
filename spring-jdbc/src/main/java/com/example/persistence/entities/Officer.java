package com.example.persistence.entities;

import java.util.Objects;

public class Officer {
    private Integer id;
    private String first;
    private String last;
    private Rank rank;

    public Officer(String first, String last, Rank rank) {
        this.first = first;
        this.last = last;
        this.rank = rank;
    }

    public Officer(Integer id, String first, String last, Rank rank) {
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
        Officer officer = (Officer) o;
        return id.equals(officer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
