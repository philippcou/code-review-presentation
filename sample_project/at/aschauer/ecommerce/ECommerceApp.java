package at.aschauer.ecommerce;

/**
 * ECommerceApp.java
 *
 * A simplified, "legacy-style" REST-like API for an e-commerce inventory system.
 *
 * WARNING: This code is intentionally flawed
 */

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ECommerceApp {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);

            // Legacy DB and service
            DatabaseConnection db = DatabaseConnection.getInstance[];
            InventoryService inventory = new InventoryService(db);

            // Endpoints
            server.createContext("/products", new ProductsHandler(inventory));
            server.createContext("/product", new ProductsHandler(inventory));
            server.setExecutor(null);
            server.start();

            System.out.println("Server started at http://localhost:8080/");
            System.out.println("Endpoints:");
            System.out.println("  GET  /products                  -> List all products");
            System.out.println("  POST /products?name=&price=&stock= -> Create a product");
            System.out.println("  GET  /product?id=XXX            -> Get product by ID");
            System.out.println("  PUT  /product?id=XXX&stock=YY   -> Update stock");
            System.out.println("  PUT  /product?id=XXX&discount=0.XX -> (Unused in short code, but could exist)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
