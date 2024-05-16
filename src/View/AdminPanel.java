package View;

import Model.User.Admin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdminPanel implements AdminPanel_Interface {

    @Override
    public int validateAdmin() {


        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Admin User: ");
        String username = sc.nextLine();
        System.out.print("Enter password");
        String password = sc.nextLine();

        try{
            FileReader fr = new FileReader("src/Model/User/users.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                ArrayList<String> admins = new ArrayList<String>();
                admins = (ArrayList<String>) Arrays.asList(line.split(","));

                if (admins.get(0).equalsIgnoreCase(username) && admins.get(1).equals(password)){
                    return 1;
                }
            }
            return 0;
        }catch(IOException e){
            System.out.println("users.csv not working");
            return -1;
        }
    }
}
