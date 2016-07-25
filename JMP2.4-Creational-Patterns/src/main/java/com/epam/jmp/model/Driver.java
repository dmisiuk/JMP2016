package com.epam.jmp.model;

/**
 * Created by Dzmitry_Misiuk on 7/25/2016.
 */
public class Driver extends Employee {

    private int experience;

    public Driver() {
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Driver driver = (Driver) o;

        return experience == driver.experience;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + experience;
        return result;
    }
}
