package de.dresden.digesttest_1;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        ReturnDigest rd1 = new ReturnDigest("163.html");
//        ReturnDigest rd2 = new ReturnDigest("myObjectFile.txt");
//        ReturnDigest rd3 = new ReturnDigest("ThreadExercises.iml");
//        Thread t1 = new Thread(rd1);
//        Thread t2 = new Thread(rd2);
//        Thread t3 = new Thread(rd3);
//        System.out.println(rd1.getDigest());
        String [] nameArr = {"163.html","myObjectFile.txt", "ThreadExercises.iml"};
        List<ReturnDigest> hehe = new ArrayList<>();
        for (String s : nameArr) {
            ReturnDigest rd = new ReturnDigest(s);
            hehe.add(rd);
            new Thread(rd).start();
        }
//        Thread.sleep(2000);
        for (ReturnDigest digest : hehe) {
            System.out.println(DatatypeConverter.printHexBinary(digest.getDigest()));
        }
    }
}
