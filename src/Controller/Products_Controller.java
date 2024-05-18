package Controller;


import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Products_Controller implements Products_Controller_Interface{
    String filePath = "src/Model/products.csv";
    @Override
    public void viewProducts(ArrayList<Product> products){
        System.out.println("Product Detail");
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-11s | %-25s | %-12s | %12s| %6s| %n", "Product Id", "Product Name", "Price", "IsAvailable", "Stock");
        System.out.printf("-----------------------------------------------------------------------------------%n");
        for(Product product: products){
            System.out.printf("| %-11s | %-25s | %-12s | %-12s| %-6s| %n",product.getId(),product.getName(), product.getPrice(), product.isAvailable(), product.getStock());
        }
    }

    @Override
    public void addProduct(Product product, ArrayList<Product> products) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
        String productId = product.getId();
        String productName = product.getName();
        int productPrice = product.getPrice();
        boolean isAvailable = product.isAvailable();
        int stock = product.getStock();
        bw.newLine();
        bw.write(productId+ ","+ productName +","+productPrice + ","+isAvailable+","+stock);

        bw.close();
    }

    @Override
    public void editProduct(String productId, ArrayList<Product> products) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean idFound = false;
        for(Product eachProduct: products){
            if(eachProduct.getId().equalsIgnoreCase(productId)){
                System.out.println("Press Enter to skip or save the value you want to edit. ");

                System.out.print("Product Id: " + eachProduct.getId() + " : ");
                String newProductId = sc.nextLine();
                if(!newProductId.isEmpty()){
                    eachProduct.setId(newProductId);
                }

                System.out.print("Product Name: " + eachProduct.getName() + " : ");
                String newProductName = sc.nextLine();
                if(!newProductName.isEmpty()){
                    eachProduct.setName(newProductName);
                }

                System.out.print("Product Price: " + eachProduct.getPrice()  + " : ");
                String newProductPrice = sc.nextLine();
                if(!newProductPrice.isEmpty()){
                    eachProduct.setPrice(Integer.parseInt(newProductPrice));
                }

                System.out.print("Product Availablity: " + eachProduct.isAvailable() + " : ");
                String available = sc.nextLine();
                if(!available.isEmpty()){
                    eachProduct.setAvailability(Boolean.parseBoolean(available));
                }

                System.out.print("Product Stock: " + eachProduct.getStock()  + " : ");
                String newStock = sc.nextLine();
                if(!newStock.isEmpty()){
                    eachProduct.setStock(Integer.parseInt(newStock));
                }

                reloadProducts(products);
                System.out.println("Item Edited! ");
                idFound = true;
                break;
            }
        }
        if(!idFound){
            System.out.println("Id not found!");
        }
    }

    @Override
    public void deleteProduct(String productId, ArrayList<Product> products) throws IOException {
        boolean idFound = false;
        for(Product eachProduct: products){
            if(eachProduct.getId().equalsIgnoreCase(productId)){
                products.remove(eachProduct);
                reloadProducts(products);
                System.out.println("Product Deleted! ");
                idFound = true;
                break;
            }
        }
        if(!idFound){
            System.out.println("Id not found!");
        }


    }

    @Override
    public void updateStock(int stock, Product product, ArrayList<Product> products) throws IOException {
        for(Product eachProduct : products){
            if(eachProduct.getId().equals(product.getId())) {
                int remaining = eachProduct.getStock() - stock;
                if(remaining == 0){
                    eachProduct.setAvailability(false);
                }
                eachProduct.setStock(remaining);
                break;
            }
        }
        reloadProducts(products);
    }
    private void reloadProducts(ArrayList<Product> products) throws IOException {
        String filePath = "src/Model/products.csv";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write("Name,Item,Price,IsAvailable,Stock");
        bw.newLine();

        for(Product eachProduct: products){
            bw.write(eachProduct.getId()+","+eachProduct.getName()+","+eachProduct.getPrice()+","+eachProduct.isAvailable()+"," + eachProduct.getStock());
            bw.newLine();
        }
        bw.close();
    }
}
