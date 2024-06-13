import com.google.common.base.Splitter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Counter {
    private File singleToRead;
    private List<File> multipleToRead;
    public void setSingleToRead(File f){
        this.multipleToRead = new ArrayList<File>();
        this.multipleToRead.add(f);
    }
    public void setMultipleToRead(List<File> multiple){
        this.multipleToRead = multiple;
    }

    public long count() throws IOException {
        long count = 0;
        for(File singleFile : multipleToRead){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(singleFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(reader.ready()){
                String line = reader.readLine();
                List<String> words = Splitter.on(' ').splitToList(line);
                count += words.size();
            }
        }

        return count;
    }

}
