package com.springcore.constructor.injection;

public class Certification {
    String name;

    public Certification(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "name='" + name + '\'' +
                '}';
    }
}
