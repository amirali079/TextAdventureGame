import sun.applet.Main;

import java.util.Random;

public class gameseri {
     Random r=new Random();
    public void seriProgram(){
         int n=r.nextInt(20 +1)+20;
        Server.sender(n);
        int pointX =(int)Server.reciver();
        int pointY =(int)Server.reciver();

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
        Server.sender(win);
    }
}
