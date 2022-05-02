package game.scenario;
import game.control.object;
import game.control.place;
import java.util.Scanner;
import game.control.ConsoleColors;
import game.control.games;

public class scenario_2 extends scenario_1{

    Scanner s=new Scanner(System.in);
    place pocket2 = new place("pocket2");
    place hamseloli = new place("هم سلولی");

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
                scenario_3 sa1=new scenario_3();
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
        System.out.println("2.تاسیسات زندان");
        System.out.println("3.حیاط");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(ConsoleColors.RESET);
        int b = s.nextInt();
        switch (b){
            case 1 : startcell();
            case 2: startanbar();
            case 3 : startyard();
            default:
                System.out.println("عدد وارد شده معتبر نمیباشد.");
                bazgasht();
        }
    }
    @Override
    public void ejra(){
        pocket2.obj.add(new object("قاشق"));
        pocket2.obj.add(new object("بیل"));
        pocket2.obj.add(new object("گونی"));
        pocket2.obj.add(new object("اره"));

        hamseloli.obj.add(new object("حواس به نگهبان"));
        hamseloli.obj.add(new object("سرنگهبان را گرم"));


        System.out.println();
        System.out.println(ConsoleColors.CYAN_BOLD);
        System.out.println("بخش دوم: آغاز راه");
        System.out.println("----------------------------------------------------------------");
        System.out.println("در قسمت قبل توانستیم همسلولی خود حسن را با خود همراه کنیم...در این بخش باید راهی برای فرار پیدا کنیم");
        System.out.println(ConsoleColors.RESET);
        help("شما باید مکانی را برای کندن حفره پیدا کنید تا از طریق آن فرار کنید در حین انجام کار حتما حواستان به نگهبان سلول باشد.");

        startcell();

    }



    public void startanbar(){
        System.out.println("به نزدیک در تاسیسات زندان رسیدید برای ورود به آن و باز شدن در آن باید در بازی زیر پیروز شوید! ");
        games g=new games();
        if(g.duzzz()==true){
            System.out.println("شما در این بازی برنده شدید و در تاسیسات زندان برای شما باز شد.");
        }
        else{
            System.out.println("شما در بازی شکست خوردید لطفا دوباره تلاش کنید.");startanbar();
        }
        soal("اینجا تاسیسات زندان است و درآن وسایل زیادی وجود دارد.چون زیاد وقت نداریم نمی توانیم تا آخر آنجا را بگردیم. فعلا در این نزدیکی یک بیل یک اره و یک بشکه نفت وجود دارد کدام را برداریم.",
                "اره","بیل","بشکه");
        int n = s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1:pocket2.obj.get(3).setExist(true);
                System.out.println("اره برداشته شد!");startyard();
            case 2: pocket2.obj.get(1).setExist(true);
                System.out.println("بیل برداشته شد");bazgasht();
            case 3 : lose("بشکه نفت بسیار سنگین بود و وقتی داشتیم آن را جابه جا میکردیم به روی ما افتاد");
        }
    }

    @Override
    public void startyard() {
        soal("ما در حیاط هستیم در نزدیکی ما یک درخت آلوعهورا وجود دارد و در سمت راست یک گونی خالی افتاده همچنین دیوار مشترک بین خیابان و زندان روبه روی ما قرار دارد",
                "از میوه های درخت بخوریم", "گونی را برداریم", "از دیوار بالا رفته و فرار کنیم");
        int n = s.nextInt();
        switch (n) {
            default:
                System.out.println("عدد وارد شده معتبر نمیباشد");
                bazgasht();
            case 0:
                bazgasht();
            case 3:
                lose("وقتی داشتید از دیوار زندان بالا میرفتید نگهبانان شما را دیدند و به طرف شما تیرشلیک کرده و شما را کتند");
            case 1:
                lose("متاسفانه به میوه های درخت سم زده بودند و شما مسموم شدید ");
            case 2:pocket2.obj.get(2).setExist(true);
                System.out.println("گونی برداشته شد!");startyard();

        }
    }

    @Override
    public void startcell(){
        System.out.println();

        soal("شما در سلول خودهستید.هم سلولی شما در حال پشه پراندن است.سمت راست پنجره سلول است و درست زیر آن تخت شما قرار دارد و روی زمین یک قاشق افتاده است! ",
                "به طرف هم سلولی برویم","به طرف زمین زیر تخت برویم","قاشق را برداریم");
        int n=s.nextInt();
        switch (n){
            default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
            case 0 : bazgasht();
            case 1: soal("کنار هم سلولی:","به او بگوییم حواسش به نگهبان باشد.","او را بکشیم","به او بگوییم سرنگهبان را گرم کند");
                n=s.nextInt();
                switch(n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 : hamseloli.obj.get(0).setExist(true);
                        System.out.println("او سمت در رفت تا حواسش به نگهبان باشد !");startcell();

                    case 2 : if(pocket2.obj.get(3).getExist()==true){
                        lose("او کشته شده شد و نگهبان شما را دستگیر کرد.");}
                    else{System.out.println("شما نیاز به سلاح دارید.");startcell();}
                    case 3 : hamseloli.obj.get(1).setExist(true);
                        System.out.println("او رفت با نگهبان صحبت کند تا حواس نگهبان پرت شود.الان میتوانید بدون این که دیده شوید از سلول خارج شوید!");startcell();
                }
            case 2 : soal("کنار زمین زیر تخت:","آنجا گودال حفر کنیم","گودال حفر شده را عمیق تر کنیم.",null);
                n= s.nextInt();
                switch (n){
                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                    case 0 : bazgasht();
                    case 1 :
                        if(hamseloli.obj.get(0).getExist()==true ){
                            if( pocket2.obj.get(0).getExist()==true) {
                                soal("شما با قاشق گودالی حفر کردید اما برای عمیق تر کردن آن باید وسیله قوی تری پیدا کنید!","با همان قاشق ادامه دهیم","به تاسیسات زندان رفته و وسیله ای پیدا کنیم",null);
                                n = s.nextInt();
                                switch (n) {
                                    default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                                    case 0 : bazgasht();
                                    case 1: lose("وقتی با قاشق ادامه دادیم خیلی طول کشید تا کمی دیگر حفر کنیم و سرانجام قاشق شکست و چون زمان زیادی صرف کردیم سرنکهبان رسید و شما را دستگیر کرد ");
                                    case 2 : startanbar();
                                }
                            }
                            else { System.out.println("شما نیاز به وسیله ای برای کندن زمین دارید!"); startcell(); } }
                        else { System.out.println("همسلولی شما باید حواسش به نگهبان باشد."); startcell(); }
                    case 2 :
                        if(pocket2.obj.get(1).getExist()==true){
                            soal("شما گودال را تا حد نیاز عمیق کردید!تنها یک مشکل دارید. باید خاک هایی را که از گودال باقی مانده را از سلول خارج کنیم.",
                                    "خاک ها را از پنجره به بیرون میریزیم.","به دنبال گونی برای حمل خاک ها به حیاط زندان میرویم","خاک ها را به داخل گونی برای حمل آن ها میریزیم");
                            n = s.nextInt();
                            switch (n){
                                default: System.out.println("عدد وارد شده معتبر نمیباشد");bazgasht();
                                case 0 : bazgasht();
                                case 1 :lose("با ریختن خاک ها به بیرون نگهبان های حیاط متوجه نقشه شما شده و شما را دستگیر کردند.");
                                case 2 :startyard();
                                case 3 : if(hamseloli.obj.get(1).getExist()==true){
                                    System.out.println("خاک ها به وسیله گونی از سلول بیرون برده شد.حالا شما گودال را تا حد نیاز عمیق کردید.اما مشکل بزرکتر تازه شروع شده...شما برای فرار نقشه کامل زندان را میخواهید...ادامه در قسمت بعد");
                                    win();
                                }
                                else{ System.out.println("هم سلولی شما باید حواس نگهبان را پرت کند تا بتوانید گونی ها را به بییرون ببرید.");startcell(); }
                            }
                        }
                        else{System.out.println("شما نیاز به وسیله قوی تر از قاشق برای کندن زمین دارید.");startcell();}
                }

            case 3 : pocket2.obj.get(0).setExist(true);System.out.println("قاشق برداشته شد"); startcell();
        }
    }
}
