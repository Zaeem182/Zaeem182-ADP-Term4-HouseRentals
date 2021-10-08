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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.cput.term4project.houserentals.dao.CustomerDao;
import za.ac.cput.term4project.houserentals.dao.EmployersDao;
import za.ac.cput.term4project.houserentals.dao.HousesDao;
import za.ac.cput.term4project.houserentals.dao.RentalsDao;
import za.ac.cput.term4project.houserentals.domain.Customer;
import za.ac.cput.term4project.houserentals.domain.Employers;
import za.ac.cput.term4project.houserentals.domain.House;
import za.ac.cput.term4project.houserentals.domain.Rental;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class Server {

    //Instantiate DAO part 1
    CustomerDao customerDao;
    EmployersDao employerDao;
    HousesDao houseDao;
    RentalsDao rentalDao;

    //serversocket
    private ServerSocket listener;

    //Client connection
    private Socket client;

    public Server() {

        try {
            //instantiate DAO part 2
            this.customerDao = new CustomerDao();
            this.employerDao = new EmployersDao();
            this.houseDao = new HousesDao();
            this.rentalDao = new RentalsDao();

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
                System.out.println("1");
                if (msg.equals("Add Customer")) {
                    System.out.println("2");
                    Integer id = (Integer) in.readInt();
                    System.out.println("3");
                    String fName = (String) in.readObject();
                    System.out.println("4");
                    String lName = (String) in.readObject();
                    System.out.println("5");
                    String phoneNum = (String) in.readObject();
                    System.out.println("6");
                    boolean canRent = (boolean) in.readBoolean();
                    System.out.println("7");

                    //DAO Part
                    Customer customer = new Customer(id, fName, lName, phoneNum, canRent);
                    System.out.println("8");
                    Customer cDaoAdd = customerDao.add(customer);

                    if (cDaoAdd.equals(customer)) {
                        out.writeObject("Data has been added!");
                    }
                }
                
                if (msg.equals("Add Employee")){
                    Integer id = (Integer) in.readInt();
                    String fName = (String) in.readObject();
                    String lName = (String) in.readObject();
                    boolean isAdmin = (boolean) in.readBoolean();
                    boolean isActive = (boolean) in.readBoolean();
                    
                    //Dao
                    Employers employer = new Employers(id, fName, lName, isActive, isAdmin);
                    
                    Employers eDaoAdd = employerDao.add(employer);
                    
                    if(eDaoAdd.equals(employer)){
                        out.writeObject("Data has been added!");
                    }
                    
                }
                
                if (msg.equals("Add House")) {
                    Integer id = (Integer) in.readInt();
                    String noOfRooms = (String) in.readObject();
                    String location = (String) in.readObject();
                    Double price = (Double) in.readDouble();
                    boolean isRent = (boolean) in.readBoolean();
                    
                    //Dao
                    House house = new House(id, noOfRooms, location, price, isRent);
                    
                    House hDaoAdd = houseDao.add(house);
                    
                    if(hDaoAdd.equals(house)){
                        out.writeObject("Data has been added!");
                    }
                }
                
                System.out.println("1");
                if (msg.equals("Add Rental")) {
                    System.out.println("2");
                    int id = (int) in.readInt();
                    System.out.println("3");
                    Date date = (Date) in.readObject();
                    System.out.println("4");
                    int customerId = (int) in.readInt();
                    int houseId = (int) in.readInt();
                    
                    //Dao
                    Rental rental = new Rental(id, customerId, houseId, date);
                    
                    Rental rDaoAdd = rentalDao.add(rental);
                    
                    if(rDaoAdd.equals(rental)){
                        out.writeObject("Data has been added!");
                    }
                }
                
                if (msg.equals("refreshCustomer")){
                    ArrayList<Customer> customerList = new ArrayList<>();
                    customerList = (ArrayList<Customer>) customerDao.getAll();
                    
                    out.writeObject(customerList);
                    
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
