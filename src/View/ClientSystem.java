package View;

import  Model.User.AllUsersRepo;
import Model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientSystem implements ClientSystem_Interface{
    @Override
    public boolean validateUser(){
        AllUsersRepo usersPool = new AllUsersRepo();
        usersPool.loadData();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the username: ");
        String username = sc.nextLine();
        System.out.print("Enter the password: ");
        String password = sc.nextLine();

        for(int i = 0; i < usersPool.getUsers().size(); i++){
            String userAccName = usersPool.getUsers().get(i).getName();
            String userAccPassword = usersPool.getUsers().get(i).getPassword();
            if(username.equals(userAccName) && password.equals(userAccPassword)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void showAvailableProducts(ArrayList<Product> products){

    }
}
