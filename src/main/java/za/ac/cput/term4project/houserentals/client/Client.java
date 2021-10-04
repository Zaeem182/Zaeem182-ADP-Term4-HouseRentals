/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class Client 
{
    
    private Socket server;
    
    public Client() 
    {
        //Establish connection
        try 
        {
            //Create Socket

            server = new Socket("127.0.0.1", 12345);
            
        }
        catch (IOException ioe) 
        {
            System.out.println("IOException: " + ioe.getMessage());
        }
    }
    
    public void communicate()
    {
        try{
        ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());
        }
        catch(IOException ex)
        {   
            System.out.println("IOExeption: "+ ex.getMessage());
        }
        
    }
    
}
