package com.springcore.auto.wire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {

    @Autowired
    @Qualifier("address2")
    private Address address;

    public Employee(){
        super();
    }

    //@Autowired
    public Employee(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    //@Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                '}';
    }
}
