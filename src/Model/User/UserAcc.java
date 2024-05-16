package Model.User;

public class UserAcc implements User_Abstract{
    private String id;
    private String name;

    private String password;
    @Override
    public String getId(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public void setId(){
        //set method not done yet.
    }
}
