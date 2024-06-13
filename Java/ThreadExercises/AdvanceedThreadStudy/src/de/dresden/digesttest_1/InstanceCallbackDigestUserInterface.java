package de.dresden.digesttest_1;

import javax.xml.bind.DatatypeConverter;

public class InstanceCallbackDigestUserInterface implements Runnable{
    private String fileName;
    private byte[] digest;
    public InstanceCallbackDigestUserInterface(String fileName){
        this.fileName = fileName;
    }
    public void calculateDigest(){
        InstanceCallbackDigest cb = new InstanceCallbackDigest(this, fileName);
        new Thread(cb).start();
    }
    public void receiveDigest(byte[] digest){
        this.digest = digest;
        System.out.println(this);
    }
    @Override
    public String toString(){
        String result = fileName;
        if(digest!=null) {
            StringBuilder str = new StringBuilder();
            str.append(fileName).append(": ").append(DatatypeConverter.printHexBinary(digest));
            return str.toString();
        }
        else{
            return result + ": digest not available";
        }
    }
    @Override
    public void run() {
        calculateDigest();
    }
    public static void main(String[] args) {
        String [] nameArr = {"163.html","myObjectFile.txt", "ThreadExercises.iml"};
        for (String name : nameArr) {
            InstanceCallbackDigestUserInterface userInterface = new InstanceCallbackDigestUserInterface(name);
            new Thread(userInterface).start();
        }
    }
}
