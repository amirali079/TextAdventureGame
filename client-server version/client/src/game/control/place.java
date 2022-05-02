package game.control;
import java.util.ArrayList;


public class place extends object {

    public ArrayList<object> obj=new ArrayList<>();
    String namePlace;

    public place(String namePlace){
        this.namePlace=namePlace;
    }
}