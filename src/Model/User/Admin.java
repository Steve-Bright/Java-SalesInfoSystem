package Model.User;

public class Admin implements User_Abstract{
    private String id;
    private String name;
    private String password;

    Admin(String id, String name, String password){
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
