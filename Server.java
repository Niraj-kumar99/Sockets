import java.io.*;
import java.net.*;


class Server 
{
	public static void main(String[] args)throws Exception 
	{
		System.out.println("Hello World!");

		//creat server socket...
		ServerSocket ss = new ServerSocket(2025);
		System.out.println("The SERVER Is Ready For Connection");
        
		//connect it to client socket...
		Socket s = ss.accept();
		System.out.println("Server IS READY FOR CHAT");

		InputStream  is = s.getInputStream();
		OutputStream os = s.getOutputStream();
        

		//to read data coming from the client ...
		BufferedReader brs = new BufferedReader (new InputStreamReader(is));

		//to read data from the keyboard...
		BufferedReader brk = new BufferedReader (new InputStreamReader(System.in));


		//to send data to the client...
		PrintStream ps = new PrintStream(s.getOutputStream());
        

		//server executes continiously...
		while(true)
		{
			String str,str1;
			//repeat as long as the client doesn't send STOP....
			while( (str = brs.readLine()) != ("stop"))     //read from client...
			{
				System.out.println(str);
				str1 = brk.readLine();
				ps.println(str1);           //send to client
			}
			//close connection...
			ps.close();
			brs.close();
			brk.close();
			ss.close();
			s.close();
		}         //end os 1st while...

	}
}
