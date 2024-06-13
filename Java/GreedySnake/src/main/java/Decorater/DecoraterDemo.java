package Decorater;

import java.io.*;

public final class DecoraterDemo{
    private DecoraterDemo(){};

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(new FileInputStream("tmp.txt")));
        var writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt")));
        while(reader.ready()){
            var line = reader.readLine();
            writer.write(line.toLowerCase());
            writer.newLine();
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
