/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import za.ac.cput.term4project.houserentals.client.Client;
import za.ac.cput.term4project.houserentals.domain.Customer;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class HouseGUI implements ActionListener {

    //client socket
    private Socket server;
    ObjectOutputStream out;
    ObjectInputStream in;

    //JPanels
    private JPanel panelTop;
    private JPanel panelCenter;
    private JPanel panelBottom;
    private JPanel panelLeft;

    //JLabel Heading
    private JLabel lblHeading;

    //JCheckBox
    private JCheckBox chkCanRent;

    //JButtons
    private JButton btnAdd;
    private JButton btnAdminAgent;
    private JButton btnHouses;
    private JButton btnCustomers;
    private JButton btnRentals;
    private JButton btnExit;

    //JComboboxes
    private JComboBox cboUser;

    //JTable
    private DefaultTableModel tblModel;
    private JTable tblDisplay;

    //Fonts
    private Font Hft;
    private Font ft;

    //JFrame
    JFrame frame = new JFrame();

    /////////////////////////////////////////////////////
    
    JFrame frame1 = new JFrame();
    //Jpanel for house table
    private JPanel panelHouseTop;
    private JPanel panelHouseCenter;
    private JPanel panelHouseBottom;

    private JButton btnHouseAdd;
    private JButton btnAdminAgent2;
    private JButton btnHouses2;
    private JButton btnCustomers2;
    private JButton btnRentals2;
    private JButton btnHouseExit;
    
    private DefaultTableModel tblHouseModel;
    private JTable tblHouseDisplay;
    
    /////////////////////////////////////////////////////
    //Jpanel for Rental table
   JFrame frame2 = new JFrame();
    private JPanel panelRentalTop;
    private JPanel panelRentalCenter;
    private JPanel panelRentalBottom;

    private JButton btnRentalAdd;
    private JButton btnAdminAgent3;
    private JButton btnHouses3;
    private JButton btnCustomers3;
    private JButton btnRentals3;
    private JButton btnRentalExit;
    
    private DefaultTableModel tblRentalModel;
    private JTable tblRentalDisplay;

    /////////////////////////////////////////////////////
    //Jpanel for Employee table
    JFrame frame3 = new JFrame();
    private JPanel panelEmployeeTop;
    private JPanel panelEmployeeCenter;
    private JPanel panelEmployeeBottom;

    private JButton btnEmployeeAdd;
    private JButton btnAdminAgent4;
    private JButton btnHouses4;
    private JButton btnCustomers4;
    private JButton btnRentals4;
    private JButton btnEmployeeExit;
    
    private DefaultTableModel tblEmployeeModel;
    private JTable tblEmployeeDisplay;
    
    public HouseGUI() {
        //Establish connection
        try {
            //Create Socket

            server = new Socket("127.0.0.1", 12345);
            out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            in = new ObjectInputStream(server.getInputStream());

        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        //Fonts
        Hft = new Font("Verdana", Font.BOLD, 25);
        ft = new Font("Verdana", Font.PLAIN, 20);

        //Top panel
        panelTop = new JPanel();

        //Center panel
        panelCenter = new JPanel();

        //Bottom panel
        panelBottom = new JPanel();

        //Left panel
        panelLeft = new JPanel();

        //Heading
        lblHeading = new JLabel("ZA RENTALS");

        //Checkbox input
        chkCanRent = new JCheckBox();

        //Buttons
        btnAdd = new JButton("Add Customer");
        btnAdminAgent = new JButton("EMPLOYEES");
        btnHouses = new JButton("HOUSES");
        btnCustomers = new JButton("CUSTOMERS");
        btnRentals = new JButton("RENTALS");
        btnExit = new JButton("EXIT");

        //ComboBox
        cboUser = new JComboBox();

        //Table
        tblModel = new DefaultTableModel();
        tblDisplay = new JTable(tblModel);
        
        
        
        /////////////////////////////////////////////////////
        //house panels
         panelHouseTop = new JPanel();
         panelHouseCenter = new JPanel();
         panelHouseBottom = new JPanel();
         
        btnHouseAdd = new JButton("Add House");
        btnAdminAgent2 = new JButton("EMPLOYEES");
        btnHouses2 = new JButton("HOUSES");
        btnCustomers2 = new JButton("CUSTOMERS");
        btnRentals2 = new JButton("RENTALS");
        btnHouseExit = new JButton("EXIT");
        
        btnHouseAdd.addActionListener(this);
        btnAdminAgent2.addActionListener(this);
        btnHouses2.addActionListener(this);
        btnCustomers2.addActionListener(this);
        btnRentals2.addActionListener(this);
        btnHouseExit.addActionListener(this);
        
        tblHouseModel = new DefaultTableModel();
        tblHouseDisplay = new JTable(tblHouseModel);
        
        /////////////////////////////////////////////////////
        //Rental panels
        panelRentalTop = new JPanel();
        panelRentalCenter = new JPanel();
        panelRentalBottom = new JPanel();
         
        btnRentalAdd = new JButton("Add Rental");
        btnAdminAgent3 = new JButton("EMPLOYEES");
        btnHouses3 = new JButton("HOUSES");
        btnCustomers3 = new JButton("CUSTOMERS");
        btnRentals3 = new JButton("RENTALS");
        btnRentalExit = new JButton("EXIT");
        
        btnRentalAdd.addActionListener(this);
        btnAdminAgent3.addActionListener(this);
        btnHouses3.addActionListener(this);
        btnCustomers3.addActionListener(this);
        btnRentals3.addActionListener(this);
        btnRentalExit.addActionListener(this);
        
        tblRentalModel = new DefaultTableModel();
        tblRentalDisplay = new JTable(tblRentalModel);
    
        /////////////////////////////////////////////////////
        //Employee panels
        panelEmployeeTop = new JPanel();
        panelEmployeeCenter = new JPanel();
        panelEmployeeBottom = new JPanel();
         
        btnEmployeeAdd = new JButton("Add Employee");
        btnAdminAgent4 = new JButton("EMPLOYEES");
        btnHouses4 = new JButton("HOUSES");
        btnCustomers4 = new JButton("CUSTOMERS");
        btnRentals4 = new JButton("RENTALS");
        btnEmployeeExit = new JButton("EXIT");
        
        btnEmployeeAdd.addActionListener(this);
        btnAdminAgent4.addActionListener(this);
        btnHouses4.addActionListener(this);
        btnCustomers4.addActionListener(this);
        btnRentals4.addActionListener(this);
        btnEmployeeExit.addActionListener(this);
        
        tblEmployeeModel = new DefaultTableModel();
        tblEmployeeDisplay = new JTable(tblEmployeeModel);
    }
    public void setHousePanels()
    {
        frame1.setVisible(false);
        frame.setVisible(false);
        frame3.setVisible(false);
        
         frame2.setVisible(true);
        
        
//        panelBottom.setVisible(false);
//        panelCenter.setVisible(false);
//        panelLeft.setVisible(false);
//        panelTop.setVisible(false);
//        
//        panelRentalCenter.setVisible(false);
//        panelRentalBottom.setVisible(false);
//        
//        panelEmployeeCenter.setVisible(false);
//        panelEmployeeBottom.setVisible(false);
//                
//        panelHouseCenter.setVisible(true);
//        panelHouseBottom.setVisible(true);
    }
    
    public void setRentalPanels()
    {   
        frame1.setVisible(false);
        frame.setVisible(false);
        frame2.setVisible(false);
        
         frame3.setVisible(true);
        
//        panelBottom.setVisible(false);
//        panelCenter.setVisible(false);
//        panelLeft.setVisible(false);
//        panelTop.setVisible(false);
//                
//        panelHouseCenter.setVisible(false);
//        panelHouseBottom.setVisible(false);
//        
//        panelEmployeeCenter.setVisible(false);
//        panelEmployeeBottom.setVisible(false);
//        
//        panelRentalCenter.setVisible(true);
//        panelRentalBottom.setVisible(true);
    }
    
     public void setEmployeePanels()
    {
        frame.setVisible(false);
        frame2.setVisible(false);
        frame3.setVisible(false);
        
         frame1.setVisible(true);
        
        
//        panelBottom.setVisible(false);
//        panelCenter.setVisible(false);
//        panelLeft.setVisible(false);
//        panelTop.setVisible(false);
//                
//        panelHouseCenter.setVisible(false);
//        panelHouseBottom.setVisible(false);
//        
//        panelRentalCenter.setVisible(false);
//        panelRentalBottom.setVisible(false);
//        
//        panelEmployeeCenter.setVisible(true);
//        panelEmployeeBottom.setVisible(true);
    }
    
    public void setCustomerPanels()
    {
       
        frame1.setVisible(false);
        frame2.setVisible(false);
        frame3.setVisible(false);
        
         frame.setVisible(true);
        
//        panelHouseCenter.setVisible(false);
//        panelHouseBottom.setVisible(false);
//        
//        panelRentalCenter.setVisible(false);
//        panelRentalBottom.setVisible(false);
//        
//        panelEmployeeCenter.setVisible(false);
//        panelEmployeeBottom.setVisible(false);
//        
//        panelBottom.setVisible(true);
//        panelCenter.setVisible(true);
//        panelLeft.setVisible(true);
//        panelTop.setVisible(true);
                
      
    }
    public void setGUI() {
        //Apply font change
        lblHeading.setFont(Hft);
        lblHeading.setForeground(new Color(0, 0, 0));

        //Add Top panel
        frame.add(panelTop, BorderLayout.NORTH);
        panelTop.setLayout(new GridLayout(1, 1));
        panelTop.setSize(300, 300);

        //Add Center panel
        frame.add(panelCenter, BorderLayout.CENTER);

        //Add Bottom panel
        frame.add(panelBottom, BorderLayout.SOUTH);
        panelBottom.setSize(300, 300);

        //Add Left panel
//        frame.add(panelLeft, BorderLayout.WEST);
//        panelLeft.setPreferredSize(new Dimension(150, 150));
        //Heading
        panelTop.add(lblHeading);

        //ComboBox
        panelTop.add(cboUser);
        cboUser.addItem("-no selection made-");

        //Buttons
        btnAdd.setPreferredSize(new Dimension(150, 50));
        btnAdminAgent.setPreferredSize(new Dimension(90, 40));
        btnHouses.setPreferredSize(new Dimension(90, 40));
        btnCustomers.setPreferredSize(new Dimension(90, 40));
        btnRentals.setPreferredSize(new Dimension(90, 40));
        btnExit.setPreferredSize(new Dimension(150, 50));

        //Button Colours
        btnAdd.setBackground(new Color(102, 178, 255));
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusPainted(false);
        btnAdd.setForeground(new Color(0, 0, 0));

        btnAdminAgent.setBackground(new Color(102, 178, 255));
        btnAdminAgent.setBorderPainted(false);
        btnAdminAgent.setFocusPainted(false);
        btnAdminAgent.setForeground(new Color(0, 0, 0));

        btnHouses.setBackground(new Color(102, 178, 255));
        btnHouses.setBorderPainted(false);
        btnHouses.setFocusPainted(false);
        btnHouses.setForeground(new Color(0, 0, 0));

        btnCustomers.setBackground(new Color(102, 178, 255));
        btnCustomers.setBorderPainted(false);
        btnCustomers.setFocusPainted(false);
        btnCustomers.setForeground(new Color(0, 0, 0));

        btnRentals.setBackground(new Color(102, 178, 255));
        btnRentals.setBorderPainted(false);
        btnRentals.setFocusPainted(false);
        btnRentals.setForeground(new Color(0, 0, 0));

        btnExit.setBackground(new Color(102, 178, 255));
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false);
        btnExit.setForeground(new Color(0, 0, 0));

        panelBottom.add(btnAdd);
        panelCenter.add(btnAdminAgent);
        panelCenter.add(btnHouses);
        panelCenter.add(btnCustomers);
        panelCenter.add(btnRentals);
        panelBottom.add(btnExit);

        
  
        
        //Panels Colours
        panelTop.setBackground(new Color(233, 160, 124));
        panelCenter.setBackground(new Color(233, 160, 124));
        panelBottom.setBackground(new Color(233, 160, 124));
        panelLeft.setBackground(new Color(233, 160, 124));

        chkCanRent.setBackground(new Color(233, 160, 124));

        //Add action listeners
        btnAdd.addActionListener(this);
        btnAdminAgent.addActionListener(this);
        btnHouses.addActionListener(this);
        btnCustomers.addActionListener(this);
        btnRentals.addActionListener(this);
        btnExit.addActionListener(this);

        //Add Table
        tblDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblModel.addColumn("ID");
        tblModel.addColumn("First Name");
        tblModel.addColumn("Last Name");
        tblModel.addColumn("Phone Number");
        tblModel.addColumn("Can Rent");

        panelCenter.add(new JScrollPane(tblDisplay));

        //Show on form
        frame.setSize(850, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

       
        
        ///////////////////////////////////////////////////////////////
        //Employee GUI
        frame1.add(panelEmployeeCenter,BorderLayout.CENTER);
        
        frame1.add(panelEmployeeBottom,BorderLayout.SOUTH);
        
        tblEmployeeDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEmployeeModel.addColumn("ID");
        tblEmployeeModel.addColumn("First Name");
        tblEmployeeModel.addColumn("Last Name");
        tblEmployeeModel.addColumn("Admin");
        tblEmployeeModel.addColumn("Active");

        panelEmployeeCenter.add(new JScrollPane(tblEmployeeDisplay));
        
        panelEmployeeCenter.add(btnEmployeeAdd);
        panelEmployeeCenter.add(btnAdminAgent4);
        panelEmployeeCenter.add(btnHouses4);
        panelEmployeeCenter.add(btnCustomers4);
        panelEmployeeCenter.add(btnRentals4);
        panelEmployeeBottom.add(btnEmployeeExit);
        
        frame1.setSize(900, 500);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(false);
        

        
//        panelEmployeeCenter.setVisible(false);
//        panelEmployeeBottom.setVisible(false);
        
         ////////////////////////////////////////////////////////////////
        //House GUI
        frame2.add(panelHouseCenter,BorderLayout.CENTER);
        
        
        frame2.add(panelHouseBottom,BorderLayout.SOUTH);
        
        tblHouseDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblHouseModel.addColumn("ID");
        tblHouseModel.addColumn("No. of Rooms");
        tblHouseModel.addColumn("Location");
        tblHouseModel.addColumn("Rent");

        panelHouseCenter.add(new JScrollPane(tblHouseDisplay));
        
        panelHouseCenter.add(btnHouseAdd);
        panelHouseCenter.add(btnAdminAgent2);
        panelHouseCenter.add(btnHouses2);
        panelHouseCenter.add(btnCustomers2);
        panelHouseCenter.add(btnRentals2);
        panelHouseBottom.add(btnHouseExit);
        
        frame2.setSize(900, 500);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(false);
        
//        panelHouseCenter.setVisible(false);
//        panelHouseBottom.setVisible(false);
        
        ///////////////////////////////////////////////////////////////
        //Rental GUI
        frame3.add(panelRentalCenter,BorderLayout.CENTER);
        
        frame3.add(panelRentalBottom,BorderLayout.SOUTH);
        
        tblRentalDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblRentalModel.addColumn("ID");
        tblRentalModel.addColumn("Date");
        tblRentalModel.addColumn("CustomerID");
        tblRentalModel.addColumn("HouseID");

        panelRentalCenter.add(new JScrollPane(tblRentalDisplay));
        
        panelRentalCenter.add(btnRentalAdd);
        panelRentalCenter.add(btnAdminAgent3);
        panelRentalCenter.add(btnHouses3);
        panelRentalCenter.add(btnCustomers3);
        panelRentalCenter.add(btnRentals3);
        panelRentalBottom.add(btnRentalExit);
        
        frame3.setSize(900, 500);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(false);
        
//        panelRentalCenter.setVisible(false);
//        panelRentalBottom.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //EXIT BUTTON
        if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);

        }
        //EMPLOYEES Button
        if (e.getActionCommand().equals("EMPLOYEES")) 
        {
            setEmployeePanels();
        }

        //Houses Button 
        if (e.getActionCommand().equals("HOUSES")) {
            
            setHousePanels();
        }
        
        //Customers Button
        if(e.getActionCommand().equals("CUSTOMERS"))
        {
            setCustomerPanels();
        }
        
        //Rental Button
        if(e.getActionCommand().equals("RENTALS"))
        {
            setRentalPanels();
        }
        
        //ADD Customer Button
        if (e.getActionCommand().equals("Add Customer")) {
            clientAddCustomerDetails();
        }
        //ADD Employee Button
        if (e.getActionCommand().equals("Add Employee")) {
            clientAddEmployeeDetails();
        }
        //ADD Rental Button
        if (e.getActionCommand().equals("Add Rental")) {
            clientAddRentalDetails();

        }
    }

    public void clientAddEmployeeDetails() throws NumberFormatException, HeadlessException {
        JTextField id = new JTextField();
        JTextField fName = new JTextField();
        JTextField lName = new JTextField();
        JCheckBox isAdmin = new JCheckBox();
        JCheckBox isActive = new JCheckBox();

        Object[] addFields
                = {
                    "ID:", id,
                    "First Name:", fName,
                    "Last Name:", lName,
                    "Check if employer is a Admin", isAdmin,
                    "Check if employer is active", isActive
                };
        JOptionPane.showConfirmDialog(null, addFields, "Add details", JOptionPane.OK_CANCEL_OPTION);

        try {
            out.writeObject("Add Employee");
            out.flush();

            out.writeInt(Integer.parseInt(id.getText()));
            out.flush();

            out.writeObject(fName.getText());
            out.flush();

            out.writeObject(lName.getText());
            out.flush();

            out.writeBoolean(isAdmin.isSelected());
            out.flush();

            out.writeBoolean(isActive.isSelected());
            out.flush();

            String response = (String) in.readObject();
            JOptionPane.showMessageDialog(null, response);

        } catch (IOException ex) {
            System.out.println("IOExeption: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
    }

    public void clientAddCustomerDetails() throws HeadlessException, NumberFormatException {
        JTextField id = new JTextField();
        JTextField fName = new JTextField();
        JTextField lName = new JTextField();
        JTextField phoneNum = new JTextField();
        JCheckBox canRent = new JCheckBox();

        Object[] addFields
                = {
                    "ID:", id,
                    "First Name:", fName,
                    "Last Name:", lName,
                    "Phone Number:", phoneNum,
                    "Can Rent:", canRent
                };

        int option;
        option = JOptionPane.showConfirmDialog(null, addFields, "Add details", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            if (id.getText().isEmpty() || fName.getText().isEmpty() || lName.getText().isEmpty() || phoneNum.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes!");

            }
        }

        try {

            out.writeObject("Add Customer");
            out.flush();

            out.writeInt(Integer.parseInt(id.getText()));
            out.flush();

            out.writeObject(fName.getText());
            out.flush();

            out.writeObject(lName.getText());
            out.flush();

            out.writeObject(phoneNum.getText());
            out.flush();

            out.writeBoolean(canRent.isSelected());
            out.flush();

            String response = (String) in.readObject();
            JOptionPane.showMessageDialog(null, response);

        } catch (IOException ex) {
            System.out.println("IOExeption: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException: " + ex.getMessage());
        }
    }
    
    public void clientAddRentalDetails()
    {
        JTextField id = new JTextField();
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            JTextField customerId = new JTextField();
            JTextField houseId = new JTextField();

            Object[] addFields
                    = {
                        "ID:", id,
                        "Customer ID:", customerId,
                        "House ID:", houseId
                    };

            JOptionPane.showConfirmDialog(null, addFields, "Add details", JOptionPane.OK_CANCEL_OPTION);

            try {
                out.writeObject("Add Rental");
                out.flush();

                out.writeInt(Integer.parseInt(id.getText()));

                out.writeObject(date);
                out.flush();

                out.writeInt(Integer.parseInt(customerId.getText()));
                out.flush();

                out.writeInt(Integer.parseInt(houseId.getText()));
                out.flush();

                String response = (String) in.readObject();
                JOptionPane.showMessageDialog(null, response);

            } catch (IOException ex) {
                System.out.println("IOExeption: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException: " + ex.getMessage());
            }
    }
//    public ArrayList<Customer> refreshCustomer() throws ClassNotFoundException{
//        try{
//            //client side
//            out.writeObject("refreshCustomer");
//            out.flush();
//            return (ArrayList<Customer>) in.readObject();
//            
//            
//            
//        } catch (IOException ex) {
//            System.out.println("IOException: " + ex.getMessage());
//            return new ArrayList<>();
//        } 
//    }

    public static void main(String[] args) {
        new HouseGUI().setGUI();

    }

}
