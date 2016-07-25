package com.epam.jmp.model;

/**
 * Created by Dzmitry_Misiuk on 7/25/2016.
 */
public class Shop {

    private Warehouse warehouse;

    public Shop() {
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
