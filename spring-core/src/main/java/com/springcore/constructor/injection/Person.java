package com.springcore.constructor.injection;

import java.util.List;

public class Person {
    private int personId;
    private String personName;
    private Certification certification;
    private List<String> personPhones;

    public Person(int personId, String personName, Certification certification) {
        this.personId = personId;
        this.personName = personName;
        this.certification = certification;
        this.personPhones = personPhones;
    }

    public Person(int personId, String personName, Certification certification, List<String> personPhones) {
        this.personId = personId;
        this.personName = personName;
        this.certification = certification;
        this.personPhones = personPhones;
    }


    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", certification=" + certification +
                ", personPhones=" + personPhones +
                '}';
    }
}
