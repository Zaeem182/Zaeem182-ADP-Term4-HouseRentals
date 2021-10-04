/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class Server {
    
     //serversocket
    private ServerSocket listener;
    
    //Client connection
    private Socket client;
    
    public Server()
    {
        
        //Create server socket
        try
        {

            //(port number, max amount that can connect to server)
            listener = new ServerSocket(12345, 10);
        }
         catch (IOException ex) {
             System.out.println("IOExeption: " + ex.getMessage());
        }
    
    }
    
    public void listen() 
    {
        //Start listening for client connections
        
        try
        {
            System.out.println("Server is listening");
            client = listener.accept();
            System.out.println("Server moving to processClient");
            
            processClient();
        }
        catch(IOException ex)
        {
            System.out.println("IOExeption: " + ex.getMessage());
        }
        
        
         
        }
    public void processClient(){
        //communicate with the client 

        //initiate channels
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

        //communicate (if statements to add data)


        }
        catch(IOException ioe)
        {
            System.out.println("IOExeption: " + ioe.getMessage());
        }
    }
    
    public static void main(String[] args) {
        //remove sqlException
        Server server = new Server();
        server.listen();
    }
}


