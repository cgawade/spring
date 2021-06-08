package com.springcore.spel;

import jdk.jfr.BooleanFlag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Salary {
    @Value("#{100+90}")
    private int salary;

    @Value("#{50+40}")
    private int baseSalary;

    @Value("#{T(java.lang.Math).sqrt(25)}") // using spring expression call static method
    private int hra;

    @Value("#{8>3}")  // for bollean write such expression which will return boolean result
    private boolean isActive;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getHra() {
        return hra;
    }

    public void setHra(int hra) {
        this.hra = hra;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return "Salary{" +
                "salary=" + salary +
                ", baseSalary=" + baseSalary +
                ", hra=" + hra +
                ", isActive=" + isActive +
                '}';
    }
}
