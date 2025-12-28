import java.net.InetAddress;
import java.net.UnknownHostException;

public class getHostAddress {
    public static void main(String[] args)throws Exception{
      try{
          InetAddress ad=InetAddress.getByName(args[0]);
          System.out.println("IP地址为："+ad.getHostAddress());
      }catch(UnknownHostException el){
          el.printStackTrace();
      }
    }
}
