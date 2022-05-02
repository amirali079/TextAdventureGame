package game.scenario;

import java.io.Serializable;

public class scenarioSaver implements Serializable {

    public String name;
    public String ramz;
    public int id;
    public long time;
    int[] obj ;
    public scenarioSaver(){}
    public scenarioSaver(String name, String ramz, int id, int[] obj,long time) {
        this.name = name;
        this.ramz = ramz;
        this.id = id;
        this.obj = obj;
        this.time = time;
    }
}
