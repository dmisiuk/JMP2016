package service;

import model.Cart;
import model.Product;

import java.util.List;

/**
 * @author Dzmitry Misiuk
 */
public interface IProductService {
    List<Product> getProducts();

    Product saveProduct(Product product);

    Cart addToCart(Cart cart, Product product);

    void deliverCart(Cart cart, String address);

    void checkout(Cart cart);
}
