import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ScrawlerDemo {
    public static void main(String[] args) {
        try(BufferedReader is = new BufferedReader(new InputStreamReader(new URL("https://www.yandex.ru").openStream(),"UTF-8"))){
            String msg;
            while((msg = is.readLine()) != null){
                System.out.print(msg);
            }

        } catch(IOException e){
            System.out.println("IO Exception");
        }
    }
}
