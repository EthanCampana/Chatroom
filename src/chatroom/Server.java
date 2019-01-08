/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int Port; 
    ServerSocket s;
    static Vector<ServerThread> ar = new Vector<>();
    
    public Server(int Port) throws IOException {
        this.Port = Port;
        s = new ServerSocket(Port);
    }
    
    public void start(){      
         try
        {
            //Creates Server on this Socket
            boolean over = false;
            String linein = "Please Begin the Chat!";
            int count = 0;
            ExecutorService pool = null;
            pool = Executors.newFixedThreadPool(5);
            
            while(!over)
            {
                Socket incoming = s.accept();
                count++;
                ServerThread runnable = new ServerThread(incoming,count,linein);
                ar.add(runnable);
                pool.execute(runnable);
 
                }
                
            }
        
        catch(Exception exc2)
        {
            exc2.printStackTrace();
        }
        
        
        
       
        
    }
    
    
    }
    
    
