package game.control;
import game.control.ConsoleColors;
import java.util.Scanner;
import java.util.Random;
public class games {
    Scanner s=new Scanner(System.in);
    Random r=new Random();
    public boolean sudokou(){
        boolean lose=false;
        int [][]mx=new int[9][9];
        int [][]mxinp=new int[9][9];
        int row,column;

        for (int t=0;t<300;t++) {
            row=r.nextInt(8+1);
            column=r.nextInt(8+1);
            mx[row][column] = r.nextInt(8 + 1) + 1;
        }
        for(int i=0;i<9;i++){
            boolean [] check=new boolean[10];
            for(int j=0;j<9;j++){
                if(mx[i][j]!=0){
                    if(check[mx[i][j]]==false)
                        check[mx[i][j]]=true;
                    else
                        mx[i][j]=0;}
            }
        }
        for(int i=0;i<9;i++){
            boolean [] check=new boolean[10];
            for(int j=0;j<9;j++){
                if(mx[j][i]!=0)
                    if(check[mx[j][i]]==false)
                        check[mx[j][i]]=true;
                    else
                        mx[j][i]=0;
            }
        }
        for(int i=1;i<9;i+=3){
            boolean [] check=new boolean[10];
            for(int j=1;j<9;j+=3){
                if(mx[i-1][j-1]!=0){
                    if(check[mx[i-1][j-1]]==false)
                        check[mx[i-1][j-1]]=true;
                    else
                        mx[i-1][j-1]=0;}
                if(mx[i-1][j]!=0){
                    if(check[mx[i-1][j]]==false)
                        check[mx[i-1][j]]=true;
                    else
                        mx[i-1][j]=0;}
                if(mx[i-1][j+1]!=0){
                    if(check[mx[i-1][j+1]]==false)
                        check[mx[i-1][j+1]]=true;
                    else
                        mxinp[i-1][j+1]=0;}
                if(mx[i][j-1]!=0){
                    if(check[mx[i][j-1]]==false)
                        check[mx[i][j-1]]=true;
                    else
                        mx[i][j-1]=0;}
                if(mx[i][j]!=0){
                    if(check[mx[i][j]]==false)
                        check[mx[i][j]]=true;
                    else
                        mx[i][j]=0;}
                if(mx[i][j+1]!=0){
                    if(check[mx[i][j+1]]==false)
                        check[mx[i][j+1]]=true;
                    else
                        mx[i][j+1]=0;}
                if(mx[i+1][j-1]!=0){
                    if(check[mx[i+1][j-1]]==false)
                        check[mx[i+1][j-1]]=true;
                    else
                        mx[i+1][j-1]=0;}
                if(mx[i+1][j]!=0){
                    if(check[mx[i+1][j]]==false)
                        check[mx[i+1][j]]=true;
                    else
                        mx[i+1][j]=0;}
                if(mx[i+1][j+1]!=0){
                    if(check[mx[i+1][j+1]]==false)
                        check[mx[i+1][j+1]]=true;
                    else
                        mx[i+1][j+1]=0;}
            }
        }
        System.out.println("______________________________________________________________________________________\n");
        System.out.println("-------------------------------------");
        for(int i=0;i<9;i++){
            System.out.print("| ");
            for(int j=0;j<9;j++){
                System.out.print(mx[i][j]+" | ");
            }
            System.out.println();
            System.out.print("-------------------------------------");
            System.out.println();
        }
        System.out.println("لطفا پاسخ صحیح را وارد کنید:");
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                mxinp[i][j]=s.nextInt();
        for(int i=0;i<9;i++){
            boolean [] check=new boolean[10];
            for(int j=0;j<9;j++){
                if(check[mxinp[i][j]]==false)
                    check[mxinp[i][j]]=true;
                else{
                    System.out.println("your answer is wrong");
                    lose=true;
                    break;}
            }
        }
        for(int i=0;i<9;i++){
            boolean [] check=new boolean[10];
            for(int j=0;j<9;j++){
                if(check[mxinp[j][i]]==false)
                    check[mxinp[j][i]]=true;
                else{
                    System.out.println("your answer is wrong");
                    lose=true;
                    break;}
            }
        }
        for(int i=1;i<9;i+=3){
            boolean [] check=new boolean[10];
            for(int j=1;j<9;j+=3){
                if(check[mxinp[i-1][j-1]]==false)
                    check[mxinp[i-1][j-1]]=true;
                else{
                   lose=true;
                   break;
                }
                if(check[mxinp[i-1][j]]==false)
                    check[mxinp[i-1][j]]=true;
                else{
                    lose=true;
                    break;
                }
                if(check[mxinp[i-1][j+1]]==false)
                    check[mxinp[i-1][j+1]]=true;
                else{
                    lose=true;
                    break;
                }
                if(check[mxinp[i][j-1]]==false)
                    check[mxinp[i][j-1]]=true;
                else{
                    lose=true;
                    break;
                }
                if(check[mxinp[i][j]]==false)
                    check[mxinp[i][j]]=true;
                else{
                    lose=true;
                    break;
                }
                if(check[mxinp[i][j+1]]==false)
                    check[mxinp[i][j+1]]=true;
                else{
                    lose=true;
                    break;
                }
                if(check[mxinp[i+1][j-1]]==false)
                    check[mxinp[i+1][j-1]]=true;
                else{
                    lose=true;
                    break;
                }
                if(check[mxinp[i+1][j]]==false)
                    check[mxinp[i+1][j]]=true;
                else{
                    lose=true;
                    break;
                }
                if(check[mxinp[i+1][j+1]]==false)
                    check[mxinp[i+1][j+1]]=true;
                else{
                    lose=true;
                    break;
                }
            }
        }
        return lose;
    }
    public boolean seri(){
        boolean winSeri=false;
        System.out.println(ConsoleColors.YELLOW_BRIGHT);
        System.out.println("___________________________________________________________________________________\n");
        System.out.println("یک سری از نقاط به ترتیب در پایین نشان داده شده باید رابطه ی بین آنها را فهمیده و نقطه ای که از شما خواسته شده وارد کنید ");
        int n=r.nextInt(20 +1)+20;
        System.out.println("(0,0),(1,0),(1,1),(-1,1),(-1,-1),(2,-1),(2,2),(-2,2),(-2,-2),(3,-2),(3,3),(-3,3),........");
        System.out.println("نقطه مورد نظر:");
        System.out.println(n);
        System.out.println("ابتدا x وسپس y را با فاصله از هم وارد کنید");
        System.out.println(ConsoleColors.RESET);
        winSeri = seriProgram(n, s.nextInt(), s.nextInt()) == true;
        return winSeri;
    }
    public boolean seriProgram(int n,int pointX,int pointY){
        boolean win=false;
        int x=0 ,y=0;
        int k=x,j=y;
        for(int i=0 ;i<n-1 ;i++){
            switch (i%4){
                case 3:j=-j;
                    continue;
                case 0:
                    x++;
                    k=x;
                    continue;
                case 1:
                    y++;
                    j=y;
                    continue;
                case 2:k=-k;
                    continue;
            }
        }
        if(k==pointX && j==pointY)
            win=true;
        return win;
    }


