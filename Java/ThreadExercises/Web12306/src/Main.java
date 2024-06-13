public class Main {

    public static void main(String[] args) {
        Web w = new Web();
        new Thread(w, "黄牛01").start();
        new Thread(w, "蓝牛02").start();
        new Thread(w, "绿牛03").start();
    }
}
