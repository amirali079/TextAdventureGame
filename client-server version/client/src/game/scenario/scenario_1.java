package game.scenario;
import game.control.*;

public class scenario_1 extends BaseScenario {

    place pocket = new place("pocket");


    public scenario_1(){
        pocket.obj.add(new object("چاقو"));
        pocket.obj.add(new object("ساعات رفت و آمد نگهبان"));
        pocket.obj.add(new object("ادویه"));
        pocket.obj.add(new object("غذا"));}

   @Override
   public int getID(){ return 1;}


    @Override
    public void win() throws MyExeption{

        v1 = Vazeiat.win;
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("شما پیروز شدید!!!");
        System.out.println("به شما یک عدد کلید جادویی تعلق گرفت!!!");
        key++;
        System.out.println("ایا میخواهید به مرحله بعد بروید؟لطفا برای پاسخ مثبت عدد1 و پاسخ منفی عدد 0 را وارد نمیایید\n");
        int j = s.nextInt();
        if( j  == 0){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.exit(0);}
        if( j == 1){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("\n");

            System.out.println(ConsoleColors.RESET);
            try {
                scenario_2 sa1=new scenario_2();
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
            System.out.println("لطفا برای پاسخ مثبت عدد1 و پاسخ منفی عدد 0 را وارد نمیایید");win();
        }

    }


    @Override
    public void bazgasht() throws MyExeption{
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("به کجا میخواهید بروید؟");
        System.out.println("1.سلول خود");
        System.out.println("2.آشپزخانه");
        System.out.println("3.حیاط");
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
            case 2: startkitchen();
            case 3 : startyard();
            default:
                System.out.println("عدد وارد شده معتبر نمیباشد.");
                bazgasht();
        }
    }

    @Override
    public void ejra() throws MyExeption{


        history.add(this);
        //System.out.println("00000001");
        System.out.println(ConsoleColors.RED_BOLD+"بخش اول:"+ConsoleColors.CYAN_BOLD+" آماده سازی");
        System.out.println(ConsoleColors.RED_BOLD);
        System.out.println("----------------------------------------------------------------");
        System.out.println(ConsoleColors.CYAN_BOLD);
        System.out.println("در قدم اول باید همسلولی خود حسن را که او هم به جرم اختلاص و برهم زدن نظم عمومی دستگیر شده را با خود همراه کنید.");
        System.out.println(ConsoleColors.RESET);
        startcell();
    }



