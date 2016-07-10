package service;

import model.Cart;
import model.Product;
import repository.DBProductRepository;
import repository.FileProductRepository;

import java.util.List;

/**
 * @author Dzmitry Misiuk
 */
public class ProductService implements IProductService {

    private DBProductRepository dbProductRepository;
    private FileProductRepository fileProductRepository;

    private boolean isDb;

    private ProductService() {

    }

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

    @Override
    public List<Product> getProducts() {
        if (isDb) {
            return dbProductRepository.getProducts();
        } else {
            return fileProductRepository.getProducts();
        }
    }

    @Override
    public Product saveProduct(Product product) {
        if (isDb) {
            return dbProductRepository.saveProduct(product);
        } else {
            return fileProductRepository.saveProduct(product);
        }
    }

    @Override
    public Cart addToCart(Cart cart, Product product) {
        cart.getProducts().add(product);
        return cart;
    }

    @Override
    public void deliverCart(Cart cart, String address) {
        for (Product product : cart.getProducts()) {
            product.deliver(address);
        }
    }

    @Override
    public void checkout(Cart cart) {
        cart.setCheckout(true);
    }
}
