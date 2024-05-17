package View;

import Model.User.AllUsersRepo;

import java.util.Scanner;

public class AdminPanel implements AdminPanel_Interface {


    @Override
    public boolean validateAdmin() {
        AllUsersRepo usersPool =  new AllUsersRepo();

        Scanner sc = new Scanner(System.in);
        usersPool.loadData();

        System.out.print("Enter Admin User: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for(int i = 0; i < usersPool.getAdmins().size(); i++){
            String adminName = usersPool.getAdmins().get(i).getName();
            String adminPassword = usersPool.getAdmins().get(i).getPassword();
            if(username.equals(adminName) && password.equals(adminPassword)){
                return true;
            }
        }
        return false;
    }

    public int displayOptions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Admin Panel!");
        System.out.print("1. Add product info" +
                "\n2. View product info" +
                "\n3. Delete product info"+
                "\n4. Exit from Admin"+
                "\nYour Input: ");
        return sc.nextInt();

    }

}
