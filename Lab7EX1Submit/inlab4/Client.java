package inlab4;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.Socket;

	public class Client {
		private PrintWriter socketOut;
		private Socket palinSocket;
		private BufferedReader stdIn;
		private BufferedReader socketIn;

		/**
		 * Constructor for client
		 * @param serverName: server name 
		 * @param portNumber: port number to connect to server
		 */
		public Client(String serverName, int portNumber) {
			try {
				palinSocket = new Socket(serverName, portNumber);
				stdIn = new BufferedReader(new InputStreamReader(System.in));
				socketIn = new BufferedReader(new InputStreamReader(palinSocket.getInputStream()));
				socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
				System.out.println("Player Connected! Waiting for Opponent...");
			} catch (IOException e) {
				System.err.println("error in client!" + e.getStackTrace());
			}
		}

		/**
		 * communicate with the server
		 */
		public void communicateServer()  {

			try {
				while (true) 
				{
					//Read and Print anything received by the server (null character marks the end of a reading.)
					String read = "";
					while(true) 
					{
						read = socketIn.readLine();
						if(read.contains("\0"))
						{
							read = read.replace("\0", "");
							System.out.println(read);
							break;
						}
						
						//When the game is finished, break out both nested loops
						if(read.contentEquals("Quit"))
						{
							return; // execute finally block before returning
						}
						System.out.println(read);
					}
					
					// read input form the user and send it to the server
					read = stdIn.readLine();
					socketOut.println(read);
					socketOut.flush();
				}
			}
			catch(IOException e)
			{
				
			}
		}

		public static void main(String[] args) throws IOException  {
			Client aClient = new Client("localhost", 8099);
			aClient.communicateServer();
		}
}
