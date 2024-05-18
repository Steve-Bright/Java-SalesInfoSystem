package Controller;

import Model.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Orders_Controller implements Orders_Controller_Interface{
    String filePath = "src/Model/orders.csv";
    @Override
    public void addOrder(Order order, ArrayList<Order> orders) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
        String orderId = order.getOrderId();
        String productName = order.getOrderProduct().getName();
        int productPrice = order.getOrderProduct().getPrice();
        int qty = order.getQty();
        int orderTotal = order.getTotal();

        bw.newLine();
        bw.write(orderId + "," + productName + "," + productPrice+","+qty+","+orderTotal);

        bw.close();
    }

    @Override
    public void viewAnOrder(Order order){
        System.out.println("Recepit Details");
        System.out.println("====================");
        System.out.println("Order Id: "+ order.getOrderId());
        System.out.println("Bought Product "+ order.getOrderProduct().getName());
        System.out.println("Quantity: "+ order.getQty());
        System.out.println("Total Price"+ order.getTotal());
    }
    @Override
    public void viewOrders(ArrayList<Order> orders) {

    }


}
