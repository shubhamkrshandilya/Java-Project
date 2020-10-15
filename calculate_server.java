import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;
  
public class calculate_server
{
    public static void main(String args[]) throws IOException
    {
  
        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();
  
        
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
  
        while (true)
        {
            
            String input = dis.readUTF();
  
            if(input.equals("bye")){

                break;
			}
  
            System.out.println("Equation received:-" + input);
            int result = 0;
  
            
            StringTokenizer st = new StringTokenizer(input);
  
            int oprnd1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int oprnd2 = Integer.parseInt(st.nextToken());
			boolean opcheck = true;
           
            if (operation.equals("+"))
            {
                result = oprnd1 + oprnd2;
            }
  
            else if (operation.equals("-"))
            {
                result = oprnd1 - oprnd2;
            }
            else if (operation.equals("*"))
            {
                result = oprnd1 * oprnd2;
            }
            else if (operation.equals("/"))
            {
                result = oprnd1 / oprnd2;
            }
			else
			{
				opcheck = false;
			}
            System.out.println("Sending the result...");
  
			if(opcheck)
			{
				dos.writeUTF(Integer.toString(result));
			}
			else
			{
				dos.writeUTF("enter the equation in correct format");
			}
        }
    }
}