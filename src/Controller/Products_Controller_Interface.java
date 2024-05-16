package Controller;

import Model.Product;

interface Products_Controller_Interface {
    void viewProducts();
    void addProduct(Product product);
    void deleteProduct(Product product);
}
