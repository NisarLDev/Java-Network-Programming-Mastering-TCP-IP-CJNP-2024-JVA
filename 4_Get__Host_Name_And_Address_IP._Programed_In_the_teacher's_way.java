import java.net.InetAddress;
import java.io.IOException;
//import java.net.UnknownHostException;

public class Main{
    public static void main(String[] args) throws IOException{
        InetAddress ocsaly = InetAddress.getByName("www.startpage.com");
        System.out.println("HOST ADDRESS        : " + ocsaly.getHostAddress());
        System.out.println("CANONICAL HOST NAME : " + ocsaly.getCanonicalHostName());
        System.out.println("HOST NAME           : " + ocsaly.getHostName());
        ocsaly.isReachable(timeout: 10000);
    };
};
