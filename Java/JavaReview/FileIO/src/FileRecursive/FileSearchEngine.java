package FileRecursive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearchEngine {

    public static List<String> searchRecursive(String path) {

        List<String> list = new ArrayList<String>();

        File f = new File(path);
        if (!f.exists() || f.isFile()) {
            try {
                throw new Exception("Invalid Path");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File[] files = f.listFiles();

        for (File file : files) {

            if (file.isFile()) {
                list.add(file.getAbsolutePath());
            }

            if (file.isDirectory()) {
                list.addAll(searchRecursive(file.getAbsolutePath()));
            }
        }

        return list;
    }

    public static List<String> searchByName(String name, String path) {
        List<String> toReturn = new ArrayList<>();
        List<String> list = searchRecursive(path);
        for (String s : list) {
            String[] namesInPath = s.split(File.separator);
            if (name.equals(namesInPath[namesInPath.length - 1])) {
                toReturn.add(s);
            }
        }

        return toReturn;
    }

    public static void main(String[] args) {
        List<String> list;
        list = searchByName("time_recording.adoc", "/Users/xiangyu/Projects");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
