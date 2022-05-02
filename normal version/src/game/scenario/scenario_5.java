package game.scenario;
import game.control.games;
import game.control.object;
import game.control.place;
import game.control.ConsoleColors;

public class scenario_5 extends scenario_4 {
    place pocket5 = new place("pocket5");

    @Override
    public void win(){
        System.out.println(ConsoleColors.CYAN_BOLD);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("\n" +
                "oooooo   oooo   .oooooo.   ooooo     ooo      oooooo   oooooo     oooo ooooo ooooo      ooo \n" +
                " `888.   .8'   d8P'  `Y8b  `888'     `8'       `888.    `888.     .8'  `888' `888b.     `8' \n" +
                "  `888. .8'   888      888  888       8         `888.   .8888.   .8'    888   8 `88b.    8  \n" +
                "   `888.8'    888      888  888       8          `888  .8'`888. .8'     888   8   `88b.  8  \n" +
                "    `888'     888      888  888       8           `888.8'  `888.8'      888   8     `88b.8  \n" +
                "     888      `88b    d88'  `88.    .8'            `888'    `888'       888   8       `888  \n" +
                "    o888o      `Y8bood8P'     `YbodP'               `8'      `8'       o888o o8o        `8  \n" +
                "                                                                                            \n" +
                "                                                                                            \n" +
                "                                                                                            \n");

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        System.out.println("وقتی بالاخره با آن همه سختی و مشقت توانستیم گودالی در سلول خود حفر کنیم" );
        System.out.println( "  و داشتیم از طریق لوله های شبکه آب از زندان فرار میکردیم" );
        System.out.println(  " ...اون لحظه ای که دیگر به آخر مسیر لوله ها رسیدیم که از زندان هم خارج شده بودیم" );
        System.out.println( " آنجا شبکه فاضلاب شهر بود و یکی از در های چاه ها نیز بالاسر دیده میشد." );
        System.out.println( " با سختی از نردبان کنار دیوار بالا رفتیم و در چاه را باز کردیم..." );
        System.out.println(  "و با صحنه ای غیرقابل باور روبه رو شدیم..." );
        System.out.println( "دور تا دور ما محاصره شده بود...بعد از انتقال مجدد به زندان فهمیدم که " );
        System.out.println(  "کار همان همسلولی ,که اسمش حسن بود, است....او ما را لو داده بود...");
        System.out.println("این است عاقبت اختلاص گران....");
        System.out.println(":)");
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.exit(0);

    }

    @Override
    public void bazgasht(){
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("به کجا میخواهید بروید؟");
        System.out.println("1.سلول خود");
        System.out.println("2.تاسیسات زندان");
        System.out.println("3.حمام زندان");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(ConsoleColors.RESET);
        int b = s.nextInt();
        switch (b){
            case 1 : startcell();
            case 2: startanbar();
            case 3 : starthamam();
            default:
                System.out.println("عدد وارد شده معتبر نمیباشد.");
                bazgasht();
        }
    }

    @Override
    public void ejra(){


        System.out.println();
        System.out.println(ConsoleColors.CYAN_BOLD);
        System.out.println("بخش پنجم: پایان راه");
        System.out.println("----------------------------------------------------------------");
        System.out.println("با در دست داشتن نقشه و مشعل , حفاری را به طور کامل انجام دادیم و به همان شبکه لوله های آب که قرار بود از آنجا فرار کنیم در زیر زندان رسیدبم...");
        System.out.println("جنس لوله ای که میخواهیم از داخل آن فرار کنیم از فولاد آبدیده و ذخامت لایه روکش آن 30 سانتی متر است...");
        System.out.println(ConsoleColors.RESET);
        help("در درس علوم داشتیم ترکیب اسیدسولفوریک و سدیم هیپوکلریت میتواند همه چیز را در خود حل کند...");

        pocket5.obj.add(new object("پیچ گوشتی"));
        pocket5.obj.add(new object("چکش"));
        pocket5.obj.add(new object("کلنگ"));
        pocket5.obj.add(new object("مایع سفیدکننده"));
        pocket5.obj.add(new object("جوهرنمک"));
        pocket5.obj.add(new object("شامپو"));


        startcell();

    }



