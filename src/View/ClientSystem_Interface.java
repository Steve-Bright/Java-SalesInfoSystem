package View;

import Model.Product;

import java.util.ArrayList;

interface ClientSystem_Interface {
    boolean validateUser();
    void showAvailableProducts(ArrayList<Product> products);

    int displayOptions();

    void viewItemOption(ArrayList<Product> products);
}
