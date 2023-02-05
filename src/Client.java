import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		
		String req1;
		String res1;
		
		BufferedReader inFormUser= new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket =new Socket("localhost",9806);
		
		System.out.println("Enter String: ");
		
		DataOutputStream outToServer= new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		req1=inFormUser.readLine();	
		
		outToServer.writeBytes(req1+'\n');
		
		res1=inFromServer.readLine();
		
		System.out.println("Server Res:"+res1);
		
		clientSocket.close();
		
	}

}
