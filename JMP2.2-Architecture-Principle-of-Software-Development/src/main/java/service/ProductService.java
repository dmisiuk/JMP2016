package service;

import model.Product;
import repository.DBProductRepository;
import repository.FileProductRepository;

import java.util.List;

/**
 * @author Dzmitry Misiuk
 */
public class ProductService {

    private DBProductRepository dbProductRepository;
    private FileProductRepository fileProductRepository;

    private boolean isDb;

    public static ProductService initWithDB() {
        ProductService productService = new ProductService();
        productService.dbProductRepository = new DBProductRepository();
        productService.isDb = true;
        return productService;
    }

    public static ProductService initWithFile() {
        ProductService productService = new ProductService();
        productService.fileProductRepository = new FileProductRepository();
        productService.isDb = false;
        return productService;
    }

    public List<Product> getProducts() {
        if (isDb) {
            return dbProductRepository.getProducts();
        } else {
            return fileProductRepository.getProducts();
        }
    }

    public Product saveProduct(Product product) {
        if (isDb) {
            return dbProductRepository.saveProduct(product);
        } else {
            return fileProductRepository.saveProduct(product);
        }
    }
}
