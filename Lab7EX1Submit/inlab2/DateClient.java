package inlab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DateClient {
	private PrintWriter socketOut;
	private Socket palinSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;
	
	/**
	 * Constructor for DateClient
	 * @param serverName: contains name of server.
	 * @param portNumber: contains port number to connect to server with.
	 */
	public DateClient(String serverName, int portNumber) {
		try {
			palinSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(
					palinSocket.getInputStream()));
			socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	/**
	 * communication function to communicate with the server
	 */
	public void communicate()  {
		String line = "";
		String response = "";
		boolean running = true;
		while (running) {
			try {
				System.out.println("please select an option (DATE/TIME) ");
				line = stdIn.readLine();
				if (!line.equals("QUIT")){
					line=line.toUpperCase();
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);						
				}else{
					running = false;
				}
				
			} catch (IOException e) {
				System.out.println("Sending error: " + e.getMessage());
			}
		}
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException  {
		DateClient aClient = new DateClient("localhost", 9090);
		aClient.communicate();
	}
}
