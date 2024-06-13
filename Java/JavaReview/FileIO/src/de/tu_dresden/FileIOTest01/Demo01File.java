package de.tu_dresden.FileIOTest01;

import java.io.File;

/**
 * Java 通过File类访问计算机文件系统
 * 创建，删除，获取，遍历文件和文件夹
 * File类是一个与系统无关的类，任何操作系统都可以使用
 * <p>
 * 三个单词:
 * 1. File: 文件
 * 2. Directory: 文件夹
 * 3. Path: 路径
 */

public class Demo01File {
    public static void main(String[] args) {
        /**
         * 操作路径不能写死了
         * Windows和Linux系统分隔符不同
         * 用fileSeparator和pathSeparator
         */
        String pathSeparator = File.pathSeparator;//路径分隔符，Windows分号，Linux冒号
        System.out.println(pathSeparator);

        String separator = File.separator;//文件名称分隔符 Windows反斜杠\,Linux斜杠/
        System.out.println(separator);

        Demo02File d2 = new Demo02File();
        d2.show01();

        File f1 = new File("/Users/xiangyu/Projects");
        File[] l2 = f1.listFiles();
        for (File f : l2) {
            System.out.println(f.getAbsolutePath());
        }

    }
}
