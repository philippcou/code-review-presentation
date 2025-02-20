package at.aschauer.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// -----------------------------------------------
// DatabaseConnection: Legacy singleton
// -----------------------------------------------
public class DatabaseConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USER = "root";
    private static final String PASS = "password123";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    public void saveProduct(Product product) {
        // Upsert logic: remove old, then insert new
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("DELETE FROM PRODUCTS WHERE ID=" + product.getId());
            st.executeUpdate(
                    "INSERT INTO PRODUCTS (ID, NAME, PRICE, STOCK) VALUES ("
                            + product.getId() + ",'" + product.getName() + "',"
                            + product.getPrice() + "," + product.getStock() + ")");
        } catch (SQLException e) {
            // TODO: Log this
            e.printStackTrace();
        }
    }

    public Product fetchProductById(int productId) {
        Product product = null;
        try (Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM PRODUCTS WHERE ID=" + productId)) {
            if (rs.next()) {
                product = new Product(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getDouble("PRICE"),
                        rs.getInt("STOCK"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> fetchAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Statement st = connection.createStatement();
                // We should not be using SQL here, Jquery is easier
                ResultSet rs = st.executeQuery("SELECT * FROM PRODUCTS")) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getDouble("PRICE"),
                        rs.getInt("STOCK")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}