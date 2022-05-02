package game.control;

import game.Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class HighScoreManager {
private ArrayList<person> people=new ArrayList<>();
    File file=new File(HighScoreManager.class.getResource(".").getFile()+"scores.txt");
FileOutputStream fos;
FileInputStream fis;
ObjectOutputStream oos;
ObjectInputStream ois;
    public void scoreBord(person p){

        try{
            file.createNewFile();

                fis=new FileInputStream(file);
                if(file.length()!=0){
                    ois=new ObjectInputStream(fis);
                    people=(ArrayList<person>) ois.readObject();
                    ois.close();
                }
                file.createNewFile();
                people.add(p);
                people.sort(person::compareTo);
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
                oos.writeObject(people);
                oos.close();

        }catch (Exception e){e.printStackTrace();}
    }
    public void showScores(){
        try{
            fis=new FileInputStream(file);
            ois=new ObjectInputStream(fis);
            people=(ArrayList<person>) ois.readObject();

            System.out.println(" -----------------------------------------------------------------------");
            System.out.println("|    NAME     |  SCENARIO  |         TIME         |     DIFFICULTY     |");
            System.out.println(" -----------------------------------------------------------------------");

            for(int i=0;i<people.size();i++){
                System.out.println(" -----------------------------------------------------------------------");
                System.out.printf("    %s     &     %s      &     %s     &      %s ",people.get(i).userName,people.get(i).scenarioNum,people.get(i).standardTime,people.get(i).difficulty);
                System.out.println();
                System.out.println(" -----------------------------------------------------------------------");
            }
        }catch (Exception e){e.printStackTrace();}
    }

}
