import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        if(args.length == 0){
            counter.setSingleToRead(new File("123.txt"));
        }
        else{
            List<File> multiple = new ArrayList<File>();
            for(String filePaths : args){
                multiple.add(new File(filePaths));
            }
            counter.setMultipleToRead(multiple);
        }
        try {
            System.out.println(counter.count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
