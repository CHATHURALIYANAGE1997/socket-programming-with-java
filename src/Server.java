import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception{
		
		String req;
		String res;

		System.out.println("Waite for client request!");
		
		ServerSocket newsoc= new ServerSocket(9806);
		
		while (true){
			//accept client request
			Socket con=newsoc.accept();
			
			System.out.println("connected!");
			
			System.out.println("Getting Client Data");
			
			BufferedReader client=new BufferedReader(new InputStreamReader(con.getInputStream())); 
			
			DataOutputStream outToClinet= new DataOutputStream(con.getOutputStream());
			
			req=client.readLine();
			
			res=req.toUpperCase()+'\n';
			
			outToClinet.writeBytes(res );
			
		}
	}

}
