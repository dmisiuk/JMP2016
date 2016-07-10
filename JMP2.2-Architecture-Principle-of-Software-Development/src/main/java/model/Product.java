package model;

/**
 * @author Dzmitry Misiuk
 */
public class Product {
    private int price;
    private String name;
    private int width;
    private int length;
    private int height;

    public Product(int price, String name, int width, int length, int height) {
        this.price = price;
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public boolean isValid() {
        return price > 1 && name != null && !name.trim().isEmpty();
    }

    public void deliver(String address) {
        // some logic to deliver product
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVolume() {
        return width * height * length;
    }
}
