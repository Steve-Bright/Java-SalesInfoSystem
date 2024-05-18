package Controller;

import Model.Order;

import java.io.IOException;
import java.util.ArrayList;

interface Orders_Controller_Interface {
    void addOrder(Order order, ArrayList<Order> orders) throws IOException;
    void viewAnOrder(Order order);
    void viewOrders(ArrayList<Order> orders);
}
