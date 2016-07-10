package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dzmitry Misiuk
 */
public class Cart {

    private List<Product>  products = new ArrayList<Product>();
    private boolean isCheckout;

    public Cart() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCheckout(boolean checkout) {
        this.isCheckout = checkout;
    }
}
