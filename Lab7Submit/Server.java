import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	PrintWriter out;
	Socket aSocket;
	ServerSocket serverSocket;
	BufferedReader in;
	
	private ExecutorService pool;

	public Server() { // throws IOException {
		try {
			serverSocket = new ServerSocket(8099);
			pool = Executors.newFixedThreadPool(2);
			
		} catch (IOException e) {
			System.out.println("Create new socket error");
			System.out.println(e.getMessage());
		}
		System.out.println("Server is running");
	}
	
	
	public void runServer() {
		try {
			while (true) {
				aSocket = serverSocket.accept();
				System.out.println("after accept");
				in = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
				out = new PrintWriter((aSocket.getOutputStream()), true);

				Palindrome pal = new Palindrome(in,out);
				
				
				pool.execute(pal);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
			// Stop accepting new games and finish any active ones, then shutdown the threadpool.
			pool.shutdown();
			try {
				in.close();
				out.close();
				aSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Server myserver = new Server();
		myserver.runServer();
	}
}
