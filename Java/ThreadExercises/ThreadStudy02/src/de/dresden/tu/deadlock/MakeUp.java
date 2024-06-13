package de.dresden.tu.deadlock;

public class MakeUp extends Thread {
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();
    int choice;
    String name;
    public MakeUp(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        makeUp();
    }

    private void makeUp(){
        if(choice == 0){
            synchronized (lipStick){
                System.out.println(this.name + "拿到了口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (mirror){
                    System.out.println(this.name + "拿到了镜子");
                }
            }
        }
        else {
            synchronized (mirror){
                System.out.println(this.name + "拿到了镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lipStick){
                    System.out.println(this.name + "拿到了口红");
                }
            }
        }
    }

    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "大丫");
        MakeUp g2 = new MakeUp(1, "二丫");
        new Thread(g1).start();
        new Thread(g2).start();
    }
}
