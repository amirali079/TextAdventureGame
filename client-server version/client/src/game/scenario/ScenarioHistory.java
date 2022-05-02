package game.scenario;

import java.util.ArrayList;

public class ScenarioHistory <T> {

    private  ArrayList<T> history;

    public int getSizeHistory() {
        return history.size();
    }

    private static int i=0;

    public ScenarioHistory() {

        history = new ArrayList<T>();
    }

    public void add(T s){
        history.add(i++,s);
    }

    public T getIDLast(){
        int t = i;
        return history.get(t-1);

    }

    public T undo(){
        T t = history.get(--i);
        history.remove(i);
        return t;

    }
}
