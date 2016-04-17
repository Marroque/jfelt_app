package threads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client_Thread extends Thread {

	private Socket clientSocket;
	private InputStreamReader streamReader;
	private OutputStreamWriter streamWriter;
	private BufferedReader bufferedReader;
	private boolean execute;

	/**
	 * Constructor for the Client_Thread class that receives the socket and
	 * attempts to create the Input and Output streams for receiving and sending
	 * messages
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 * @param Socket
	 *            - Web socket of the client that enables the communication
	 * @throws
	 */
	public Client_Thread(Socket clientSocket) throws IOException {
		super("Server");
		this.execute = true;
		this.clientSocket = clientSocket;
		this.streamWriter = new OutputStreamWriter(
				clientSocket.getOutputStream());
		this.streamReader = new InputStreamReader(clientSocket.getInputStream());
		this.bufferedReader = new BufferedReader(streamReader); // get the
																// client
																// message
	}

	/**
	 * The thread listens for client communication attempts
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 */
	@Override
	public void run() {
		String message;
		System.out.println("Checking for messages");
		while (execute) {

			try {
				if (bufferedReader.ready()) {
					message = bufferedReader.readLine();
					System.out.println(message);
				}
			} catch (IOException e) {
				execute = false;
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			streamReader.close();
			streamWriter.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * attempts to sends a message to the client
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 * @param message
	 *            - message to be sent
	 * @return True if the message was send successfully and false otherwise
	 */
	public boolean sendMessage(String message) {
		BufferedWriter bufferWriter = new BufferedWriter(streamWriter);
		try {
			bufferWriter.write(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Ends the communication with the client and finishes the thread
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-16
	 */
	public void endConnection() {
		this.execute = false;
	}

}
