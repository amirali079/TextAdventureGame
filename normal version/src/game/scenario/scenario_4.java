package game.scenario;
import java.util.Scanner;
import game.control.object;
import game.control.place;
import game.control.ConsoleColors;

public class scenario_4  extends scenario_3 {
    place pocket4 = new place("pocket4");

    @Override
    public void win(){
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("شما پیروز شدید!!!");
        System.out.println("ایا میخواهید به مرحله بعد بروید؟لطفا برای پاسخ مثبت عدد1 و پاسخ منفی عدد 0 را وارد نمیایید!");
        int j = s.nextInt();
        if(j== 0){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.exit(0);}
        if( j == 1){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("\n");

            System.out.println(ConsoleColors.RESET);
            try {
                scenario_5 sa1=new scenario_5();
                sa1.ejra();}
            catch (Exception e){
                System.out.println("شما ورودی نامعتبر وارد کردید و حتی ورودی شما عدد نیز نبود.....");
                System.out.println(" جهت اینکه دیگر حواستان جمع باشد و فرق عدد و کاراکتر را بدانید بازی به طور کل از اول شروع میشود......");
                System.out.println("....باشد که عبرتی قرار گیرد برای آیندگان.......");
                System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
                scenario_1 sa= new scenario_1();
                sa.ejra();
            }


        }
        else{
            System.out.println("لطفا برای پاسخ مثبت عدد1 و پاسخ منفی عدد 0 را وارد نمیایید!");win();
        }

    }

    @Override
    public void bazgasht(){
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("به کجا میخواهید بروید؟");
        System.out.println("1.سلول خود");
        System.out.println("2.حمام زندان");
        System.out.println("3.تاسیسات زندان");
        System.out.println("4.آشپزخانه");
        System.out.println("5.حیاط زندان");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(ConsoleColors.RESET);
        int b = s.nextInt();
        switch (b){
            case 1 : startcell();
            case 2 : starthamam();
            case 3 : startanbar();
            case 4 : startkitchen();
            case 5 : startyard();
            default:
                System.out.println("عدد وارد شده معتبر نمیباشد.");
                bazgasht();
        }
    }

