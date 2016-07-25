package com.epam.jmp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzmitry_Misiuk on 7/25/2016.
 */
public class Warehouse {

    private String address;

    private List<Employee> employees;

    public Warehouse() {
        this.employees = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
