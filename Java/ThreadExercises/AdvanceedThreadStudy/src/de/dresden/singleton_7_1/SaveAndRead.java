package de.dresden.singleton_7_1;

import java.io.*;

public class SaveAndRead {
    public static void main(String[] args) {
        try{
            MyObject myObject = MyObject.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("myObjectFile.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject.hashCode());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        FileInputStream fisRef = null;
        try {
            fisRef = new FileInputStream(new File("myObjectFile.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject myObject = (MyObject) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObject.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
