package Challenge;

public class Mountain extends Point {
    private String name;

    public Mountain( String name,String location){
        super(location);
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name + " Nation Mountain";
    }


}
