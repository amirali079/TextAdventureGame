package game;
import game.control.ConsoleColors;
import game.scenario.scenario_1;
import game.control.loading;


public class Main {
    public static void main(String[] args) {

        try{
            loading.loading();
            scenario_1 sa=new scenario_1();
            sa.ejra();}
        catch (Exception e){
            System.out.println(ConsoleColors.RED_UNDERLINED+ConsoleColors.posht+"ali"+ConsoleColors.RED_BOLD_BRIGHT+"gjhjh");
            System.out.println("شما ورودی نامعتبر وارد کردید و حتی ورودی شما عدد نیز نبود.....");
            System.out.println(" جهت اینکه دیگر حواستان جمع باشد و فرق عدد و کاراکتر را بدانید بازی به طور کل از اول شروع میشود......");
            System.out.println("....باشد که عبرتی قرار گیرد برای آیندگان.......");
            System.out.print("\n\n");
            scenario_1 sa= new scenario_1();
            sa.ejra();
        }

    }
}