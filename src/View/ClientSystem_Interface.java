package View;

import Model.Order;
import Model.Product;

import java.io.IOException;
import java.util.ArrayList;

interface ClientSystem_Interface {
    boolean validateUser();
    void showAvailableProducts(ArrayList<Product> products);

    int displayOptions();

    void viewItemOption(ArrayList<Product> products, ArrayList<Order> orders) throws IOException;
    void displayOrders(ArrayList<Order> orders);
}
