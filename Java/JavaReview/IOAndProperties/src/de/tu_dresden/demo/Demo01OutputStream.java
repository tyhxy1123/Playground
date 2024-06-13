package de.tu_dresden.demo;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("IOAndProperties//a.txt");
        fos.write(97);
        fos.close();
    }
}
