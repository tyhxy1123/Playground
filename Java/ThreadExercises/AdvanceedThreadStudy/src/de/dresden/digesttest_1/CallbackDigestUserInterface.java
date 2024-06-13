package de.dresden.digesttest_1;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

public class CallbackDigestUserInterface {
    public static void receiveDigest(byte[] digest, String name){
        StringBuilder str = new StringBuilder();
        str.append(name);
        str.append(": ");
        str.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(str);
    }

    public static void main(String[] args) {
        String [] nameArr = {"163.html","myObjectFile.txt", "ThreadExercises.iml"};
        for (String s : nameArr) {
            CallbackDigest rd = new CallbackDigest(s);
            new Thread(rd).start();
        }
    }
}
