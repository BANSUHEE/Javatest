package Sd_Thread;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	static List<PrintWriter> clientWriters = Collections.synchronizedList(new ArrayList<PrintWriter>());

	static class ClientThread extends Thread {
		Socket socket;
		PrintWriter writer;
		String id;
		
		ClientThread(Socket socket) {
			this.socket = socket;
			try {
				writer = new PrintWriter(socket.getOutputStream());
				clientWriters.add(writer);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                id = reader.readLine();
                sendToAll("#w"+ id + "님이 들어오셨습니다");

                String message;
                while ((message = reader.readLine()) != null) {
                    sendToAll(id + ">" + message);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                clientWriters.remove(writer);
                sendToAll("#" + id + "님이 나가셨습니다");
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


		//메서드는 전달받은 메시지를 서버에 연결된 모든 클라이언트에게 전송하는 기능
		private static void sendToAll(String message) {
			synchronized (clientWriters) {
				for (PrintWriter writer : clientWriters) {
					writer.println(message);
					writer.flush();
				}
			}
		}

		private static void sendToClient(String message, PrintWriter writer) {
			writer.println(message);
			writer.flush();
		}


		public static void main(String[] args) {
			try {
				ServerSocket serverSocket = new ServerSocket(9002);
				while (true) {
					Socket socket = serverSocket.accept();
					Thread clientThread = new ClientThread(socket);
					clientThread.start();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
