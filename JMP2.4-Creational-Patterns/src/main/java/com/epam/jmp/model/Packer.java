package com.epam.jmp.model;

/**
 * Created by Dzmitry_Misiuk on 7/25/2016.
 */
public class Packer extends Employee {

    private int level;

    public Packer() {

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Packer packer = (Packer) o;

        return level == packer.level;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + level;
        return result;
    }
}
