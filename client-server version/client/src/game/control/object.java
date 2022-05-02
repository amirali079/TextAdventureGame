package game.control;

public class object {

    public String name;
    private boolean exist;

    public void setExist(boolean exist){
        this.exist=exist;
    }

    public boolean getExist(){
        return exist;
    }

    public object(String name){
        this.name=name;
    }

    public object(){}
}

