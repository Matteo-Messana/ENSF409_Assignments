package inlab4;

import java.io.BufferedReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private ServerSocket serverSocket;
	private Socket aSocket;
	private ExecutorService pool;
	
	public Server(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			pool = Executors.newCachedThreadPool();
		}
		catch (IOException e)
		{
			
		}
	}
	
	public void communicateWithClient() throws IOException
	{
		try {
			while(true)
			{
				Player xPlayer = new Player(serverSocket.accept(), 'X');
				Player oPlayer = new Player(serverSocket.accept(), 'O');
				
				Referee theRef = new Referee();
				
				theRef.setoPlayer(oPlayer);
				theRef.setxPlayer(xPlayer);
				
				Game theGame = new Game();
				theGame.appointReferee(theRef);
				
				System.out.println("Started a game.");
				
				pool.execute(theGame);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			pool.shutdown();
		}
		
	}
	
	public static void main(String[] args) throws IOException
	{
		Server server = new Server(8099);
		System.out.println("Server is now running.");
		server.communicateWithClient();
	}

}
