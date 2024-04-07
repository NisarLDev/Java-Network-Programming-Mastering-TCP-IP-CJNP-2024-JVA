import java.io.IOException;
import java.net.URL;

public class Main{
    public static void main(String[] args) throws IOException{
        try{
            URL url_= new URL("https://ocsaly.com");
            URLConnection myUrlConnetion = url.openConnection();
            BufferReader br = new BufferReader(new InputStreamReader(myUrlConnection.getInputStream()));
            String myLine;
            while ((myLine = br.readline()) != null){
                System.out.println(myLine);
            };
            br.close();
        }  catch (IOException exception) {
            System.out.println(exception.getMessage());
        };
    };
};