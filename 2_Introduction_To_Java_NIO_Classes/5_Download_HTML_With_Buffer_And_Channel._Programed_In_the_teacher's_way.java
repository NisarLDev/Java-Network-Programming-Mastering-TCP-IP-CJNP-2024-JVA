import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main{
    private static ByteBuffer buffer;

    public static void main(String[] args) {
        try{
            URL url_= new URL(spec: "https://ocsaly.com");
            URLConnection urlConnection = url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
            ByteBuffer buffer = ByteBuffer.alocate(capacity: 64);
            
            String line = null;
            while (readableByteChannel.read(buffer) > 0){
                System.out.println(new String(buffer.array()));
                buffer.clear();
            }
            readableByteChannel.close();

        }  catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        };
    };
};