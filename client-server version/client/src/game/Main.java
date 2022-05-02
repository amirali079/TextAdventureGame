package game;
import game.control.*;
import game.scenario.*;
import game.scenario.scenario_1;

import java.io.*;
import java.net.Socket;


public class Main {
    public static long StartTime=System.currentTimeMillis();
    public static void main(String[] args) {

        try{

            socket=new Socket("127.0.0.1",6666);
           loading.loading();
            scenario_1 sa=new scenario_1();
            //games g=new games();
            //g.duzzz();
            sa.ejra();}



    catch (MyExeption e){

        System.out.println(ConsoleColors.RED_BOLD);
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
    catch(Exception y){ y.printStackTrace();}
}


    static Socket socket;
    static ObjectInputStream input;
    static ObjectOutputStream output;

    public static void sender(Object o){

        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object reciver(){
        Object o = new Object();
        try {
            input = new ObjectInputStream(socket.getInputStream());
            o = input.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

}