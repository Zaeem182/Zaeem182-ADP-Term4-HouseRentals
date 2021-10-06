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
import za.ac.cput.term4project.houserentals.dao.CustomerDao;
import za.ac.cput.term4project.houserentals.domain.Customer;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class Server {

    //Instantiate DAO part 1
    CustomerDao customerDao;

    //serversocket
    private ServerSocket listener;

    //Client connection
    private Socket client;

    public Server() {

        try {
            //instantiate DAO part 2
            this.customerDao = new CustomerDao();

            //Create server socket
            //(port number, max amount that can connect to server)
            listener = new ServerSocket(12345, 10);
        } catch (IOException ex) {
            System.out.println("IOExeption: " + ex.getMessage());
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
        }

    }

    public void listen() {
        //Start listening for client connections

        try {
            System.out.println("Server is listening");
            client = listener.accept();
            System.out.println("Server moving to processClient");

            processClient();
        } catch (IOException ex) {
            System.out.println("IOExeption: " + ex.getMessage());
        }

    }

    public void processClient() {
        //communicate with the client 

        //initiate channels
        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            while (true) {
                //communicate (if statements to add data)
                String msg = (String) in.readObject();

                if (msg.equals("ADD")) {
                    Integer id = (Integer) in.readInt();
                    String fName = (String) in.readObject();
                    String lName = (String) in.readObject();
                    String phoneNum = (String) in.readObject();
                    boolean canRent = (boolean) in.readBoolean();

                    //DAO Part
                    Customer customer = new Customer(id, fName, lName, phoneNum, canRent);

                    Customer cDaoAdd = customerDao.add(customer);

                    if (cDaoAdd.equals(customer)) {
                        out.writeObject("Data has been added!");
                    }
                }
            }

        } catch (IOException ioe) {
            System.out.println("IOExeption: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException: " + cnfe.getMessage());
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.listen();
    }
}
