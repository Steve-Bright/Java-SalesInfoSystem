package Controller;

import Model.Order;

import java.io.IOException;
import java.util.ArrayList;

public interface Orders_Controller_Interface {
    void addOrder(Order order, ArrayList<Order> orders) throws IOException;
    void viewOrders(ArrayList<Order> orders);
}
