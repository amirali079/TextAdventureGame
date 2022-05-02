package game.scenario;
import game.control.MyExeption;
import game.control.object;
import game.control.place;

import game.control.ConsoleColors;

public class scenario_3 extends BaseScenario{

    @Override
    public int getID(){ return 3;}


    place pocket = new place("pocket3");


    public scenario_3() {
        pocket.obj.add(new object("میوه"));
        pocket.obj.add(new object("انبر"));
        pocket.obj.add(new object("ذغال"));
        pocket.obj.add(new object("دستمال کاغذی"));
    }




    @Override
    public void win()throws MyExeption {
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("شما پیروز شدید!!!");
        System.out.println("به شما یک عدد کلید جادویی تعلق گرفت!!!");
        key++;
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
                scenario_4 sa1=new scenario_4();
                sa1.ejra();}
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
        }
        else{
            System.out.println("لطفا برای پاسخ مثبت عدد1 و پاسخ منفی عدد 0 را وارد نمیایید!");win();
        }

    }

    @Override
    public void bazgasht()throws MyExeption{
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("به کجا میخواهید بروید؟");
        System.out.println("1.سلول خود");
        System.out.println("2.حمام زندان");
        System.out.println("3.حیاط");
        System.out.println("4.آشپزخانه");
        System.out.println("0.ذخیره وضعیت بازی");
        System.out.println("-1.بارگذاری بازی");
        System.out.println("-2.بازگشت به قبل با استفاده از کلید جادویی");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(ConsoleColors.RESET);
        int b = s.nextInt();
        switch (b){
            case -2 : bargasht();
            case -1 : load();
            case 0 : save(this.getID(),this.pocket);
            case 1 : startcell();
            case 2 : starthamam();
            case 3 : startyard();
            case 4 : startkitchen();
            default:
                System.out.println("عدد وارد شده معتبر نمیباشد.");
                bazgasht();
        }
    }

    @Override
    public void ejra()throws MyExeption{

        history.add(this);

        System.out.println();
        System.out.println(ConsoleColors.CYAN_BOLD);
        System.out.println("بخش سوم: نقشه فرار ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("در قسمت قبل چاله ای عمیق حفر کردید اما متوجه شدید که نیاز به نقشه زندان دارید... ");
        System.out.println(ConsoleColors.RESET);
        help("هم سلولی شما میگوید که فردی را در زندان میشناسد که نقشه زندان را بلد است همچنین آن شخص بع میوه الوعهورا علاقه شدیدی دارد...!");

        startcell();

    }




    public void startcell()throws MyExeption{

        soal("شما در سلول خود هستید و برای ادامه کار نیاز به نقشه زندان دارید",
                "بدون نقشه ادامه می دهیم","از نگهبان به طور غیر مستقیم بپرسیم","به حیاط رفته و شخصی که نقشه را بلد است پیدا کنیم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : lose("وقتی زمین را میکندیم سر از دفتر رییس زندان در آوردیم و نگهبان ها ما را دستگیر کردند.");
            case 2 : lose("نگهبان شک کرد و به داخل سلول امد و چاله را که حفر کردیم دید");
            case 3 : startyard();
        }

    }


    public void startyard()throws MyExeption{

        soal("شما در حیاط زندان هستید شخصی که همسلولی شما میگفت روی نیمکت نشسته همچنین سمت راست شما درخت آلوعهورا قرار دارد و دیوار زندان نیز روبه روی شما قرار دارد",
                "از درخت میوه چیده و آن ها را بشوریم","از دیوار زندان بالا رفته و فرار کنیم","به طرف شخص مورد نظر رفته و با او صحبت کنیم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : pocket.obj.get(0).setExist(true); System.out.println("میوه ها چیده شد");startyard();

            case 2 : lose("وقتی داشتید از دیوار زندان بالا میرفتید نگهبانان شما را دیدند و به طرف شما تیرشلیک کرده و شما را کنند");
            case 3 : soal("وقتی درباره نقشه زندان با او صحبت کردیم او خود را به نفهمی زد.",
                    "به او التماس و تضرع فراوان کنیم","گردن او را گرفته و تا حد خفگی فشار دهیم تا نقشه را لو بدهد","به او از میوه های درخت بدهیم و تریپ رفاقت با او برداریم");
                n= s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : System.out.println("گریه و التماس هیچ تاثیری بر دل سنگ او ندارد باید پاره ای دیگر بیاندیشیم");startyard();
                    case 2 : lose("وقتی این کار را کردیم او داد  و فریاد کرد و بقیه زندانی ها و نگهبان هارا جمع کرد و نقشه ما را لو داد");
                    case 3 : if(pocket.obj.get(0).getExist()==false){
                        System.out.println("نیاز به میوه دارید");startyard();}
                    else{pocket.obj.get(0).setExist(false);
                        soal("او بسیار خوش حال شد ولی گفت که دفعه بعد هم باید برای او میوه الوعهورا بیاوریم وگرنه با ما صحبت نمیکند و خود را دوباره به نفهمی میزند. و گفت که برای گفتن نقشه به ما باید قلم وکاغذ داشته باشیم",
                                "به دنبال قلم و کاغذ برویم","قلم و کاغذ به او بدهیم",null);
                        n = s.nextInt();
                        switch (n){
                            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                            case 0 : bazgasht();
                            case 1 : help("با توجه به اینکه زندان مغازه لوازم التحریری نیست میتوان بجای کاغذ از دستمال کاغذی و بجای قلم از ذغال استفاده کرد که اینها در حمام و آشپزخانه زندان ممکن است وجود داشته باشد");
                                bazgasht();
                            case 2 : if(pocket.obj.get(3).getExist()==true && pocket.obj.get(2).getExist()==true)
                            { System.out.println("او نقشه زندان را برای شما رسم کرد. حالا شما میتوانید با خیال راحت به حفاری خود ادامه دهید...");
                                win();
                            }
                            else{ System.out.println("وسایلی که گفته شده کامل نیست باید قلم و کاغذ تهیه کیند"); bazgasht();}
                        }
                    }
                }
        }

    }

    public void starthamam()throws MyExeption{
        soal("شما در حمام زندان هستید در سمت چپ کمد مواد شوینده وجود دارد همچنین حوله ای آویزان بوده و دستمال کاغذی نیز روی میز جلوی شما قرار دارد",
                "به سمت کمد مواد شوینده برویم","حوله را برداریم","دستمال کاغذی را برداریم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : System.out.println("درب کمد قفل است");starthamam();
            case 2 : System.out.println("حوله به دردمان نمیخورد");starthamam();
            case 3 :  pocket.obj.get(3).setExist(true);  System.out.println("دستمال کاغذی برداشته شد!");starthamam();
        }
    }

    public void startkitchen()throws MyExeption{
        soal("شما در آشپزخانه هستید و ذغال ها درون منقل در حال شعله ور شدن است و انبری درکنار منقل قرار دارد",
                "از آشپز بخواهیم مقداری ذغال به ما بدهد","آهسته و به دور از چشم آشپز ذغال برداریم","انبر را برداریم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 : System.out.println("آشپز قبول نکرد!"); startkitchen();
            case 2 : if(pocket.obj.get(1).getExist()==true){pocket.obj.get(2).setExist(true);   System.out.println("ذغال ها با انبر برداشته شد"); bazgasht();}
            else { System.out.println("ذغال ها بسیار داغ است و برای برداشتن ان ها نیاز به وسیله ای دارید!"); startkitchen(); }
            case 3 : pocket.obj.get(1).setExist(true); System.out.println("انبر برداشته شد!");  startkitchen();
        }
    }
}