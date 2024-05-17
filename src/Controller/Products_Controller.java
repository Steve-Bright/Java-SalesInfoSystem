package Controller;


import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Products_Controller implements Products_Controller_Interface{

    @Override
    public void viewProducts(ArrayList<Product> products){
        System.out.println("Product Detail");
        System.out.printf("----------------------------------------------------------%n");
        System.out.printf("| %-11s | %-25s | %-12s | %n", "Product Id", "Product Name", "Price");
        System.out.printf("----------------------------------------------------------%n");
        for(Product product: products){
            System.out.printf("| %-11s | %-25s | %12s |%n",product.getId(),product.getName(), product.getPrice());
        }
    }

    @Override
    public void addProduct(Product product) throws IOException {
        String filePath = "src/Model/products.csv";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        bw.write("");
    }

    @Override
    public void deleteProduct(Product product){

    }
}
