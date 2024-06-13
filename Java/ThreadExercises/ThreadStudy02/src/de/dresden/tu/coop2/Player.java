package de.dresden.tu.coop2;

public class Player extends Thread {
    Tv tv;
    public Player(Tv tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i = 0; i<20; i++){
            if(i%2==0){
                this.tv.play("奇葩说");
            }
            else{
                this.tv.play("太污了，洗洗");
            }
        }
    }
}
