package model;

/**
 * @author Dzmitry Misiuk
 */
public class CubeProduct extends Product {

    public CubeProduct(int price, String name, int size) {
        super(price, name, size, size, size);
    }
}
