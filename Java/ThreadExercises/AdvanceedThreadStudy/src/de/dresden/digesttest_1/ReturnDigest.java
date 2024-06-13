package de.dresden.digesttest_1;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ReturnDigest implements Runnable{
    private String fileName;
    private byte[] digest;
    public ReturnDigest(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void run(){
        try {
            FileInputStream in = new FileInputStream(new File(fileName));
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while(din.read() != -1){};
            din.close();
            digest = sha.digest();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public byte[] getDigest(){
        return digest;
    }
}
