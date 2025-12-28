import java.net.InetAddress;
import java.net.UnknownHostException;

public class getAllByName {
    public static void main(String[] args)throws Exception{
      if(args.length==0)return ;
      String host=args[0];
      try{
          InetAddress addresses[]=InetAddress.getAllByName(host);
          for(InetAddress address:addresses)System.out.println(address);
      }catch(UnknownHostException el) {
          el.printStackTrace();
      }
    }
}
