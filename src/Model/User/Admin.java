package Model.User;

public class Admin implements User_Abstract{
    private int id;
    private String name;
    private String password;

    Admin(int id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Override
    public int getId(){
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

    }

}
