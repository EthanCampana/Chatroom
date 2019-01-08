/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ethan
 */
public class PersonClient {
    
    private Socket s = new Socket();
    
    
    public Socket connect() throws IOException{
        
        Socket x = new Socket("127.0.0.1",8189);
        
        this.s = x;
       
        return s;
        
    }
    
    public String listen() throws IOException{
    
     InputStream inStream = s.getInputStream();
      Scanner in = new Scanner(inStream);
      String intext = in.nextLine();
      return intext;
        
    }
    
    public void send(String mesg) throws IOException{
    
        OutputStream OutStream = s.getOutputStream();
        PrintWriter out = new PrintWriter(OutStream,true);
        out.println(mesg);
        
    
    
    }
    
    public void close() throws IOException{
    s.close();
    
    }
    
  
    
}
