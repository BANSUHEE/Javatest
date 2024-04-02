//1  메신저를 입력할 창.
package DO_day1;
import java.io.*; 
import java.net.*; 

public class EchoClient {
	private String ip; 
	private int port; 
	private String str; 
	BufferedReader file; 
	public EchoClient(String ip, int port) throws IOException { 
		//throw 선언된 메서드는 예외를 직접 처리하지 않고, 호출한 쪽으로 예외를 던져서 처리
		this.ip = ip; 
		this.port = port; 
		Socket tcpSocket = getSocket(); 
		OutputStream os_socket = tcpSocket.getOutputStream(); 
		InputStream is_socket = tcpSocket.getInputStream(); 

		BufferedWriter bufferW = new BufferedWriter( //out,input 응답을 줄 준비완료 !
				new OutputStreamWriter(os_socket)); 
		BufferedReader bufferR = new BufferedReader( 
				new InputStreamReader(is_socket)); 
		System.out.print("입력 : "); 
		file = new BufferedReader( 
				new InputStreamReader(System.in)); 
		str = file.readLine(); 
		str += System.getProperty("line.separator"); 
		bufferW.write(str); 
		bufferW.flush(); 
		str = bufferR.readLine(); 
		System.out.println("Echo Result :" + str); 

		file.close(); 
		bufferW.close(); 





		bufferR.close(); 
		tcpSocket.close(); 
	} 
	public Socket getSocket() { 
		Socket tcpSocket = null; 
		try { 
			tcpSocket = new Socket(ip, port); //socket 이 메신저를 전달해줌.
		} catch (IOException ioe) { 
			ioe.printStackTrace(); 
			System.exit(0); 
		} 
		return tcpSocket; 
	} 
	public static void main(String[] args) throws IOException { 
		new EchoClient("192.168.0.70", 3000); //상대방 서버 입력하기 
	} 
} 