    public void startcell() throws MyExeption{
        soal("شما در سلول خودهستید.هم سلولی شما در حال پشه پراندن است.در سمت چپ شما در سلول وجود دارد که پشت در یک نگهبان قرار دارد.سمت راست پنجره سلول است و روی زمین یک قاشق افتاده است! ",
                "به طرف هم سلولی برویم","در را به صدا دراورده و با نگهبان صحبت کنیم","قاشق را برداریم");
        int n=s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1: soal("کنار هم سلولی:","با او درباره فرار صحبت کنیم","او را بکشیم",null);
                n=s.nextInt();
                switch(n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : soal("او میگوید که الان گرسنه است و غذا میخواهد.","برای او از اشپزخانه غذا بیاوریم ","قبول نکنیم","به او غذا بدهیم");
                        n=s.nextInt();
                        switch(n){
                            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                            case 0 : bazgasht();
                            case 1: startkitchen() ;
                            case 2: lose("او عصبانی شد و شما را به نگهبان لو داد!");
                            case 3 :   if(pocket.obj.get(3).getExist()==true){
                                soal("او غذا را از شما گرفت و پس از پرکردن شکم مبارک از اطعمه و اشربه به شما گفت که حالا باید ساعت رفت و آمد نگهبان سلول را بفهمیم همچنین گفت از این به بعد هروقت میخواهیم با او صحبت کنیم باید برایش غذا بیاوریم",
                                        "عصبانی شده و با او درگیر شویم","قبول کنیم و به دنبال فهمیدن آن برویم","ساعات رفت و آمد را به او بگوییم");
                                n=s.nextInt();
                                switch (n){
                                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                                    case 0 : bazgasht();
                                    case 1: lose("او داد و فریاد کرد و نگهبان را از نقشه فرار مطلع کرد.");
                                    case 2: startcell();
                                    case 3 : if(pocket.obj.get(2).getExist()==true) {
                                        System.out.println("او بسیار خوشحال شد و قبول کرد که با شما همراه شود ولی گفت که به عنوان آخرین شرط شما باید بازی سودوکوویی را که به شما میدهد حل نمایید");
                                       // games game1 = new games();
                                        //if(game1.sudokou()==false)
                                            win();
                                       // else {
                                           // lose("شما در بازی سودوکو شکست خوردید.");}

                                    }
                                    else { System.out.println("شما نیاز به دانستن ساعات رفت و آمد نگهبان دارید!");startcell(); }
                                }
                            }
                            else{System.out.println("شما نیاز به غذا دارید!");startcell(); }

                        }
                    case 2 : if(pocket.obj.get(0).getExist()==true){
                        lose("او کشته شده شد و نگهبان شما را دستگیر کرد.");}
                    else{System.out.println("شما نیاز به سلاح دارید.");startcell();}

                }
            case 2: soal("کنار نگهبان:","با او درباره فرار صحبت کنیم و بپرسیم که با ما همراه می شود؟","او را بکشیم","از ساعات رفت و آمد او بپرسیم");
                n= s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 :
                        lose("او شما را دستگیر کرد و به سرنگهبان تحویل داد.");
                    case 2 :
                        if(pocket.obj.get(0).getExist()==true){
                            lose("او کشته شده شد و بقیه نگهبان ها شما را دستگیر کردند.");}
                        else{System.out.println("شما نیاز به سلاح دارید.");startcell();}
                    case 3 : pocket.obj.get(1).setExist(true);
                        System.out.println("شما ساعات رفت و آمد را فهمیدید ممکن است بعدا به دردتان بخورد"); startcell();
                }
            case 3 :
                System.out.println("با قاشق شاید بتوان زمین را کند. ولی اول باید هم سلولی خود را با خود همراه کنید.");startcell();
        }
    }

    public void startkitchen() throws MyExeption{
        soal("شما در آشپزخانه هستید... سمت چپ یک میز است که روی آن یک کارد و یک چنگال قرار دارد.همچنین رو به روی شما آشپز ایستاده است.",
                "کارد را برداریم.","چنگال را برداریم","با آشپز صحبت کنیم.");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1:pocket.obj.get(0).setExist(true); System.out.println("شما کارد را برداشتید"); startkitchen();
            case 2 : System.out.println("چنگال استفاده خاصی ندارد");startkitchen();
            case 3: soal("کنار آشپز:","با او درباره فرار صحبت کنیم","از او غذا بخواهیم",null);
                n = s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : lose("او شما را به نگهبان لو داد و شما دستگیر شدید.");
                    case 2: soal( "او میگوید که اندکی غذا باقی مانده است. اما شما سهمیه غذای امروز خود را گرفته اید. اگر غذای اضافه میخواهید باید برای غذای امشب ادویه پیدا کنید.",
                            "قبول نکنید.","به حیاط زندان رفته و ادویه پیدا کنید","به او ادویه مورد نیاز را بدهیم.");
                        n = s.nextInt();
                        switch (n){
                            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                            case 0 : bazgasht();
                            case 1:startkitchen();
                            case 2: startyard();
                            case 3: if(pocket.obj.get(2).getExist()== true){
                                pocket.obj.get(3).setExist(true);
                                System.out.println("او ادویه را گرفت و بسیار خوشحال شد و غذای اضافی به شما داد.");startkitchen();
                            }
                            else {
                                System.out.println("شما نیاز به ادویه دارید!");startkitchen();
                            }
                        }
                }
        }

    }

    public void startyard() throws MyExeption{
        soal("شما در حیاط زندان هستید...در حیاط یک درخت تنومند قرار دارد و زیر آن یک باغچه کوچک است.در ضمن دیوار زندان نیز که به خیابان جلوی زندان راه دارد نیز دیده میشود.",
                "از دیوار زندان بالا رفته و فرار کنیم.","نزدیک درخت رفته و از میوه های آن بخوریم","به طرف باغچه برویم");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1 :
                lose("وقتی داشتید از دیوار زندان بالا میرفتید نگهبانان شما را دیدند و به طرف شما تیرشلیک کرده و شما را کتند");
            case 2 :
                lose("متاسفانه به میوه های درخت سم زده بودند و شما مسموم شدید ");
            case 3 : soal("در باغچه گیاهان زیادی وجود دارد از جمله یک گیاه بیهوش کننده یک قارچ سمی و فلفل کدام را بچینیم؟","قارچ","گیاه بیهوش کننده","فلفل");
                n= s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1:
                        System.out.println("فکر نمیکنم قارچ به درد شما بخورد ");startyard();
                    case 2 :
                        lose("وقتی گیاه را از ریشه در آوردید گاز های بیهوش کننده آن فعال شد و شما را بیهوش کرد.");
                    case 3:
                        pocket.obj.get(2).setExist(true);
                        System.out.println("این همان ادویه ای بود که آشپز میخواست!");startyard();
                }
        }
    }


}
