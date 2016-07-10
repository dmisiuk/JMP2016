package repository;

import model.Product;

import java.util.Collections;
import java.util.List;

/**
 * @author Dzmitry Misiuk
 */
public class FileProductRepository {

    public Product saveProduct(Product product){
        // saving product to file
        return product;
    }

    public List<Product> getProducts(){
        // getting products from file;
        return Collections.emptyList();
    }
}