    public boolean duzzz(){
        boolean win=false;
        int win1=0;
        char []duz=new char[9];
        boolean[] total = new boolean[9];
        boolean[] user = new boolean[9];
        boolean[] computer = new boolean[9];
        int computerN;

        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT);
        for (int i=0;i<9;i++){
            duz[i]=32;
        }
        for(int j=0;j<9;j+=3){
            System.out.println("----------------");
            System.out.print("| "+duz[j]+" | "+duz[j+1]+" | "+duz[j+2]+" |\n");
        }
        System.out.println("----------------");

        while(win1!=1 && win1!=2){
            System.out.println("یک عدد بین  صفر تا هشت وارد کنید");
            int userN=s.nextInt();
            duz[userN]='U';

            total[userN]=true;
            user[userN]=true;
            if(user[0]==true && user[4]==true && user[8]==true){
                win1=1;
            break;}
            if(user[2]==true && user[4]==true && user[6]==true){
                win1=1;
            break;}
            for(int i=0;i<9;i+=3){
                if(user[i]==true && user[i+1]==true && user[i+2]==true){
                    win1=1;
                break;}
            }
            for(int i=0;i<9;i+=3){
                if(user[i]==true && user[i+3]==true && user[i+6]==true){
                    win1=1;
                break;}
            }
             computerN=r.nextInt(9);
            while (computer[computerN]==true || total[computerN]==true){
                computerN=r.nextInt(9);
            }
            duz[computerN]='C';
            total[computerN]=true;
            computer[computerN]=true;
            if(computer[0]==true && computer[4]==true && computer[8]==true){
                win1=2;
            break;}
            if(computer[2]==true && computer[4]==true && computer[6]==true){
                win1=2;
            break;}
            for(int i=0;i<9;i+=3){
                if(computer[i]==true && computer[i+1]==true && computer[i+2]==true){
                    win1=2;
                break;}
            }
            for(int i=0;i<9;i+=3){
                if(computer[i]==true && computer[i+1]==true && computer[i+2]==true){
                    win1=2;
                break;}

            }
            for(int j=0;j<9;j+=3){
                System.out.println("--------------");
                System.out.print("| "+duz[j]+" | "+duz[j+1]+" | "+duz[j+2]+" |\n");
            }
            System.out.println("--------------");
        }


        System.out.println(ConsoleColors.RESET);
        if(win1==1)
        return win=true;
        else
            return win;
    }
}