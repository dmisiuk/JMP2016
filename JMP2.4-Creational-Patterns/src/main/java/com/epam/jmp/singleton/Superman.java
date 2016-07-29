package com.epam.jmp.singleton;

/**
 * Created by Dzmitry_Misiuk on 7/29/2016.
 */
public class Superman {

    private static volatile Superman instance;

    private Superman() {
    }

    public static Superman getInstance() {
        if (instance == null) {
            synchronized (Superman.class) {
                if (instance == null) {
                    instance = new Superman();
                }
            }
        }
        return instance;
    }
}
