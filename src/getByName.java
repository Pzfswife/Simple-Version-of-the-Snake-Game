import java.net.InetAddress;
import java.net.UnknownHostException;

public class getByName {
  public static void main(String[] args)throws Exception{
    if(args.length==0)return;
    String h=args[0];
    try{
        InetAddress a=InetAddress.getByName(h);
        System.out.println(a);
    }catch(UnknownHostException el){
        el.printStackTrace();
    }
  }
}