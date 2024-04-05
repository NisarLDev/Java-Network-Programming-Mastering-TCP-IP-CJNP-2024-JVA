import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main{
    public static void main(String[] args) throws UnknownHostException{
        InetAddress ocsalyWebsite = InetAddress.getByName(host: "www.ocsaly.com");
        System.out.println(ocsalyWebsite);
    };
};