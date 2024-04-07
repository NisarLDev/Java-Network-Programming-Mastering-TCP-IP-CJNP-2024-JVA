import java.net.URI;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.IOException;
import java.nio.*;
import java.util.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main{
    private static ByteBuffer buffer;

    public static void main(String[] args) {
        int capacity = 64;
        try{
            var url = URI.create("https://ocsaly.com").toURL();
            URLConnection urlConnection = url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
            ByteBuffer buffer = ByteBuffer.allocate(capacity);

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