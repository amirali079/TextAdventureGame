package game.control;

import java.io.Serializable;

public class person implements Comparable, Serializable {
    String userName;
    int scenarioNum;
    String standardTime;
    String difficulty;
    int time;
    boolean win=false;
    public person(String userName,int scenarioNum,int time,String diff,boolean win){
        this.userName=userName;
        this.scenarioNum=scenarioNum;
        this.time=time;
        standardTime=String.format("%d : %d : %d", time/3600000,(time%3600000)/60000,((time%3600000)%60000)/1000);
        difficulty=diff;
        this.win=win;

    }

    @Override
    public int compareTo(Object o) {
        if(this.win==true && ((person)o).win==false)
            return -1;
        else if(((person)o).win==true && this.win==false)
            return 1;
            else{
                if(this.scenarioNum<((person)o).scenarioNum)
                    return 1;
                else if(this.scenarioNum>((person)o).scenarioNum)
                    return -1;
                else {
                    if( this.difficulty.equals("Hard")|| ((person)o).difficulty.equals("Easy"))
                    return -1;
                    else if (this.difficulty.equals("Easy")||((person)o).difficulty.equals("Hard"))
                        return 1;
                    else {
                        if(Integer.parseInt(this.standardTime.split(" : ")[0])>Integer.parseInt(((person)o).standardTime.split(" : ")[0]))
                            return 1;
                        else if(Integer.parseInt(this.standardTime.split(" : ")[0])<Integer.parseInt(((person)o).standardTime.split(" : ")[0]))
                            return -1;
                        else {
                            if(Integer.parseInt(this.standardTime.split(" : ")[1])>Integer.parseInt(((person)o).standardTime.split(" : ")[1]))
                                return 1;
                            else if(Integer.parseInt(this.standardTime.split(" : ")[1])<Integer.parseInt(((person)o).standardTime.split(" : ")[1]))
                                return -1;
                            else {
                                if(Integer.parseInt(this.standardTime.split(" : ")[2])>Integer.parseInt(((person)o).standardTime.split(" : ")[2]))
                                    return 1;
                                else
                                    return -1;
                            }
                        }
                    }
                }
            }
        }
    }