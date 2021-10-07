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
    JFrame frameC = new JFrame();

    /////////////////////////////////////////////////////
        //Jpanel for house table
    
    JFrame frameH = new JFrame();

    private JPanel panelHouseTop;
    private JPanel panelHouseCenter;
    private JPanel panelHouseBottom;

    private JLabel lblHouseHeading;
    private JComboBox cboHouseUser;
        
    private JButton btnHouseAdd;
    private JButton btnHAdminAgent;
    private JButton btnHHouses;
    private JButton btnHCustomers;
    private JButton btnHRentals;
    private JButton btnHouseExit;
    
    private DefaultTableModel tblHouseModel;
    private JTable tblHouseDisplay;
    
    /////////////////////////////////////////////////////
    //Jpanel for Rental table
    
   JFrame frameR = new JFrame();
   
    private JPanel panelRentalTop;
    private JPanel panelRentalCenter;
    private JPanel panelRentalBottom;

    private JLabel lblRentalHeading;
    private JComboBox cboRentalUser;
    
    private JButton btnRentalAdd;
    private JButton btnRAdminAgent;
    private JButton btnRHouses;
    private JButton btnRCustomers;
    private JButton btnRRentals;
    private JButton btnRentalExit;
    
    private DefaultTableModel tblRentalModel;
    private JTable tblRentalDisplay;

    /////////////////////////////////////////////////////
    //Jpanel for Employee table
    
    JFrame frameE = new JFrame();
    
    private JPanel panelEmployeeTop;
    private JPanel panelEmployeeCenter;
    private JPanel panelEmployeeBottom;

    private JLabel lblEmployeeHeading;
    private JComboBox cboEmployeeUser;
    
    private JButton btnEmployeeAdd;
    private JButton btnEAdminAgent;
    private JButton btnEHouses;
    private JButton btnECustomers;
    private JButton btnERentals;
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
         
        lblHouseHeading = new JLabel("ZA RENTALS");
        cboHouseUser = new JComboBox();
        
        btnHouseAdd = new JButton("Add House");
        btnHAdminAgent = new JButton("EMPLOYEES");
        btnHHouses = new JButton("HOUSES");
        btnHCustomers = new JButton("CUSTOMERS");
        btnHRentals = new JButton("RENTALS");
        btnHouseExit = new JButton("EXIT");
        
        btnHouseAdd.addActionListener(this);
        btnHAdminAgent.addActionListener(this);
        btnHHouses.addActionListener(this);
        btnHCustomers.addActionListener(this);
        btnHRentals.addActionListener(this);
        btnHouseExit.addActionListener(this);
        
        tblHouseModel = new DefaultTableModel();
        tblHouseDisplay = new JTable(tblHouseModel);
        
        /////////////////////////////////////////////////////
        //Rental panels
        panelRentalTop = new JPanel();
        panelRentalCenter = new JPanel();
        panelRentalBottom = new JPanel();
         
        lblRentalHeading = new JLabel("ZA RENTALS");
        cboRentalUser = new JComboBox();
        
        btnRentalAdd = new JButton("Add Rental");
        btnRAdminAgent = new JButton("EMPLOYEES");
        btnRHouses = new JButton("HOUSES");
        btnRCustomers = new JButton("CUSTOMERS");
        btnRRentals = new JButton("RENTALS");
        btnRentalExit = new JButton("EXIT");
        
        btnRentalAdd.addActionListener(this);
        btnRAdminAgent.addActionListener(this);
        btnRHouses.addActionListener(this);
        btnRCustomers.addActionListener(this);
        btnRRentals.addActionListener(this);
        btnRentalExit.addActionListener(this);
        
        tblRentalModel = new DefaultTableModel();
        tblRentalDisplay = new JTable(tblRentalModel);
    
        /////////////////////////////////////////////////////
        //Employee panels
        panelEmployeeTop = new JPanel();
        panelEmployeeCenter = new JPanel();
        panelEmployeeBottom = new JPanel();
         
        lblEmployeeHeading = new JLabel("ZA RENTALS");
        cboEmployeeUser = new JComboBox();
        
        btnEmployeeAdd = new JButton("Add Employee");
        btnEAdminAgent = new JButton("EMPLOYEES");
        btnEHouses = new JButton("HOUSES");
        btnECustomers = new JButton("CUSTOMERS");
        btnERentals = new JButton("RENTALS");
        btnEmployeeExit = new JButton("EXIT");
        
        btnEmployeeAdd.addActionListener(this);
        btnEAdminAgent.addActionListener(this);
        btnEHouses.addActionListener(this);
        btnECustomers.addActionListener(this);
        btnERentals.addActionListener(this);
        btnEmployeeExit.addActionListener(this);
        
        tblEmployeeModel = new DefaultTableModel();
        tblEmployeeDisplay = new JTable(tblEmployeeModel);
    }
    public void setHousePanels()
    {
        frameH.setVisible(false);
        frameC.setVisible(false);
        frameE.setVisible(false);
        
        frameR.setVisible(true);

        btnHHouses.setBackground(Color.WHITE);
        
    }
    
    public void setRentalPanels()
    {   
        frameH.setVisible(false);
        frameC.setVisible(false);
        frameR.setVisible(false);
        
        frameE.setVisible(true);
        
        btnRRentals.setBackground(Color.WHITE);
        
    }
    
     public void setEmployeePanels()
    {
        frameC.setVisible(false);
        frameR.setVisible(false);
        frameE.setVisible(false);
        
        frameH.setVisible(true);
        
        btnEAdminAgent.setBackground(Color.WHITE);
    }
    
    public void setCustomerPanels()
    {
       
        frameH.setVisible(false);
        frameR.setVisible(false);
        frameE.setVisible(false);
        
        frameC.setVisible(true);

        btnCustomers.setBackground(Color.WHITE);
    }
    public void setGUI() {
        
        //Apply font change
        lblHeading.setFont(Hft);
        lblHeading.setForeground(new Color(0, 0, 0));

        //Add Top panel
        frameC.add(panelTop, BorderLayout.NORTH);
        panelTop.setLayout(new GridLayout(1, 2));
        panelTop.setSize(300, 300);

        //Add Center panel
        frameC.add(panelCenter, BorderLayout.CENTER);

        //Add Bottom panel
        frameC.add(panelBottom, BorderLayout.SOUTH);
        panelBottom.setSize(300, 300);

        //Heading
        panelTop.add(lblHeading);

        //ComboBox
        panelTop.add(cboUser);
        cboUser.addItem("-no selection made-");

        //Buttons
        btnAdd.setPreferredSize(new Dimension(150, 50));
        btnAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnHouses.setPreferredSize(new Dimension(120, 40));
        btnCustomers.setPreferredSize(new Dimension(120, 40));
        btnRentals.setPreferredSize(new Dimension(120, 40));
        btnExit.setPreferredSize(new Dimension(150, 50));

        //Button Colours
        btnAdd.setBackground(new Color(102, 178, 255));
        btnAdd.setForeground(new Color(0, 0, 0));

        btnAdminAgent.setBackground(new Color(102, 178, 255));
        btnAdminAgent.setForeground(new Color(0, 0, 0));

        btnHouses.setBackground(new Color(102, 178, 255));
        btnHouses.setForeground(new Color(0, 0, 0));

        btnCustomers.setBackground(Color.WHITE);
//        btnCustomers.setBackground(new Color(102, 178, 255));
        btnCustomers.setForeground(new Color(0, 0, 0));

        btnRentals.setBackground(new Color(102, 178, 255));
        btnRentals.setForeground(new Color(0, 0, 0));

        btnExit.setBackground(new Color(102, 178, 255));
        btnExit.setForeground(new Color(0, 0, 0));

        //Panels Colours
        panelTop.setBackground(new Color(233, 160, 124));
        panelCenter.setBackground(new Color(233, 160, 124));
        panelBottom.setBackground(new Color(233, 160, 124));
        panelLeft.setBackground(new Color(233, 160, 124));


        panelBottom.add(btnAdd);
        panelCenter.add(btnCustomers);
        panelCenter.add(btnAdminAgent);
        panelCenter.add(btnHouses);
        panelCenter.add(btnRentals);
        panelBottom.add(btnExit);
        
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
        frameC.setSize(850, 500);
        frameC.setLocationRelativeTo(null);
        frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameC.setVisible(true);

       
        
        ///////////////////////////////////////////////////////////////
        //Employee GUI
        lblEmployeeHeading.setFont(Hft);
        lblEmployeeHeading.setForeground(new Color(0, 0, 0));
        
        frameH.add(panelEmployeeTop,BorderLayout.NORTH);
        panelEmployeeTop.setLayout(new GridLayout(1, 2));
        panelEmployeeTop.setSize(300, 300);
        
        frameH.add(panelEmployeeCenter,BorderLayout.CENTER);
        frameH.add(panelEmployeeBottom,BorderLayout.SOUTH);
        
        panelEmployeeBottom.add(btnEmployeeAdd);
        panelEmployeeCenter.add(btnECustomers);
        panelEmployeeCenter.add(btnEAdminAgent);
        panelEmployeeCenter.add(btnEHouses);
        panelEmployeeCenter.add(btnERentals);
        panelEmployeeBottom.add(btnEmployeeExit);
        
        tblEmployeeDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEmployeeModel.addColumn("ID");
        tblEmployeeModel.addColumn("First Name");
        tblEmployeeModel.addColumn("Last Name");
        tblEmployeeModel.addColumn("Admin");
        tblEmployeeModel.addColumn("Active");

        panelEmployeeCenter.add(new JScrollPane(tblEmployeeDisplay));
        
        panelEmployeeTop.add(lblEmployeeHeading);

        panelEmployeeTop.add(cboEmployeeUser);
        cboEmployeeUser.addItem("-no selection made-");
        
        btnEmployeeAdd.setPreferredSize(new Dimension(150, 50));
        btnEAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnEHouses.setPreferredSize(new Dimension(120, 40));
        btnECustomers.setPreferredSize(new Dimension(120, 40));
        btnERentals.setPreferredSize(new Dimension(120, 40));
        btnEmployeeExit.setPreferredSize(new Dimension(150, 50));
        
        btnEmployeeAdd.setBackground(new Color(102, 178, 255));
        btnEmployeeAdd.setForeground(new Color(0, 0, 0));

        btnEAdminAgent.setBackground(new Color(102, 178, 255));
        btnEAdminAgent.setForeground(new Color(0, 0, 0));

        btnEHouses.setBackground(new Color(102, 178, 255));
        btnEHouses.setForeground(new Color(0, 0, 0));

        btnECustomers.setBackground(new Color(102, 178, 255));
        btnECustomers.setForeground(new Color(0, 0, 0));

        btnERentals.setBackground(new Color(102, 178, 255));
        btnERentals.setForeground(new Color(0, 0, 0));

        btnEmployeeExit.setBackground(new Color(102, 178, 255));
        btnEmployeeExit.setForeground(new Color(0, 0, 0));
        
        panelEmployeeTop.setBackground(new Color(233, 160, 124));
        panelEmployeeCenter.setBackground(new Color(233, 160, 124));
        panelEmployeeBottom.setBackground(new Color(233, 160, 124));
        
        frameH.setSize(850, 500);
        frameH.setLocationRelativeTo(null);
        frameH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameH.setVisible(false);
        

         ////////////////////////////////////////////////////////////////
        //House GUI
        lblHouseHeading.setFont(Hft);
        lblHouseHeading.setForeground(new Color(0, 0, 0));
        
        frameR.add(panelHouseTop,BorderLayout.NORTH);
        panelHouseTop.setLayout(new GridLayout(1, 2));
        panelHouseTop.setSize(300, 300);
        
        frameR.add(panelHouseCenter,BorderLayout.CENTER);
        
        
        frameR.add(panelHouseBottom,BorderLayout.SOUTH);
        
        panelHouseBottom.add(btnHouseAdd);
        panelHouseCenter.add(btnHCustomers);
        panelHouseCenter.add(btnHAdminAgent);
        panelHouseCenter.add(btnHHouses);
        panelHouseCenter.add(btnHRentals);
        panelHouseBottom.add(btnHouseExit);
        
        tblHouseDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblHouseModel.addColumn("ID");
        tblHouseModel.addColumn("No. of Rooms");
        tblHouseModel.addColumn("Location");
        tblHouseModel.addColumn("Rent");

        panelHouseCenter.add(new JScrollPane(tblHouseDisplay));
        
        panelHouseTop.add(lblHouseHeading);

        panelHouseTop.add(cboHouseUser);
        cboHouseUser.addItem("-no selection made-");
        //
        btnHouseAdd.setPreferredSize(new Dimension(150, 50));
        btnHAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnHHouses.setPreferredSize(new Dimension(120, 40));
        btnHCustomers.setPreferredSize(new Dimension(120, 40));
        btnHRentals.setPreferredSize(new Dimension(120, 40));
        btnHouseExit.setPreferredSize(new Dimension(150, 50));
        
        btnHouseAdd.setBackground(new Color(102, 178, 255));
        btnHouseAdd.setForeground(new Color(0, 0, 0));

        btnHAdminAgent.setBackground(new Color(102, 178, 255));
        btnHAdminAgent.setForeground(new Color(0, 0, 0));

        btnHHouses.setBackground(new Color(102, 178, 255));
        btnHHouses.setForeground(new Color(0, 0, 0));

        btnHCustomers.setBackground(new Color(102, 178, 255));
        btnHCustomers.setForeground(new Color(0, 0, 0));

        btnHRentals.setBackground(new Color(102, 178, 255));
        btnHRentals.setForeground(new Color(0, 0, 0));

        btnHouseExit.setBackground(new Color(102, 178, 255));
        btnHouseExit.setForeground(new Color(0, 0, 0));
        
        panelHouseTop.setBackground(new Color(233, 160, 124));
        panelHouseCenter.setBackground(new Color(233, 160, 124));
        panelHouseBottom.setBackground(new Color(233, 160, 124));
        //
        
        frameR.setSize(850, 500);
        frameR.setLocationRelativeTo(null);
        frameR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameR.setVisible(false);
        
        
        ///////////////////////////////////////////////////////////////
        //Rental GUI
        lblRentalHeading.setFont(Hft);
        lblRentalHeading.setForeground(new Color(0, 0, 0));
        
        frameE.add(panelRentalTop,BorderLayout.NORTH);
        panelRentalTop.setLayout(new GridLayout(1, 2));
        panelRentalTop.setSize(300, 300);
        
        frameE.add(panelRentalCenter,BorderLayout.CENTER);
        
        frameE.add(panelRentalBottom,BorderLayout.SOUTH);
        
        panelRentalBottom.add(btnRentalAdd);
        panelRentalCenter.add(btnRCustomers);
        panelRentalCenter.add(btnRAdminAgent);
        panelRentalCenter.add(btnRHouses);
        panelRentalCenter.add(btnRRentals);
        panelRentalBottom.add(btnRentalExit);
        
        tblRentalDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblRentalModel.addColumn("ID");
        tblRentalModel.addColumn("Date");
        tblRentalModel.addColumn("CustomerID");
        tblRentalModel.addColumn("HouseID");

        panelRentalCenter.add(new JScrollPane(tblRentalDisplay));
        
        panelRentalTop.add(lblRentalHeading);

        panelRentalTop.add(cboRentalUser);
        cboRentalUser.addItem("-no selection made-");
        
                //
        btnRentalAdd.setPreferredSize(new Dimension(150, 50));
        btnRAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnRHouses.setPreferredSize(new Dimension(120, 40));
        btnRCustomers.setPreferredSize(new Dimension(120, 40));
        btnRRentals.setPreferredSize(new Dimension(120, 40));
        btnRentalExit.setPreferredSize(new Dimension(150, 50));
        
        btnRentalAdd.setBackground(new Color(102, 178, 255));
        btnRentalAdd.setForeground(new Color(0, 0, 0));

        btnRAdminAgent.setBackground(new Color(102, 178, 255));
        btnRAdminAgent.setForeground(new Color(0, 0, 0));

        btnRHouses.setBackground(new Color(102, 178, 255));
        btnRHouses.setForeground(new Color(0, 0, 0));

        btnRCustomers.setBackground(new Color(102, 178, 255));
        btnRCustomers.setForeground(new Color(0, 0, 0));

        btnRRentals.setBackground(new Color(102, 178, 255));
        btnRRentals.setForeground(new Color(0, 0, 0));

        btnRentalExit.setBackground(new Color(102, 178, 255));
        btnRentalExit.setForeground(new Color(0, 0, 0));
        
        panelRentalTop.setBackground(new Color(233, 160, 124));
        panelRentalCenter.setBackground(new Color(233, 160, 124));
        panelRentalBottom.setBackground(new Color(233, 160, 124));
        //
        
        frameE.setSize(850, 500);
        frameE.setLocationRelativeTo(null);
        frameE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameE.setVisible(false);

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
