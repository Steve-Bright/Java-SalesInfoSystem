package Model.User;

public class UserAcc implements User_Abstract{
    private int id;
    private String name;
    private int password;

    @Override
    public int getId(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    public int getPassword(){
        return password;
    }

    @Override
    public void setId(){
        //set method not done yet.
    }
}
