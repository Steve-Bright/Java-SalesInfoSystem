package Controller;

import Model.Product;
import Model.AllProductsRepo;

import java.io.IOException;
import java.util.ArrayList;

interface Products_Controller_Interface {
    void viewProducts(ArrayList<Product> products);
    void addProduct(Product product, ArrayList<Product> products) throws IOException;

    void editProduct(String productId, ArrayList<Product> products) throws IOException;
    void deleteProduct(String productId, ArrayList<Product> products) throws IOException;

    void updateStock(int stock, Product product, ArrayList<Product> products) throws IOException;
}