    @Override
    public void ejra(){

        System.out.println();
        System.out.println(ConsoleColors.CYAN_BOLD);
        System.out.println("بخش چهارم: جدال با تاریکی ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("پس از پیدا شدن نقشه به نظر میرسید که دیگر مشکلی پیشروی فرار ما نباشد اما وقتی به درون گودال رفتیم تازه مشکل جدیدتر پیدا شد...تاریکی...");
        System.out.println(ConsoleColors.RESET);
        help("مطمعنا وسایل زیادی برای روشنایی وجود دارد ولی  به نظر من وسایل سنتی همیشه بهتر هستن...");

        pocket4.obj.add(new object("چوب"));
        pocket4.obj.add(new object("حوله"));
        pocket4.obj.add(new object("کبریت"));
        pocket4.obj.add(new object("نفت"));
        pocket4.obj.add(new object("اره"));
        pocket4.obj.add(new object("اچار"));


        startcell();

    }



    @Override
    public void startcell(){
        soal("شما در سلول هستید . داخل گودالی که حفر کرده اید تاریک است و نیاز به وسیله روشنایی داریم",
                "داخل جیب نگهبان یک چراغ قوه است آن را برداریم","با هم سلولی خود مشورت کنیم",null);
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : lose("وقتی داشتیم چراغ قوه را بر میداشتیم نگهبان متوجه شد و ما دستگیر شدیم");
            case 2 :
                soal("همسلولی میگوید که اگر بتوانیم وسایل مورد نیاز برای درست کردن مشعل را تهیه کنیم او میتواند یک مشعل درست کند.",
                        "برای تهیه وسایل به سایر مکان های داخل زندان رجوع کنیم","وسایل مورد نیاز را به او بدهیم","به دنبال راه دیگری برویم");
                n = s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1: help("وسایل مورد نیاز برای درست کردن مشعل عبارت اند از یک تکه چوب یک تکه پارچه کبریت و نفت"); bazgasht();
                    case 2 : if(pocket4.obj.get(0).getExist()==true && pocket4.obj.get(1).getExist()==true && pocket4.obj.get(2).getExist()==true && pocket4.obj.get(3).getExist()==true )
                    { System.out.println("همسلولی ابتدا حوله را به دور چوب پیچید سپس نفت را روی آن ریخت و با کبریت آن را آتش زد...حالا مشکل تاریکی حل شد... پیش به سوی فرار");
                        win();
                    }
                    else { System.out.println("وسایل مورد نیاز کامل نمی باشند لطفا هرچهارتا را تهیه نمایید."); startcell(); }
                    case 3 : startcell();
                }
        }

    }

    @Override
    public void startkitchen(){

        soal("اینجا آشپزخانه است. آشپز روبه روی ما ایستاده در کنارش میزی قرار دارد که روی آن مقداری غذا و یک عدد چاقو قرار دارد",
                "چاقو را برداریم","غذا هارا بخوریم","از آشپز کبریت بخواهیم.");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : lose("آشپز دید که ما چاقو را برداشتیم و نگهبان خبر داد");
            case 2 : lose("وقتی غذا را خوردیم آشپز با ملاقه بر سر ما کوبید");
            case 3 : soal("آشپز گفت که کبریت به ما میدهد ولی به شرطی که اجاق گاز او که خراب است را تعمیر کنیم","قبول نکنیم","گاز را تعمیر کنیم",null);
                n = s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : startkitchen();
                    case 2 : if(pocket4.obj.get(5).getExist()== true){
                        pocket4.obj.get(2).setExist(true); System.out.println("اجاق گاز تعمیر شد و کبریت برداشته شد"); startkitchen();
                    }
                    else { System.out.println("شما نیاز به آچار برای تعمیر اجاق گاز دارید");  startkitchen();}
                }
        }
    }

    @Override
    public void startyard() {
        soal("شما در حیاط زندان هستید...در حیاط یک درخت تنومند قرار دارد و زیر آن یک باغچه کوچک است.در ضمن دیوار زندان نیز که به خیابان جلوی زندان راه دارد نیز دیده میشود.",
                "از دیوار زندان بالا رفته و فرار کنیم.", "نزدیک درخت رفته و از میوه های آن بخوریم", "یکی از شاخه های درخت را ببریم");
        int n = s.nextInt();
        switch (n) {
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0: bazgasht();
            case 1: lose("وقتی داشتید از دیوار زندان بالا میرفتید نگهبانان شما را دیدند و به طرف شما تیرشلیک کرده و شما را کتند");
            case 2: lose("متاسفانه به میوه های درخت سم زده بودند و شما مسموم شدید ");
            case 3: if(pocket4.obj.get(4).getExist()==true){ pocket4.obj.get(0).setExist(true);
                System.out.println("شما شاخه درخت را بریدید اکنون یک تکه چوب داریم "); startyard();}
            else { System.out.println("شما نیاز به وسیله ای برای بریدن شاخه دارید");startyard(); }
        }
    }

    @Override
    public void startanbar(){

        soal("اینجا تاسیسات زندان است روی زمین یک جعبه ابزار قرار دارد در کنار آن  یک بیل  و یک بشکه نفت وجود دارد ",
                "بیل را برداریم","مقداری نفت برداریم","در جعبه ابزار را باز کنیم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1: System.out.println("فعلا به بیل نیاز نداریم");startanbar();
            case 2: pocket4.obj.get(3).setExist(true);   System.out.println("نفت برداشته شد");  startanbar();
            case 3 : soal("درب جعبه ابزار را باز کردیم در آن یک اره یک پیچ گوشتی و یک آچار قرار دارد","اره","پیچ گوشتی","آچار");
                n = s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : pocket4.obj.get(4).setExist(true); System.out.println("اره برداشته شد");  startanbar();
                    case 2 :  System.out.println("فعلا به پیچ گوشتی نیاز نداریم");startanbar();
                    case 3 :  pocket4.obj.get(5).setExist(true); System.out.println("آچار برداشته شد");  startanbar();
                }
        }
    }

    @Override
    public void starthamam(){
        soal("شما در حمام زندان هستید در سمت چپ کمد مواد شوینده وجود دارد همچنین حوله ای آویزان بوده و دستمال کاغذی نیز روی میز جلوی شما قرار دارد",
                "به سمت کمد مواد شوینده برویم","حوله را برداریم","دستمال کاغذی را برداریم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : System.out.println("درب کمد قفل است");starthamam();
            case 3 : System.out.println("دستمال کاغذی به دردمان نمیخورد");starthamam();
            case 2 :  pocket4.obj.get(1).setExist(true);  System.out.println("حوله برداشته شد!");starthamam();
        }
    }


}