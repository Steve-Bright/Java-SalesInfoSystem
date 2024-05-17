package Controller;

import Model.Product;
import Model.AllProductsRepo;

import java.io.IOException;
import java.util.ArrayList;

interface Products_Controller_Interface {
    void viewProducts(ArrayList<Product> products);
    void addProduct(Product product) throws IOException;
    void deleteProduct(Product product);
}
