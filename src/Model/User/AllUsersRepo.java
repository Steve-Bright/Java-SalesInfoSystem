package Model.User;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AllUsersRepo {

    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<UserAcc> users = new ArrayList<UserAcc>();

    public void loadData(){
        importAdmins();
        importUsers();
    }

    private void importAdmins(){
        try{
            FileReader adminsSrc = new FileReader("src/Model/User/admins.csv");
            BufferedReader adminBr = new BufferedReader(adminsSrc);
            String line;
            while((line = adminBr.readLine()) != null){
                String[] adminsArray = line.split(",");
                admins.add(new Admin(adminsArray[0], adminsArray[1], adminsArray[2]));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Admin file not found");
            System.exit(0);
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }

    private void importUsers(){
        try{
            FileReader usersSrc = new FileReader("src/Model/User/users.csv");
            BufferedReader userBr = new BufferedReader(usersSrc);
            String line;
            while((line = userBr.readLine()) != null){
                String[] usersArray = line.split(",");
                users.add(new UserAcc(usersArray[0], usersArray[1], usersArray[2]));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Users file not found");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }

    public ArrayList<Admin> getAdmins(){
        return admins;
    }
    public ArrayList<UserAcc> getUsers(){
        return users;
    }
}
