package Model.User;

public class Guest implements User_Abstract{

    private int id;
    private String name;

    @Override
    public int getId(){
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
