import java.net.InetAddress;
import java.net.UnknownHostException;

public class getLocalHost {
    public static void main(String[] args)throws Exception{
        try{
            InetAddress la=InetAddress.getLocalHost();
            System.out.println(la);
        }catch(UnknownHostException el){
            el.printStackTrace();
        }
    }
}
