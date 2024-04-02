//2
package DO_day1;
import java.net.*;

public class ServerExample4 {
	
	    public static void main(String[] args) {
	        ServerSocket serverSocket = null;
	        try {
	            serverSocket = new ServerSocket(9002);
	            while (true) {
	                Socket socket = serverSocket.accept(); //socket = 각각의 클라이언트에 제공
	                Thread thread = new PerClinetThread(socket);//클라이언트가 접속+생성할 때마다 반복문 실행
	                thread.start(); //서버측에서 준 socket 을 thread 에 담아서 관리
	            }
	        }
	        catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}

