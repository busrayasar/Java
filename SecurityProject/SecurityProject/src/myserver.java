// Java implementation of Server side 
// It contains two classes : Server and ClientHandler 
// Save file as Server.java 

import java.io.*; 
//import java.text.*; 
//import java.util.*; 
import java.net.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.net.*; 
//Büþra Yaþar 150114063

// Server class 
public class myserver{ 
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException { 
		
//-------Server private public key ---------------------------
		 String PUBLIC_KEY_FILE ="Server_Public_Key";
		 String PRIVATE_KEY_FILE="Server_Private_Key";
		
		KeyPairGenerator keypairgenerator=KeyPairGenerator.getInstance("RSA");
		keypairgenerator.initialize(2048); //2048 key size can be  used 
		KeyPair keypair=keypairgenerator.generateKeyPair();
		//store public key
		PublicKey publickey=keypair.getPublic(); //generates an RSA public key KA+
		
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publickey.getEncoded());
		FileOutputStream fos = new FileOutputStream(PUBLIC_KEY_FILE );
		fos.write(x509EncodedKeySpec.getEncoded());
		fos.close();
		// Store Private Key.
		PrivateKey privatekey=keypair.getPrivate();//generates an RSA private key KA-
		
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privatekey.getEncoded());
		FileOutputStream fos2 = new FileOutputStream(PRIVATE_KEY_FILE );
		fos2.write(pkcs8EncodedKeySpec.getEncoded());
		fos2.close();
		
		System.out.println("(Server say) PUBLIC KEY OF Server:\n--> " +publickey);
		System.out.println("(Server say) PRIVATE KEY OF Server :\n --> "+ privatekey);
		
//-----------------------------------------------------------------------------------		
		
		// server is listening on port 1234
		ServerSocket serversocket = new ServerSocket(8080); 
		
		// running infinite loop for getting 
		// client request 
		while (true){ 
			Socket client = serversocket.accept() ; //socket object
			
			//http://ibrahimbilge.com/java-socket-programlama/
				
			try
			{ 
				// socket object to receive incoming client requests 
				
				
				System.out.println("A new client is connected : " + client); 
				
				// obtaining input and out streams 
				DataInputStream dis = new DataInputStream(client.getInputStream()); 
				dis.readLine();
				DataOutputStream dos = new DataOutputStream(client.getOutputStream()); 
				dos.writeBytes("Hello Sockets I am in server \n");
				client.close();
				
				//System.out.println("Assigning new thread for this client"); 

				// create a new thread object 
				//Thread t = new ClientHandler(client, dis, dos); 

				// Invoking the start() method 
				//t.start(); 
				
			} 
			catch (Exception e){ 
				client.close(); 
				serversocket.close();
				e.printStackTrace(); 
			} 
		} 
	} 
} 

// ClientHandler class 
class ClientHandler extends Thread 
{ 
 
	final DataInputStream dis; 
	final DataOutputStream dos; 
	final Socket s; 
	

	// Constructor 
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) 
	{ 
		this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
	} 

	@Override
	public void run() 
	{ 
		String received; 
		String toreturn; 
		while (true){ 
			try { 

				// Ask user what he wants 
				dos.writeUTF("(Server asks:)What do you want? or enter 'Exit'	"); 
				
				// receive the answer from client 
				System.out.println("(Server) received:");
				received = dis.readUTF(); 
				System.out.println(  received);
		
				
				if(received.equals("Exit")) 
				{ 
					System.out.println("(Server say) Client " + this.s + " sends exit..."); 
					System.out.println("(Server say) Closing this connection."); 
					this.s.close(); 
					System.out.println("(Server say) Connection closed"); 
					break; 
				} 
				

				
				// write on output stream based on the 
				// answer from the client 
				 
				else if (received == "POST_IMAGE" ) { 
					toreturn = "posting image";
					System.out.println("(Server say)"+ toreturn);
					dos.writeUTF(""); 
				}
				else if (received == "DOWNLOAD" ) { 
					toreturn = "download image"; 
					System.out.println("(Server say) "+toreturn);
					dos.writeUTF("");  
				}
				else {
					dos.writeUTF(""); 
					System.out.println("(Server say) invalid image");
				}
					
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
		
		try
		{ 
			// closing resources 
			this.dis.close(); 
			this.dos.close(); 
			this.s.close();
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	} 
} 
