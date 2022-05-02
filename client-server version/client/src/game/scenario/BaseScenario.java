package game.scenario;
import game.Main;
import game.control.*;
import game.control.ConsoleColors;
import game.gamePanel.gamePanel;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public  abstract class BaseScenario  {

    static ScenarioHistory<BaseScenario>  history = new ScenarioHistory<>();
    public static int key =1;

    Scanner s=new Scanner(System.in);

    Vazeiat v1 = Vazeiat.continu;

    File f;


    public void bargasht() throws MyExeption {

        if(key > 0 ){
            key--;
            System.out.println("شما به عقب بازگشتید");
            if(this.getID() == 1)
            {
                history.undo().ejra();
            }
            else{
                history.undo();
                history.undo().ejra();}
        }
        System.out.println("شما کلید جادویی ندارید و نمی توانید به عقب برگردید");
        bazgasht();

    }


    public void load()throws MyExeption{

        ObjectMapper mapper=new ObjectMapper();
        ArrayList<scenarioSaver> saves = new ArrayList<>();

        try{f=getFilePath();
            mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

            saves = mapper.readValue(f, new TypeReference<ArrayList<scenarioSaver>>(){});

            System.out.println("لطفا نام کاربری  را وارد کنید.");
            String name = s.next();
            for(int i = 0 ; i < saves.size();i++){
                if(name.equals(saves.get(i).name)) {
                    System.out.println("لطفا رمز خود را وارد کنید.");
                    String ramz = s.next();

                    if(ramz.equals(saves.get(i).ramz)){

                        try{
                            System.out.println("loading");
                            gamePanel.userName=saves.get(i).name;
                            gamePanel.passWord= saves.get(i).ramz;
                            Main.StartTime += saves.get(i).time;
                            int n = saves.get(i).id;


                            switch(n){
                                default:
                                    System.out.println("خطا در بارگذاری لطفا دوباره تلاش کنید!"); load();

                                case 1 : scenario_1 s1 = new scenario_1();
                                    for( int k =0 ; k < saves.get(i).obj.length;k++) {
                                        s1.pocket.obj.get(saves.get(i).obj[k]).setExist(true);
                                    }
                                    s1.ejra();

                                case 2 : scenario_2 s2 = new scenario_2();
                                    for( int k =0 ; k < saves.get(i).obj.length;k++) {
                                        s2.pocket.obj.get(saves.get(i).obj[k]).setExist(true);
                                    }
                                    s2.ejra();

                                case 3 : scenario_3 s3 = new scenario_3();
                                    for( int k =0 ; k < saves.get(i).obj.length;k++) {
                                        s3.pocket.obj.get(saves.get(i).obj[k]).setExist(true);
                                    }
                                    s3.ejra();

                                case 4 : scenario_4 s4 = new scenario_4();
                                    for( int k =0 ; k < saves.get(i).obj.length;k++) {
                                        s4.pocket.obj.get(saves.get(i).obj[k]).setExist(true);
                                    }
                                    s4.ejra();

                                case 5 : scenario_5 s5 = new scenario_5();
                                    for( int k =0 ; k < saves.get(i).obj.length;k++) {
                                        s5.pocket.obj.get(saves.get(i).obj[k]).setExist(true);
                                    }
                                    s5.ejra();

                            }}
                        catch (MyExeption e){

                            System.out.println("*******************************************************************************************************");
                            System.out.println("\n" +
                                    "oooooo   oooo   .oooooo.   ooooo     ooo      ooooo          .oooooo.    .oooooo..o oooooooooooo \n" +
                                    " `888.   .8'   d8P'  `Y8b  `888'     `8'      `888'         d8P'  `Y8b  d8P'    `Y8 `888'     `8 \n" +
                                    "  `888. .8'   888      888  888       8        888         888      888 Y88bo.       888         \n" +
                                    "   `888.8'    888      888  888       8        888         888      888  `\"Y8888o.   888oooo8    \n" +
                                    "    `888'     888      888  888       8        888         888      888      `\"Y88b  888    \"    \n" +
                                    "     888      `88b    d88'  `88.    .8'        888       o `88b    d88' oo     .d8P  888       o \n" +
                                    "    o888o      `Y8bood8P'     `YbodP'         o888ooooood8  `Y8bood8P'  8\"\"88888P'  o888ooooood8 \n" +
                                    "                                                                                                 \n" +
                                    "                                                                                                 \n");
                            System.out.println("********************************************************************************************************");
                            System.exit(0);
                        }
                        return; }

                    else{
                        System.out.println("رمز عبوری شما معتبر نیست"); load();
                    }
                } }
            System.out.println("نام کاربری شما معتبر نمی باشد!");
        }catch(IOException e ){ e.printStackTrace();}
        bazgasht();

           /* Scanner fr  = new Scanner(f);
            System.out.println("لطفا نام کاربری  را وارد کنید.");
            String name = s.next();
            while(fr.hasNext()){
                String name1 = fr.next();

                if(name.equals(name1)) {
                    System.out.println("لطفا رمز خود را وارد کنید.");
                    String ramz = s.next();
                    String ramz1 = fr.next();
                    if(ramz.equals(ramz1)){


                        try{
                            System.out.println("loading");
                            int n = fr.nextInt();
                            switch(n){
                                default:
                                    System.out.println("خطا در بارگذاری لطفا دوباره تلاش کنید!"); load();

                                case 1 : scenario_1 s1 = new scenario_1();
                                    while(fr.hasNextInt()){
                                        int k = fr.nextInt();
                                        s1.pocket.obj.get(k).setExist(true);
                                    }
                                    fr.reset();
                                    s1.ejra();

                                case 2 : scenario_2 s2 = new scenario_2();
                                    while(fr.hasNextInt()){
                                        int k = fr.nextInt();
                                        s2.pocket.obj.get(k).setExist(true);
                                    }
                                    fr.reset();
                                    s2.ejra();

                                case 3 : scenario_3 s3 = new scenario_3();
                                    while(fr.hasNextInt()){
                                        int k = fr.nextInt();
                                        s3.pocket.obj.get(k).setExist(true);
                                    }
                                    fr.reset();
                                    s3.ejra();

                                case 4 : scenario_4 s4 = new scenario_4();
                                    while(fr.hasNextInt()){
                                        int k = fr.nextInt();
                                        s4.pocket.obj.get(k).setExist(true);
                                    }
                                    fr.reset();
                                    s4.ejra();

                                case 5 : scenario_5 s5 = new scenario_5();
                                    while(fr.hasNextInt()){
                                        int k = fr.nextInt();
                                        s5.pocket.obj.get(k).setExist(true);
                                    }
                                    fr.reset();
                                    s5.ejra();

                            }}
                        catch (MyExeption e){

                            System.out.println("*******************************************************************************************************");
                            System.out.println("\n" +
                                    "oooooo   oooo   .oooooo.   ooooo     ooo      ooooo          .oooooo.    .oooooo..o oooooooooooo \n" +
                                    " `888.   .8'   d8P'  `Y8b  `888'     `8'      `888'         d8P'  `Y8b  d8P'    `Y8 `888'     `8 \n" +
                                    "  `888. .8'   888      888  888       8        888         888      888 Y88bo.       888         \n" +
                                    "   `888.8'    888      888  888       8        888         888      888  `\"Y8888o.   888oooo8    \n" +
                                    "    `888'     888      888  888       8        888         888      888      `\"Y88b  888    \"    \n" +
                                    "     888      `88b    d88'  `88.    .8'        888       o `88b    d88' oo     .d8P  888       o \n" +
                                    "    o888o      `Y8bood8P'     `YbodP'         o888ooooood8  `Y8bood8P'  8\"\"88888P'  o888ooooood8 \n" +
                                    "                                                                                                 \n" +
                                    "                                                                                                 \n");
                            System.out.println("********************************************************************************************************");
                            System.exit(0);
                        }
                        return; }

                    else{
                        System.out.println("رمز عبوری شما معتبر نیست"); load();
                    }
                } }
            System.out.println("نام کاربری شما معتبر نمی باشد!");
        }catch(IOException e ){}
        bazgasht();*/

    }



    public void save (int id,place pocket) throws MyExeption{


        f = getFilePath();
        ObjectMapper mapper=new ObjectMapper();


        ArrayList<scenarioSaver> saves = new ArrayList<>();
        ArrayList<scenarioSaver> saver = new ArrayList<>();

        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            f.createNewFile();
            saves = mapper.readValue(f, new TypeReference<ArrayList<scenarioSaver>>(){});


        } catch (IOException e) {
           // e.printStackTrace();
        }

        for(int i = 0 ; i < saves.size(); i++)
            saver.add(saves.get(i));

        String name = gamePanel.userName;

        String ramz = gamePanel.passWord;

        long time = System.currentTimeMillis();
        int[] obj = new int[pocket.obj.size()];
        int j =0;
        for(int i =0 ; i< pocket.obj.size() ; i++)
        { if(pocket.obj.get(i).getExist()== true ){ obj[j]=i; j++;}}

        saver.add( new scenarioSaver(name,ramz,id,obj,time- Main.StartTime));

        try {
            mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
            mapper.writeValue(f,saver);
            System.out.println("بازی شما با موقیت ذخیره شد!");

            /* FileWriter fw = new FileWriter(f,true);
            fw.write(name+" "+ramz+"\r\n"+id+"\r\n");
            fw.flush();
            for(int i =0 ; i< pocket.obj.size() ; i++)
            {
                if(pocket.obj.get(i).getExist()== true )
                { fw.write(i+"\r\n"); fw.flush();
                }
            }
            fw.close(); */


        }catch(IOException e){

            e.printStackTrace();
        }


        bazgasht();
    }



    public void help(String h){
        System.out.println(ConsoleColors.GREEN_BOLD);
        System.out.println("***********************************************************************************");
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT);
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+"راهنمایی:");
        System.out.println(h);
        System.out.println(ConsoleColors.GREEN_BOLD);
        System.out.println("***********************************************************************************");
        System.out.println(ConsoleColors.RESET);
    }


    public void soal(String dec,String s1,String s2,String s3){
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println(ConsoleColors.BLACK_BOLD);
        System.out.println(dec);
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println("----------------------------------------------------------------");
        if(s1!=null){
            System.out.println(ConsoleColors.RED_BOLD+"1."+ConsoleColors.BLACK_BOLD+s1);
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
            System.out.println("----------------------------------------------------------------");}
        if(s2!=null){
            System.out.println(ConsoleColors.RED_BOLD+"2."+ConsoleColors.BLACK_BOLD+s2);
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
            System.out.println("----------------------------------------------------------------");}
        if(s3!=null){
            System.out.println(ConsoleColors.RED_BOLD+"3."+ConsoleColors.BLACK_BOLD+s3);
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
            System.out.println("----------------------------------------------------------------");}
        System.out.println(ConsoleColors.RED_BOLD+"0."+ConsoleColors.BLACK_BOLD+"رفتن به سایر مکان های زندان");
        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println("___________________________________________________________________________________________________");
        System.out.println(ConsoleColors.RESET);
    }


    public void lose(String l) throws MyExeption {
        v1= Vazeiat.lose;
        System.out.println(ConsoleColors.RED_BOLD);
        System.out.println(l);
        System.out.println();


        long EndTime=System.currentTimeMillis();
        HighScoreManager highS=new HighScoreManager();
        highS.scoreBord(new person(gamePanel.userName,this.getID(), (int) (EndTime-Main.StartTime),gamePanel.difficulty,false));
        highS.showScores();


        System.out.println("مسیری که تا کنون پیموده اید:");
        for(int i = 0 ; i <= history.getSizeHistory()+1 ; i++)
            System.out.println(" --> scenario_"+history.undo().getID() + " ");

        throw new MyExeption();
    }


    public abstract void ejra () throws MyExeption;

    public abstract void win() throws MyExeption;

    public abstract void bazgasht() throws MyExeption;


    public abstract int getID();

    public static File getFilePath(){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showDialog(null,"Slect file path");
        if(result==JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile();
        else return null;
    }

}
