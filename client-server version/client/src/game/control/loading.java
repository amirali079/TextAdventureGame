package game.control;

import game.gamePanel.gamePanel;
import game.scenario.scenario_1;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

class MyTimerTask extends TimerTask {

    private String str;

    public MyTimerTask(String str) {
        this.str = str;
    }

    public void run() {
        String words[] = str.split(" ");
        System.out.print(ConsoleColors.RED_BOLD);
        System.out.print(str);
        System.out.print(ConsoleColors.RESET);
        //System.out.print("number of words: " + words.length);
    }
}

public class loading {
    public static void loading() {

        System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT);

        System.out.println("\n" +
                " ooooooooo.   ooooooooo.   ooooo  .oooooo..o   .oooooo.    ooooo      ooo      oooooooooo.  ooooooooo.   oooooooooooo       .o.       oooo    oooo \n" +
                "`888   `Y88. `888   `Y88. `888' d8P'    `Y8  d8P'   `Y8b   `888b.     `8'      `888'   `Y8b `888   `Y88. `888'     `8      .888.      `888   .8P'  \n" +
                " 888   .d88'  888   .d88'  888  Y88bo.      888       888   8 `88b.    8        888     888  888   .d88'  888             .8\"888.      888  d8'    \n" +
                " 888ooo88P'   888ooo88P'   888   `Y8888o.  888         888  8   `88b.  8        888oooo888'  888ooo88P'   888oooo8       .8' `888.     88888[      \n" +
                " 888          888`88b.     888       `Y88b 888         888  8     `88b.8        888    `88b  888`88b.     888    \"      .88ooo8888.    888`88b.    \n" +
                " 888          888  `88b.   888  oo     .d8P `88b      d88'  8       `888        888    .88P  888  `88b.   888       o  .8'     `888.   888  `88b.  \n" +
                "o888o        o888o  o888o o888o 888888888P'   `Y8bood8P'   o8o        `8       o888bood8P'  o888o  o888o o888ooooood8 o88o     o8888o o888o  o888o \n" +
                "                                                                                                                                                 \n" +
                "                                                                                                                                                 \n" +
                "                                                                                                                                                 \n");



        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT);
        System.out.println("\n" +
                "          ooooo          .oooooo.         .o.       oooooooooo.   ooooo ooooo      ooo   .oooooo.    \n" +
                "          `888'         d8P'  `Y8b       .888.      `888'   `Y8b  `888' `888b.     `8'  d8P'  `Y8b   \n" +
                "           888         888      888     .8\"888.      888      888  888   8 `88b.    8  888           \n" +
                "           888         888      888    .8' `888.     888      888  888   8   `88b.  8  888           \n" +
                "           888         888      888   .88ooo8888.    888      888  888   8     `88b.8  888     ooooo \n" +
                "           888       o `88b    d88'  .8'     `888.   888     d88'  888   8       `888  `88.    .88'  \n" +
                "          o888ooooood8  `Y8bood8P'  o88o     o8888o o888bood8P'   o888o o8o        `8   `Y8bood8P'   \n" +
                "                                                                                                     \n" +
                "                                                                                                     \n");

        System.out.print(ConsoleColors.RESET);

        char[] lo = new char[1];
        lo[0]= '#';

        String str1="";
        String str = new String(lo) ;
        Timer timer = new Timer();
        System.out.print("             ");
        timer.schedule(new MyTimerTask(str), 300, 60);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}
        timer.cancel();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {}
        timer.cancel();
        System.out.println(ConsoleColors.BLUE_BOLD);
        System.out.println("                                                    100%");
        System.out.println(ConsoleColors.RESET);
        System.out.println("\n\n\n");


        JFrame frame=new gamePanel();
        while (frame.isActive());

        scenario_1 sa=new scenario_1();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {}
        timer.cancel();

        System.out.println();
        System.out.println(ConsoleColors.CYAN_UNDERLINED);
        System.out.println("محمود که به جرم اختلاص حبس ابد خورده است عزم خود جزم کرده است تا از زندان فرار کند.");
        System.out.print(ConsoleColors.RESET);
        sa.help("شما باید به او کمک کنید تا موفق شود."+"در ابتدای کار او باید راهی برای فرار پیدا کند.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {}
        timer.cancel();


    }
}