    @Override
    public  void startcell(){
        soal("شما در سلول خود هستید. گودالی که حفر کرده اید به لوله ای ختم میشود که جنس سختی دارد.همچنین نگهبان جدیدی برای سلول شما قرارداده اند که قبلا مسول حمام زندان بوده.",
                "با کلنگ لوله را سوراخ کنیم","با استفاده از مواد شیمیایی لوله را ذولب کنیم","کلیدی که مال کمد های حمام است را از جیب نگهبان جدید کش برویم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : if(pocket5.obj.get(2).getExist()== true){lose("پس از زدن ضربات متوالی با کلنگ به لوله بالاخره سوراخ کوچکی در آن ایجاد شد. اما به دلیل سروصدای زیاد نگهبان به درون سلول شما آمده و متوجه نقشه شما شده");}
            else { System.out.println("شما نیاز به کلنگ داربد"); startcell(); }
            case 2 : if(pocket5.obj.get(3).getExist()==true && pocket5.obj.get(4).getExist()== true){
                System.out.println("ترکیب جوهر نمک و سفیدکننده لوله را در خود حل کرد و حالا میتوانید راحت از طریق لوله به بیرون زندان فرار کنید.");
                System.out.println("شما در شبکه لوله های زیر زندان هستید.برای بیرون رفتن و رسیدن به سر منزل مقسود باید معمای زیر را حل کنید.\n\n");
                games game3 = new games();
                if(game3.seri()==true)
                win();
                else{lose("شما در حل معما شکست خوردید.");}
            }
            else { System.out.println("شما نیاز به هر دو ماده اسیدسولفوریک و سدیم هیپوکلرید دارید!"); startcell(); }
            case 3 : lose("هنگام برداشتن کلید از جیب نگهبان او متوجه شد...");

        }
    }

    @Override
    public  void starthamam(){

        soal("شما در حمام زندان هستید در سمت چپ کمد مواد شوینده وجود دارد همچنین حوله ای آویزان بوده و دستمال کاغذی نیز روی میز جلوی شما قرار دارد",
                " دستمال کاغذی را برداریم","حوله را برداریم"," به سمت کمد مواد شوینده برویم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : System.out.println("دستمال کاغذی به دردمان نمیخورد");starthamam();
            case 2 :  System.out.println("حوله استفاده ای ندارد");starthamam();
            case 3 : soal("درب کمد قفل است",
                    "به سلول خود رفته و کلید کمد را از جیب نگهبان کش برویم","با چکش درب کمد را بشکنیم","با پیچ گوشتی درب کمد را بازکنیم");
                n = s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : startcell();
                    case 2 : if(pocket5.obj.get(1).getExist()==true){lose("صدای ناشی از ضربات چکش باعث لو رفتن شما شد و نگهبانان شما را دستگیر کردند.");}
                    else{ System.out.println("شما نیاز به چکش برای شکستن درب دارید"); starthamam(); }
                    case 3 : if(pocket5.obj.get(0).getExist()==true){
                        System.out.println("درب کمد باز شد فقط برای اینکه کسی شک نکند بعد از برداشتن شی مورد نظر باید دوباره درب را با پیچ گوشتی ببندید.");
                        soal("درون کمد مواد شوینده جوهرنمک و شامپو سدر صحت و سفیدکننده وجود دارد کدام را برمیدارید",
                                "جوهرنمک","شامپو سدر صحت","سفیدکننده");
                        n= s.nextInt();
                        switch (n){
                            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                            case 0 : bazgasht();
                            case 1 : pocket5.obj.get(3).setExist(true); System.out.println("جوهرنمک برداشته شد"); starthamam();
                            case 2 : pocket5.obj.get(5).setExist(true); System.out.println("شامپو سدر صحت برداشته شد"); starthamam();
                            case 3 : pocket5.obj.get(4).setExist(true); System.out.println("سفیدکننده برداشته شد"); starthamam();
                        }
                    }
                    else { System.out.println("شما نیاز به پیچ گوشتی دارید"); starthamam(); }
                }
        }
    }

    @Override
    public  void startanbar(){
        soal("اینجا تاسیسات زندان است روی زمین یک جعبه ابزار قرار دارد در کنار آن  یک کلنگ  و یک بشکه نفت وجود دارد ",
                "کلنگ را برداریم","مقداری نفت برداریم","در جعبه ابزار را باز کنیم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1: pocket5.obj.get(2).setExist(true); System.out.println("کلنگ برداشته شد.");startanbar();
            case 2:  System.out.println("نیازی به نفت نداریم");  startanbar();
            case 3 : soal("درب جعبه ابزار را باز کردیم در آن یک چکش یک پیچ گوشتی و یک آچار قرار دارد","چکش","آچار","پیچ گوشتی");
                n = s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : pocket5.obj.get(1).setExist(true); System.out.println("چکش برداشته شد");  startanbar();
                    case 2 :  System.out.println("فعلا به آچار نیاز نداریم");startanbar();
                    case 3 :  pocket5.obj.get(0).setExist(true); System.out.println("پیچ گوشتی برداشته شد");  startanbar();
                }
        }
    }

}