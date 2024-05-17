package Model.User;

public class UserAcc implements User_Abstract{
    private String id;
    private String name;

    private String password;

    public UserAcc(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
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

}
