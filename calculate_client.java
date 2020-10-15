/*import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;*/
import java.io.*;
import java.net.*;
/*import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;*/
import java.util.Scanner;
  
public class calculate_client
{
    public static void main(String[] args) throws IOException
    {
        //InetAddress ip = InetAddress.getLocalHost();
		String ip = "192.168.137.1";
        int port = 4444;
        Scanner sc = new Scanner(System.in);
  
        
        Socket s = new Socket(ip, port);
  
        
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
  
        while (true)
        {
            
            // "operand1 operation operand2"
            System.out.print("Enter the equation in the form: ");
            System.out.println("'operand operator operand'");
  
            String inp = sc.nextLine();
  
            
  
            
            dos.writeUTF(inp);
		if (inp.equals("bye"))
                break;
  
            
            String ans = dis.readUTF();
            System.out.println("Answer=" + ans);
        }
    }
}