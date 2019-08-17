import java.io.*;
import java.net.*;

class Client 
{
	public static void main(String[] args)throws Exception 
	{
		System.out.println("Hello World!");

		//creat client socket...
		Socket s = new Socket("localhost",2025);

		//to send data to server...
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		InputStream  is = s.getInputStream();
		OutputStream os = s.getOutputStream();

		//to read data coming from the sever ...
		BufferedReader br = new BufferedReader (new InputStreamReader(is));

		//to read data from the keyboard...
		BufferedReader kb = new BufferedReader (new InputStreamReader(System.in));

		String str,str1;
		//reapeat as long as exit is not typed by client...

		while( ! (str = kb.readLine()).equals("stop"))
		{
			dos.writeBytes(str+"\n");    //send to server...
			str1 = br.readLine();        //recive from the server...
			System.out.println(str1);
		}
		//close connections...
		dos.close();
		br.close();
		kb.close();
		s.close();
	}
}
