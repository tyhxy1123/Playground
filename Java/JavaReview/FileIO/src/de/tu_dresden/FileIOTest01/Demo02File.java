package de.tu_dresden.FileIOTest01;


import java.io.File;

/**
 * 绝对路径与相对路径
 */
public class Demo02File {


    public void show01() {
        File f1 = new File("a.txt");
        System.out.println(f1);
        String absolutePath = f1.getAbsolutePath();
        System.out.println(absolutePath);
    }
}
