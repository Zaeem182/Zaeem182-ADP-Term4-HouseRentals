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
                
                //////////////////////////ADD //////////////////////////////////
                
                if (msg.equals("Add Customer")) {
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
                        out.flush();
                        
                    }
                    else
                        out.writeObject("Data has not been added :(");
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
                        out.flush();
                    }
                    else
                        out.writeObject("Data has not been added :(");
                    
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
                        out.flush();
                    }
                    else
                        out.writeObject("Data has not been added :(");
                }

                if (msg.equals("Add Rental")) {
                    int id = (int) in.readInt();
                    Date date = (Date) in.readObject();
                    int customerId = (int) in.readInt();
                    int houseId = (int) in.readInt();
                    double commission = (double) in.readDouble();
                    
                    commission = commission * 0.1;
                    //Dao
                    Rental rental = new Rental(id, customerId, houseId, date, commission);
                    
                    Rental rDaoAdd = rentalDao.add(rental);
                    
                    if(rDaoAdd.equals(rental)){
                        out.writeObject("Data has been added!");
                        out.flush();
                    }
                    else
                        out.writeObject("Data has not been added :(");
                }
                
                /////////////////////////LOGINS/////////////////////////////
                                
                if(msg.equals("Agent Login")){
                
                    Integer id = (Integer) in.readInt();
                    String LastName =(String) in.readObject();
                    
                    //Dao
                    Employers employee = new Employers(id, LastName);
                    
                    Boolean eDaoCheckLogin = employerDao.employeeLogin(employee);
                    
                    if(eDaoCheckLogin == true)
                    {
                        out.writeObject("Login as agent Successful!");
                    }
                    else
                    {
                    out.writeObject("Wrong credidentials! try again");
                    
                    }
                }
                
                if(msg.equals("Admin Login")){
                
                    Integer id = (Integer) in.readInt();
                    String LastName =(String) in.readObject();
                    
                    //Dao
                    Employers employee = new Employers(id, LastName);
                    
                    Boolean eDaoCheckLogin = employerDao.employeeAdminLogin(employee);
                    
                    if(eDaoCheckLogin == true)
                    {
                        out.writeObject("Login as Admin Successful!");
                    }
                    else
                    {
                    out.writeObject("Wrong credidentials! try again");
                    
                    }
                }
                
                ///////////////////////////REFRESH//////////////////////////
                
                if (msg.equals("refreshCustomer")){
                    ArrayList<Customer> customerList = new ArrayList<>();
                    customerList = (ArrayList<Customer>) customerDao.getAll();
                    
                    out.writeObject(customerList);
                    out.flush();
                    
                }
                
                if(msg.equals("refreshEmployee")){
                    ArrayList<Employers> employeeList = new ArrayList<>();
                    employeeList = (ArrayList<Employers>) employerDao.getAll();
                    
                    out.writeObject(employeeList);
                    out.flush();
                }
                
                if(msg.equals("refreshHouse")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                 
                if(msg.equals("refreshRental")){
                    ArrayList<Rental> rentalList = new ArrayList<>();
                    rentalList = (ArrayList<Rental>) rentalDao.getAll();
                    
                    out.writeObject(rentalList);
                    out.flush();
                }
                
                if(msg.equals("refreshCommissionTotal")){
                    ArrayList<Rental> rentalList = new ArrayList<>();
                    rentalList = (ArrayList<Rental>) rentalDao.getCommissionAll();
                    
                    out.writeObject(rentalList);
                    out.flush();
                }
                if(msg.equals("refreshCboHouseLocation")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getCboAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                if(msg.equals("refreshCboHouse")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                
                if(msg.equals("Camps Bay")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getCampsBayAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                 if(msg.equals("Constantia")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getConstantiaAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                  if(msg.equals("Clifton")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getCliftonAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                   if(msg.equals("Sea Point")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getSeaPointAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                   
                    if(msg.equals("Athlone")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getAthloneAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                       if(msg.equals("Wynberg")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getWynbergAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
               
                
                if(msg.equals("Available")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getFalseAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                
                if(msg.equals("Not Available")){
                    ArrayList<House> houseList = new ArrayList<>();
                    houseList = (ArrayList<House>) houseDao.getTrueAll();
                    
                    out.writeObject(houseList);
                    out.flush();
                }
                
                ///////////////////////////UPDATE/////////////////////////////////
                
                if(msg.equals("Update Customer")){
                    Integer id = (Integer) in.readInt();
                    boolean canRent = (boolean) in.readBoolean();

                    //DAO Part
                    Customer customer = new Customer(id, canRent);
                    Customer cDaoAdd = customerDao.update(customer);
                    
                    if (cDaoAdd.equals(customer)) {
                        out.writeObject("Data has been updated!");
                        out.flush();
                        
                    }
                }
                
                if(msg.equals("Update Employee")){
                    Integer id = (Integer) in.readInt();
                    boolean isActive = (boolean) in.readBoolean();
                    
                    //Dao
                    Employers employer = new Employers(id, isActive);
                    Employers eDaoAdd = employerDao.update(employer);
                    
                    if(eDaoAdd.equals(employer)){
                        out.writeObject("Data has been updated!");
                        out.flush();
                    }
                }
                
                if(msg.equals("Update House")){
                    Integer id = (Integer) in.readInt();
                    boolean isRent = (boolean) in.readBoolean();
                    
                    //Dao
                    House house = new House(id, isRent);
                    House hDaoAdd = houseDao.update(house);
                    
                    if(hDaoAdd.equals(house)){
                        out.writeObject("Data has been updated!");
                        out.flush();
                    }
                }
                
                if(msg.equals("EXIT")){
                    out.close();
                    in.close();
                    client.close();
                    System.out.println("server closed");
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
