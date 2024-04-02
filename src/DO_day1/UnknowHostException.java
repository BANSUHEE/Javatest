package DO_day1;
import java.net.*;

public class UnknowHostException {
   
   public static void main(String[] args)
      throws UnknownHostException { //InetAddress 이용시 반드시예외처리.
      
      InetAddress iaddr= InetAddress.getLocalHost();
      System.out.printf("호스트 이름 : %s %n", iaddr.getHostName()); //IP 주소에 해당하는 호스트 이름을 반환합니다.
      System.out.printf("호스트 IP주소 : %s %n", iaddr.getHostAddress()); //IP 주소를 문자열로 반환합니다.
      //
      iaddr = InetAddress.getByName("java.sun.com");
      System.out.printf("호스트 이름 : %s %n", iaddr.getHostName());
      System.out.printf("호스트 IP주소 : %s %n", iaddr.getHostAddress());
      
        InetAddress sw[] = InetAddress.getAllByName("www.naver.com");
        for (InetAddress temp_sw : sw) {
            System.out.printf("호스트 이름 : %s %n", 
                  temp_sw.getHostName());
            System.out.printf("호스트 IP주소 : %s %n", 
                  temp_sw.getHostAddress());
            //경로 형태 : protocol . host. port. path.(데이터) query. relerence
            //get : URL 경로에 정보가 보인다. 
            //URL 클래스는 finsl로 상속이 안된다.
        }
   }
}