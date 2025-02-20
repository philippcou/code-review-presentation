package at.aschauer.ecommerce;

import java.util.List;

public class InventoryService {
    private final DatabaseConnection db;

    public InventoryService(DatabaseConnection db) {
        this.db = db;
    }

    public void addProduct(Product product) {
        db.saveProduct(product);
    }

    public Product getProductById(int productId) {
        return db.fetchProductById(productId);
    }

    public void updateStock(int productId, int additionalStock) {
        Product p = getProductById(productId);
        p.setStock(p.getStock() + additionalStock);
        db.saveProduct(p);
    }

    public List<Product> getAllProducts() {
        return db.fetchAllProducts();
    }
}