package Model.User;

public class Guest implements User_Abstract{

    private String id;
    private String name;

    @Override
    public String getId(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setId(){
//        nothing done here yet.
    }
}
