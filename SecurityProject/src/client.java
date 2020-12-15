import java.io.*; 
import java.net.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
//Büþra Yaþar 150114063
// Client class 
public class client { 
	
	public static void main(String[] args) throws IOException { 
		try{ 
			Scanner scn = new Scanner(System.in); 
			
			// getting localhost ip 
			InetAddress ip = InetAddress.getByName("localhost"); 
	
			// establish the connection with server port 5056 
			Socket clientsoc = new Socket(ip, 1234); 
			
			InputStream is = clientsoc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String receivedData = br.readLine();
            System.out.println("Received Data: " + receivedData);
	
			// obtaining input and out streams 
			DataInputStream dis = new DataInputStream(clientsoc.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(clientsoc.getOutputStream()); 
	
			// the following loop performs the exchange of 
			// information between client and client handler 
			
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.print("(Client say) Enter your username: ");
			String uname = reader.nextLine(); // Scans the next token of the input as an int.
			System.out.println("(Client say) Welcome, " + uname + " :)");
//Each user should generate a public-private key pair once and register the server with her username and public key.
			 String PUBLIC_KEY_FILE =uname+"_Public_Key";
			 String PRIVATE_KEY_FILE=uname+"_Private_Key";
			
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
			
			System.out.println("(Client say) PUBLIC KEY OF USER :\n "+uname+"--> " +publickey);
			System.out.println("(Client say) PRIVATE KEY OF USER :\n "+uname+"--> "+ privatekey);
//----------------------------------------------------------------------------------------------------------------			
			

		
			while (true){ 
				//System.out.println(dis.readUTF()); 
				System.out.println("(Client say) write your message sent to server : ");
				String tosend = scn.nextLine(); 
				dos.writeUTF(" (Client say) to send message :"+tosend); 
				
				// If client sends exit,close this connection 
				// and then break from the while loop 
				if(tosend.equals("Exit")) { 
					System.out.println("(Client say) Closing this connection : " + clientsoc); 
					clientsoc.close();
					System.out.println("(Client say) Bye");
					System.out.println("(Client say) Connection closed");
					break; 
				} 
				
				// printing date or time as requested by client 
				String received = dis.readLine(); 
				System.out.println("(Client say) "+ received); 
			} 
			
			// closing resources 
			scn.close(); 
			dis.close(); 
			dos.close(); 
			clientsoc.close();
			reader.close();
			
		}catch(Exception e){ 
			e.printStackTrace(); 
		} 
	} 
} 

