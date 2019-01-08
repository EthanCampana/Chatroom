/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatroom;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ecampana
 */
public class ServerThread implements Runnable  {

    Socket incoming = null;
    int count;
    PrintWriter write;
    PrintWriter out;
    String linein;
    InputStream inStream;
    OutputStream outStream;
    BufferedReader in;
    
     ServerThread(Socket incoming, int count, String linein) throws IOException{
         this.count = count;
         this.incoming = incoming;
         this.linein = linein;
      inStream = incoming.getInputStream();
       outStream = incoming.getOutputStream();                   
         out = new PrintWriter(outStream,true);
        write = new PrintWriter(new FileWriter("log.txt",true));
        in = new BufferedReader(new InputStreamReader(inStream));
     }
    
    
  
    @Override
    public void run() {
        out.println("Hello you are client #" + count);
        while(true){
            try {
                linein = in.readLine();
                if(linein.equals("Bye")){
                this.incoming.close();
                break;                 
                }
                System.out.println(linein.trim());
                write.println(linein.trim());
                write.flush();
                for(ServerThread mc : Chatroom.ar){
                mc.out.println(linein.trim());
                }
                
           
            
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
    
}
