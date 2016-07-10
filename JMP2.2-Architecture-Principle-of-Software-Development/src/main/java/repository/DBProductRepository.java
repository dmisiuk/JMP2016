package repository;

import model.Product;

import java.util.Collections;
import java.util.List;

/**
 * @author Dzmitry Misiuk
 */
public class DBProductRepository {

    public Product saveProduct(Product product){
        // saving product to db
        return product;
    }

    public List<Product> getProducts(){
        // getting products from db;
        return Collections.emptyList();
    }
}
