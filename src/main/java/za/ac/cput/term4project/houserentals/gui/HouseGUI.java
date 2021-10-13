/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import za.ac.cput.term4project.houserentals.domain.Customer;
import za.ac.cput.term4project.houserentals.domain.Employers;
import za.ac.cput.term4project.houserentals.domain.House;
import za.ac.cput.term4project.houserentals.domain.Rental;

/**
 *
 * @author Zaeem Petersen (219010145)
 * @author Ali Mohamed - 219113505
 */
public class HouseGUI implements ActionListener, ItemListener {


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

    //JButtons
    private JButton btnAdd;
    private JButton btnAdminAgent;
    private JButton btnHouses;
    private JButton btnCustomers;
    private JButton btnRentals;
    private JButton btnExit;
    private JButton btnCustomerSignOut;

    //JTable
    private DefaultTableModel tblModel;
    private JTable tblDisplay;

    //Fonts
    private Font Hft;
    private Font ft;

    //JFrame
    JFrame frameC = new JFrame();

    ///////////////////////////////////////////////////////////////
    //Login
    JFrame frameLog = new JFrame();
    
   
    private JPanel panelLoginTop;
    private JPanel panelLoginCenter;
    private JPanel panelLoginBottom;
    private JPanel panelLoginLeft;
    private JPanel panelLoginRight;
    
    private JLabel lblLoginHeading;
    
    private JLabel lblLoginId;
    private JLabel lblLoginLastname;
    
    private JTextField txtLoginId;
    private JTextField txtLoginLastname;
    
    private JButton btnLogin;
    private JButton btnAdminLogin;
    private JButton btnLoginExit;
    private JButton btnCustomerUpdate;
    
    /////////////////////////////////////////////////////
    //Jpanel for house table
    
    JFrame frameH = new JFrame();

    private JPanel panelHouseTop;
    private JPanel panelHouseCenter;
    private JPanel panelHouseBottom;
    private JPanel panelHouseLeft;

    private JLabel lblHouseHeading;
    
    private JLabel lblFilter;
    private JComboBox cboFilter;
        
    private JButton btnHouseAdd;
    private JButton btnHAdminAgent;
    private JButton btnHHouses;
    private JButton btnHCustomers;
    private JButton btnHRentals;
    private JButton btnHouseExit;
    private JButton btnHouseSignOut;
    private JButton btnAvailable;
    private JButton btnNotAvailable;
    private JButton btnHouseUpdate;
    
    private DefaultTableModel tblHouseModel;
    private JTable tblHouseDisplay;
    
    /////////////////////////////////////////////////////
    //Jpanel for Rental table
    
   JFrame frameR = new JFrame();
   
    private JPanel panelRentalTop;
    private JPanel panelRentalCenter;
    private JPanel panelRentalBottom;

    private JLabel lblRentalHeading;
    
    private JButton btnRentalAdd;
    private JButton btnRAdminAgent;
    private JButton btnRHouses;
    private JButton btnRCustomers;
    private JButton btnRRentals;
    private JButton btnRentalExit;
    private JButton btnRentalSignOut;
    
    private DefaultTableModel tblRentalModel;
    private JTable tblRentalDisplay;

    /////////////////////////////////////////////////////
    //Jpanel for Employee table
    
    JFrame frameE = new JFrame();
    
    private JPanel panelEmployeeTop;
    private JPanel panelEmployeeCenter;
    private JPanel panelEmployeeBottom;

    private JLabel lblEmployeeHeading;
    
    private JButton btnEmployeeAdd;
    private JButton btnEAdminAgent;
    private JButton btnEHouses;
    private JButton btnECustomers;
    private JButton btnERentals;
    private JButton btnEmployeeExit;
    private JButton btnEmployeeSignOut;
    private JButton btnEmployeeUpdate;
    
    private DefaultTableModel tblEmployeeModel;
    private JTable tblEmployeeDisplay;
    
    String filter;
    
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


        //Buttons
        btnAdd = new JButton("Add Customer");
        btnAdminAgent = new JButton("EMPLOYEES");
        btnHouses = new JButton("HOUSES");
        btnCustomers = new JButton("CUSTOMERS");
        btnRentals = new JButton("RENTALS");
        btnExit = new JButton("EXIT");
        btnCustomerSignOut = new JButton("Sign Out");
        btnCustomerUpdate = new JButton("Update Customer");


        //Add action listeners
        btnAdd.addActionListener(this);
        btnAdminAgent.addActionListener(this);
        btnHouses.addActionListener(this);
        btnCustomers.addActionListener(this);
        btnRentals.addActionListener(this);
        btnExit.addActionListener(this);
        btnCustomerSignOut.addActionListener(this);
        btnCustomerUpdate.addActionListener(this);
        
        //Table
        tblModel = new DefaultTableModel();
        tblDisplay = new JTable(tblModel);
        ///////////////////////////////////////////////////////////////
        //Login
        panelLoginTop = new JPanel();
        panelLoginCenter = new JPanel();
        panelLoginBottom = new JPanel();
        panelLoginLeft = new JPanel();
        panelLoginRight = new JPanel();
        
        lblLoginHeading = new JLabel("ZA RENTALS LOGIN");
        lblLoginId = new JLabel("Enter ID Number: ") ;
        txtLoginId = new JTextField(12);
        lblLoginLastname = new JLabel("Enter Last Name: ");
        txtLoginLastname = new JTextField(12);
        
        btnLogin = new JButton("AGENT LOGIN");
        btnAdminLogin = new JButton("ADMIN LOGIN");
        btnLoginExit = new JButton("EXIT");
        
        btnLogin.addActionListener(this);
        btnAdminLogin.addActionListener(this);
        btnLoginExit.addActionListener(this);       
        /////////////////////////////////////////////////////
        //house panels
         panelHouseTop = new JPanel();
         panelHouseCenter = new JPanel();
         panelHouseBottom = new JPanel();
         panelHouseLeft = new JPanel();
         
        lblHouseHeading = new JLabel("ZA RENTALS");
        
        lblFilter = new JLabel("Filter: ");
        cboFilter = new JComboBox();
        cboFilter.addItem("Select a location to filter the list");
        
        btnHouseAdd = new JButton("Add House");
        btnHAdminAgent = new JButton("EMPLOYEES");
        btnHHouses = new JButton("HOUSES");
        btnHCustomers = new JButton("CUSTOMERS");
        btnHRentals = new JButton("RENTALS");
        btnHouseExit = new JButton("EXIT");
        btnHouseSignOut = new JButton("Sign Out");
        btnAvailable = new JButton("Available");
        btnNotAvailable = new JButton("Not Available");
        btnHouseUpdate = new JButton("Update House");
        
        btnHouseAdd.addActionListener(this);
        btnHAdminAgent.addActionListener(this);
        btnHHouses.addActionListener(this);
        btnHCustomers.addActionListener(this);
        btnHRentals.addActionListener(this);
        btnHouseExit.addActionListener(this);
        btnHouseSignOut.addActionListener(this);
        btnAvailable.addActionListener(this);
        btnNotAvailable.addActionListener(this);
        btnHouseUpdate.addActionListener(this);
        
        cboFilter.addItemListener(this);
        
        tblHouseModel = new DefaultTableModel();
        tblHouseDisplay = new JTable(tblHouseModel);
        
        /////////////////////////////////////////////////////
        //Rental panels
        panelRentalTop = new JPanel();
        panelRentalCenter = new JPanel();
        panelRentalBottom = new JPanel();
         
        lblRentalHeading = new JLabel("ZA RENTALS");
        
        btnRentalAdd = new JButton("Add Rental");
        btnRAdminAgent = new JButton("EMPLOYEES");
        btnRHouses = new JButton("HOUSES");
        btnRCustomers = new JButton("CUSTOMERS");
        btnRRentals = new JButton("RENTALS");
        btnRentalExit = new JButton("EXIT");
        btnRentalSignOut = new JButton("Sign Out");
        
        btnRentalAdd.addActionListener(this);
        btnRAdminAgent.addActionListener(this);
        btnRHouses.addActionListener(this);
        btnRCustomers.addActionListener(this);
        btnRRentals.addActionListener(this);
        btnRentalExit.addActionListener(this);
        btnRentalSignOut.addActionListener(this);
        
        tblRentalModel = new DefaultTableModel();
        tblRentalDisplay = new JTable(tblRentalModel);
    
        /////////////////////////////////////////////////////
        //Employee panels
        panelEmployeeTop = new JPanel();
        panelEmployeeCenter = new JPanel();
        panelEmployeeBottom = new JPanel();
         
        lblEmployeeHeading = new JLabel("ZA RENTALS");
        
        btnEmployeeAdd = new JButton("Add Employee");
        btnEAdminAgent = new JButton("EMPLOYEES");
        btnEHouses = new JButton("HOUSES");
        btnECustomers = new JButton("CUSTOMERS");
        btnERentals = new JButton("RENTALS");
        btnEmployeeExit = new JButton("EXIT");
        btnEmployeeSignOut = new JButton("Sign Out");
        btnEmployeeUpdate = new JButton("Update Employee");
        
        btnEmployeeAdd.addActionListener(this);
        btnEAdminAgent.addActionListener(this);
        btnEHouses.addActionListener(this);
        btnECustomers.addActionListener(this);
        btnERentals.addActionListener(this);
        btnEmployeeExit.addActionListener(this);
        btnEmployeeSignOut.addActionListener(this);
        btnEmployeeUpdate.addActionListener(this);
        
        tblEmployeeModel = new DefaultTableModel();
        tblEmployeeDisplay = new JTable(tblEmployeeModel);
    }

     public void setAdminLoginPage()
    {
        setEmployeePanels();
    }
     
    public void setLoginPage()
    {
        setCustomerPanels();
    }

    public void setHousePanels()
    {
        refreshHouse();
        
        frameLog.setVisible(false);
        frameH.setVisible(false);
        frameC.setVisible(false);
        frameE.setVisible(false);
        
        frameR.setVisible(true);

        btnHHouses.setBackground(Color.WHITE);
        
    }
    
    public void setRentalPanels()
    {   
        frameLog.setVisible(false);
        frameH.setVisible(false);
        frameC.setVisible(false);
        frameR.setVisible(false);
        
        frameE.setVisible(true);
        
        btnRRentals.setBackground(Color.WHITE);
        
    }
    
     public void setEmployeePanels()
    {
        frameLog.setVisible(false);
        frameC.setVisible(false);
        frameR.setVisible(false);
        frameE.setVisible(false);
        
        frameH.setVisible(true);
        
        btnEAdminAgent.setBackground(Color.WHITE);
    }
    
    public void setCustomerPanels()
    {
        frameLog.setVisible(false);
        frameH.setVisible(false);
        frameR.setVisible(false);
        frameE.setVisible(false);
        
        frameC.setVisible(true);

        btnCustomers.setBackground(Color.WHITE);
    }
    
    public void setBackToLogin(){
        frameLog.setVisible(true);
        frameH.setVisible(false);
        frameR.setVisible(false);
        frameE.setVisible(false);
        
        frameC.setVisible(false);
        txtLoginId.setText("");
        txtLoginLastname.setText("");
        
        btnAdd.setEnabled(true);
        btnEmployeeAdd.setEnabled(true);
        btnHouseAdd.setEnabled(true);
        btnRentalAdd.setEnabled(true);
    }
    public void setGUI() {
        
        //Table Sorter 
        tblDisplay.setAutoCreateRowSorter(true);

                
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

        //Buttons
        btnAdd.setPreferredSize(new Dimension(150, 50));
        btnAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnHouses.setPreferredSize(new Dimension(120, 40));
        btnCustomers.setPreferredSize(new Dimension(120, 40));
        btnRentals.setPreferredSize(new Dimension(120, 40));
        btnExit.setPreferredSize(new Dimension(150, 50));
        btnCustomerSignOut.setPreferredSize(new Dimension(150, 50));
        btnCustomerUpdate.setPreferredSize(new Dimension(150, 50));

        //Button Colours
        btnAdd.setBackground(new Color(102, 178, 255));
        btnAdd.setForeground(new Color(0, 0, 0));

        btnAdminAgent.setBackground(new Color(102, 178, 255));
        btnAdminAgent.setForeground(new Color(0, 0, 0));

        btnHouses.setBackground(new Color(102, 178, 255));
        btnHouses.setForeground(new Color(0, 0, 0));

        btnCustomers.setBackground(Color.WHITE);
        
        btnCustomers.setForeground(new Color(0, 0, 0));

        btnRentals.setBackground(new Color(102, 178, 255));
        btnRentals.setForeground(new Color(0, 0, 0));

        btnExit.setBackground(new Color(102, 178, 255));
        btnExit.setForeground(new Color(0, 0, 0));
        
        btnCustomerUpdate.setBackground(new Color(102, 178, 255));
        btnCustomerUpdate.setForeground(new Color(0, 0, 0));

        btnCustomerSignOut.setBackground(new Color(102, 178, 255));
        btnCustomerSignOut.setForeground(new Color(0, 0, 0));

        //Panels Colours
        panelTop.setBackground(new Color(233, 160, 124));
        panelCenter.setBackground(new Color(233, 160, 124));
        panelBottom.setBackground(new Color(233, 160, 124));
        panelLeft.setBackground(new Color(233, 160, 124));
        
        //Customer Panel Buttons
        panelBottom.add(btnCustomerSignOut);
        panelBottom.add(btnAdd);
        panelCenter.add(btnCustomers);
        panelCenter.add(btnAdminAgent);
        panelCenter.add(btnHouses);
        panelCenter.add(btnRentals);
        panelBottom.add(btnCustomerUpdate);
        panelBottom.add(btnExit);
        
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
        frameC.setVisible(false);

       ///////////////////////////////////////////////////////////////
        //Login GUI
        lblLoginHeading.setFont(Hft);
        lblLoginHeading.setForeground(new Color(0, 0, 0));
        
        lblLoginId.setFont(Hft);
        lblLoginId.setForeground(new Color(0, 0, 0));
        
        lblLoginLastname.setFont(Hft);
        lblLoginLastname.setForeground(new Color(0, 0, 0));
        
        frameLog.add(panelLoginLeft,BorderLayout.WEST);
        panelLoginLeft.setPreferredSize(new Dimension(50, 50));
        
        frameLog.add(panelLoginRight,BorderLayout.EAST);
        panelLoginRight.setPreferredSize(new Dimension(50, 50));
        
        frameLog.add(panelLoginTop,BorderLayout.NORTH);
        panelLoginTop.setLayout(new GridLayout(1, 1));
        panelLoginTop.setPreferredSize(new Dimension(50, 100));
        
        frameLog.add(panelLoginCenter,BorderLayout.CENTER);
        panelLoginCenter.setPreferredSize(new Dimension(150, 50));

        frameLog.add(panelLoginBottom,BorderLayout.SOUTH);
        
        panelLoginBottom.add(btnLogin);
        panelLoginBottom.add(btnAdminLogin);
        panelLoginBottom.add(btnLoginExit);
        
        panelLoginCenter.add(lblLoginId);
        panelLoginCenter.add(txtLoginId);
        panelLoginCenter.add(lblLoginLastname);
        panelLoginCenter.add(txtLoginLastname);
        
        panelLoginTop.add(lblLoginHeading);
        
        btnLogin.setPreferredSize(new Dimension(150, 50));
        btnAdminLogin.setPreferredSize(new Dimension(150, 50));
        btnLoginExit.setPreferredSize(new Dimension(150, 50));
        
        panelLoginTop.setBackground(new Color(233, 160, 124));
        panelLoginCenter.setBackground(new Color(233, 160, 124));
        panelLoginBottom.setBackground(new Color(233, 160, 124));
        panelLoginLeft.setBackground(new Color(233, 160, 124));
        panelLoginRight.setBackground(new Color(233, 160, 124));
        
        btnLogin.setBackground(new Color(102, 178, 255));
        btnLogin.setForeground(new Color(0, 0, 0));
        btnAdminLogin.setBackground(new Color(102, 178, 255));
        btnAdminLogin.setForeground(new Color(0, 0, 0));

        btnLoginExit.setBackground(new Color(102, 178, 255));
        btnLoginExit.setForeground(new Color(0, 0, 0));
        
        frameLog.setSize(505, 450);
        frameLog.setLocationRelativeTo(null);
        frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLog.setVisible(true);
        
        ///////////////////////////////////////////////////////////////
        //Employee GUI
        
        //Table Sorter 
        tblEmployeeDisplay.setAutoCreateRowSorter(true);
        
        lblEmployeeHeading.setFont(Hft);
        lblEmployeeHeading.setForeground(new Color(0, 0, 0));
        
        frameH.add(panelEmployeeTop,BorderLayout.NORTH);
        panelEmployeeTop.setLayout(new GridLayout(1, 2));
        panelEmployeeTop.setSize(300, 300);
        
        frameH.add(panelEmployeeCenter,BorderLayout.CENTER);
        
        frameH.add(panelEmployeeBottom,BorderLayout.SOUTH);
        
        panelEmployeeBottom.add(btnEmployeeSignOut);
        panelEmployeeBottom.add(btnEmployeeAdd);
        panelEmployeeCenter.add(btnECustomers);
        panelEmployeeCenter.add(btnEAdminAgent);
        panelEmployeeCenter.add(btnEHouses);
        panelEmployeeCenter.add(btnERentals);
        panelEmployeeBottom.add(btnEmployeeUpdate);
        panelEmployeeBottom.add(btnEmployeeExit);
        
        tblEmployeeDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEmployeeModel.addColumn("ID");
        tblEmployeeModel.addColumn("First Name");
        tblEmployeeModel.addColumn("Last Name");
        tblEmployeeModel.addColumn("Admin");
        tblEmployeeModel.addColumn("Active");

        panelEmployeeCenter.add(new JScrollPane(tblEmployeeDisplay));
        
        panelEmployeeTop.add(lblEmployeeHeading);
        
        btnEmployeeAdd.setPreferredSize(new Dimension(150, 50));
        btnEAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnEHouses.setPreferredSize(new Dimension(120, 40));
        btnECustomers.setPreferredSize(new Dimension(120, 40));
        btnERentals.setPreferredSize(new Dimension(120, 40));
        btnEmployeeExit.setPreferredSize(new Dimension(150, 50));
        btnEmployeeSignOut.setPreferredSize(new Dimension(150, 50));
        btnEmployeeUpdate.setPreferredSize(new Dimension(150, 50));
        
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
        
        btnEmployeeSignOut.setBackground(new Color(102, 178, 255));
        btnEmployeeSignOut.setForeground(new Color(0, 0, 0));
        
        btnEmployeeUpdate.setBackground(new Color(102, 178, 255));
        btnEmployeeUpdate.setForeground(new Color(0, 0, 0));
        
        panelEmployeeTop.setBackground(new Color(233, 160, 124));
        panelEmployeeCenter.setBackground(new Color(233, 160, 124));
        panelEmployeeBottom.setBackground(new Color(233, 160, 124));
        
        frameH.setSize(850, 500);
        frameH.setLocationRelativeTo(null);
        frameH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameH.setVisible(false);
        

         ////////////////////////////////////////////////////////////////
        //House GUI
        
        //Table Sorter
        tblHouseDisplay.setAutoCreateRowSorter(true);
        
        lblHouseHeading.setFont(Hft);
        lblFilter.setFont(ft);
        lblHouseHeading.setForeground(new Color(0, 0, 0));
        
        frameR.add(panelHouseTop,BorderLayout.NORTH);
        panelHouseTop.setLayout(new GridLayout(3, 2));
        panelHouseTop.setSize(300, 300);
        
        frameR.add(panelHouseLeft,BorderLayout.WEST);
        panelHouseLeft.setPreferredSize(new Dimension(120,300));
        
        frameR.add(panelHouseCenter,BorderLayout.CENTER);
        
        
        frameR.add(panelHouseBottom,BorderLayout.SOUTH);
        panelHouseTop.add(lblHouseHeading);
        panelHouseTop.add(lblFilter);
        panelHouseTop.add(cboFilter);
        panelHouseBottom.add(btnHouseSignOut);
        panelHouseBottom.add(btnHouseAdd);
        panelHouseCenter.add(btnHCustomers);
        panelHouseCenter.add(btnHAdminAgent);
        panelHouseCenter.add(btnHHouses);
        panelHouseCenter.add(btnHRentals);
        panelHouseBottom.add(btnHouseUpdate);
        panelHouseBottom.add(btnHouseExit);
        panelHouseLeft.add(btnAvailable);
        panelHouseLeft.add(btnNotAvailable);
       
        
        tblHouseDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblHouseModel.addColumn("ID");
        tblHouseModel.addColumn("No. of Rooms");
        tblHouseModel.addColumn("Location");
        tblHouseModel.addColumn("Price");
        tblHouseModel.addColumn("Is Rented");

        panelHouseCenter.add(new JScrollPane(tblHouseDisplay));
        
        //
        btnHouseAdd.setPreferredSize(new Dimension(150, 50));
        btnHAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnHHouses.setPreferredSize(new Dimension(120, 40));
        btnHCustomers.setPreferredSize(new Dimension(120, 40));
        btnHRentals.setPreferredSize(new Dimension(120, 40));
        btnHouseExit.setPreferredSize(new Dimension(150, 50));
        btnHouseSignOut.setPreferredSize(new Dimension(150, 50));
        btnAvailable.setPreferredSize(new Dimension(115, 40));
        btnNotAvailable.setPreferredSize(new Dimension(115, 40));
        btnHouseUpdate.setPreferredSize(new Dimension(150, 50));

        
        btnHouseUpdate.setBackground(new Color(102, 178, 255));
        btnHouseUpdate.setForeground(new Color(0, 0, 0));
        
        btnAvailable.setBackground(new Color(102, 178, 255));
        btnAvailable.setForeground(new Color(0, 0, 0));
        
        btnNotAvailable.setBackground(new Color(102, 178, 255));
        btnNotAvailable.setForeground(new Color(0, 0, 0));
        
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
        
        btnHouseSignOut.setBackground(new Color(102, 178, 255));
        btnHouseSignOut.setForeground(new Color(0, 0, 0));
        
        panelHouseTop.setBackground(new Color(233, 160, 124));
        panelHouseCenter.setBackground(new Color(233, 160, 124));
        panelHouseBottom.setBackground(new Color(233, 160, 124));
        panelHouseLeft.setBackground(new Color(233, 160, 124));
        //
        
        frameR.setSize(850, 500);
        frameR.setLocationRelativeTo(null);
        frameR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameR.setVisible(false);
        
        
        ///////////////////////////////////////////////////////////////
        //Rental GUI
        
        //Table Sorter
        tblRentalDisplay.setAutoCreateRowSorter(true);
        
        lblRentalHeading.setFont(Hft);
        lblRentalHeading.setForeground(new Color(0, 0, 0));
        
        frameE.add(panelRentalTop,BorderLayout.NORTH);
        panelRentalTop.setLayout(new GridLayout(1, 2));
        panelRentalTop.setSize(300, 300);
        
        frameE.add(panelRentalCenter,BorderLayout.CENTER);
        
        frameE.add(panelRentalBottom,BorderLayout.SOUTH);
        
        panelRentalBottom.add(btnRentalSignOut);
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
        
                //
        btnRentalAdd.setPreferredSize(new Dimension(150, 50));
        btnRAdminAgent.setPreferredSize(new Dimension(120, 40));
        btnRHouses.setPreferredSize(new Dimension(120, 40));
        btnRCustomers.setPreferredSize(new Dimension(120, 40));
        btnRRentals.setPreferredSize(new Dimension(120, 40));
        btnRentalExit.setPreferredSize(new Dimension(150, 50));
        btnRentalSignOut.setPreferredSize(new Dimension(150, 50));
        
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
        
        btnRentalSignOut.setBackground(new Color(102, 178, 255));
        btnRentalSignOut.setForeground(new Color(0, 0, 0));
        
        panelRentalTop.setBackground(new Color(233, 160, 124));
        panelRentalCenter.setBackground(new Color(233, 160, 124));
        panelRentalBottom.setBackground(new Color(233, 160, 124));
        //
        
        frameE.setSize(850, 500);
        frameE.setLocationRelativeTo(null);
        frameE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameE.setVisible(false);
        
        //Read on startup
        refreshCustomer();
        refreshEmployee();
        refreshHouse();
        refreshRental();
        refreshCboHouse();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Login Button
        if(e.getActionCommand().equals("AGENT LOGIN"))
        {
            LoginConfirm();
            
        }
        //Admin Login Button
        if(e.getActionCommand().equals("ADMIN LOGIN"))
        {
            LoginAdminConfirm();
            
        }
        //EXIT BUTTON
        if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);
            
            //Close server
            try {
                out.writeObject("EXIT");
                out.flush();
                
                out.close();
                in.close();
                server.close();
                System.out.println("client closed");
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }  
        }
        //Sign Out Button
        if(e.getActionCommand().equals("Sign Out")){
            setBackToLogin();
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
        
        //Update Customer Button
        if (e.getActionCommand().equals("Update Customer")) {
            clientUpdateCustomerDetails();
            refreshCustomer();
        }
        //Update House Button
        if (e.getActionCommand().equals("Update House")) {
            clientUpdateHouseDetails();
            refreshHouse();
        }
        //Update Employee Button
        if (e.getActionCommand().equals("Update Employee")) {
            clientUpdateEmployeeDetails();
            refreshEmployee();
        }
        
        //ADD Customer Button
        if (e.getActionCommand().equals("Add Customer")) {
            clientAddCustomerDetails();
            refreshCustomer();
        }
        //ADD Employee Button
        if (e.getActionCommand().equals("Add Employee")) {
            clientAddEmployeeDetails();
            refreshEmployee();
        }
        //Add House Button
        if (e.getActionCommand().equals("Add House")){
            clientAddHouseDetails();
            refreshCboHouse();
            
            refreshHouse();
        }
        //House Availability Buttons
         if(e.getActionCommand().equals("Available"))
        {
            houseAvailable();
            
        }
          if(e.getActionCommand().equals("Not Available"))
        {
            houseNotAvailable();
            
        }
        
        //ADD Rental Button
        if (e.getActionCommand().equals("Add Rental")) {
            clientAddRentalDetails();
            refreshRental();

        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        try{
            if(e.getStateChange() == ItemEvent.SELECTED){
                if(!cboFilter.getSelectedItem().equals("Select a location to filter the list")){

                    if(e.getSource() == cboFilter){
                        
                        if (cboFilter.getSelectedItem().equals("Camps Bay")) {
                            cboCampsBay();
                        }
                        if (cboFilter.getSelectedItem().equals("Clifton")) {
                            cboClifton();
                        }
                        if (cboFilter.getSelectedItem().equals("Sea Point")) {
                            cboSeaPoint();
                        }
                        if (cboFilter.getSelectedItem().equals("Constantia")) {
                            cboConstantia();
                        }
                        if (cboFilter.getSelectedItem().equals("Athlone")) {
                            cboAthlone();
                        }
                        if (cboFilter.getSelectedItem().equals("Wynberg")) {
                            cboWynberg();
                        }
                    }
                }
            }
        } 
        catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    public void LoginConfirm() {

        try {
            int ID = Integer.parseInt(txtLoginId.getText());
            String LastName = txtLoginLastname.getText();

            if (txtLoginId.getText().equals("") || txtLoginLastname.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes!");

                frameC.setVisible(false);
                frameLog.setVisible(true);
            } else 
               
            out.writeObject("Agent Login");
            out.flush();

            out.writeInt(ID);
            out.flush();

            out.writeObject(LastName);
            out.flush();

            String response = (String) in.readObject();
            JOptionPane.showMessageDialog(null, response);
            
            //disables buttons
            btnEmployeeAdd.setEnabled(false);
            btnHouseAdd.setEnabled(false);
            
            if (response.equals("Wrong credidentials! try again")) {

                frameLog.setVisible(true);
                frameC.setVisible(false);
            } else {
                setLoginPage();
            }

        } catch (IOException ex) {
            System.out.println("IOExeption: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes with correct credentials!");
        } catch (HeadlessException ex) {
            System.out.println("HeadlessException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Exception: " + ex.getMessage());
        }

    }
    public void LoginAdminConfirm() {

        try {
            int ID = Integer.parseInt(txtLoginId.getText());
            String LastName = txtLoginLastname.getText();

            if (txtLoginId.getText().equals("") || txtLoginLastname.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes!");

                frameC.setVisible(false);
                frameLog.setVisible(true);
            } else 
               
            out.writeObject("Admin Login");
            out.flush();

            out.writeInt(ID);
            out.flush();

            out.writeObject(LastName);
            out.flush();

            String response = (String) in.readObject();
            JOptionPane.showMessageDialog(null, response);
            
            //disables buttons
            btnAdd.setEnabled(false);
            btnRentalAdd.setEnabled(false);          
            
            if (response.equals("Wrong credidentials! try again")) {

                frameLog.setVisible(true);
                frameC.setVisible(false);
            } else {
                setAdminLoginPage();

            }

        } catch (IOException ex) {
            System.out.println("IOExeption: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes with correct credentials!");
        } catch (HeadlessException ex) {
            System.out.println("HeadlessException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Exception: " + ex.getMessage());
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
        
        int option;
        option = JOptionPane.showConfirmDialog(null, addFields, "Add details", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            if (id.getText().isEmpty() || fName.getText().isEmpty() || lName.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes!");
            }
            if(option == JOptionPane.CANCEL_OPTION)
            {
                
            }
        else
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
            if (option == JOptionPane.CANCEL_OPTION) {

            } else
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

    }
    
    public void clientAddHouseDetails(){
        JTextField id = new JTextField();
        JTextField noOfRooms = new JTextField();
        JTextField location = new JTextField();
        JTextField price = new JTextField();
        JCheckBox isRented = new JCheckBox();
        
        Object[] addFields 
                = {
                    "ID:", id,
                    "Number of Rooms:", noOfRooms,
                    "Location:", location,
                    "Price:", price,
                    "Is Rented:", isRented
                };
        
        int option;
        option = JOptionPane.showConfirmDialog(null, addFields, "Add details", JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION){
            if (id.getText().isEmpty() || noOfRooms.getText().isEmpty() || location.getText().isEmpty() || price.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes!");
            }
            if(option == JOptionPane.CANCEL_OPTION)
            {
                
            }
            else
            try{
                out.writeObject("Add House");
                out.flush();
                
                out.writeInt(Integer.parseInt(id.getText()));
                out.flush();
                
                out.writeObject(noOfRooms.getText());
                out.flush();
                
                out.writeObject(location.getText());
                out.flush();
                
                out.writeDouble(Double.parseDouble(price.getText()));
                out.flush();
                
                out.writeBoolean(isRented.isSelected());
                out.flush();
                
                String response = (String) in.readObject();
                JOptionPane.showMessageDialog(null, response);
            } catch(IOException ex){
                System.out.println("IOException: " + ex.getMessage());
            } catch(ClassNotFoundException ex){
                System.out.println("ClassNotFoundException: " + ex.getMessage());
            } catch(NumberFormatException ex){
                System.out.println("NumberFormatException: " + ex.getMessage());
            }
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

        int option;
        option = JOptionPane.showConfirmDialog(null, addFields, "Add details", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            if (id.getText().isEmpty() || customerId.getText().isEmpty() || houseId.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Error, please fill in all text boxes!");
            }
            if(option == JOptionPane.CANCEL_OPTION)
            {
                
            }
        else

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
    }
    
    public void clientUpdateCustomerDetails()
    {
    
    }
    public void clientUpdateEmployeeDetails()
    {
    
    }
    /////////////////////////////////////
    JComboBox cboHouse = new JComboBox();
    /////////////////////////////////////
    public void clientUpdateHouseDetails()
    {
        
        JCheckBox isRented = new JCheckBox();
        
        Object[] addFields
                ={
                    "Select Data to Edit: ",cboHouse,
                    "is Rented: ", isRented
                 };
        cboHouseUpdateRefresh();
        int option;
        option = JOptionPane.showConfirmDialog(null, addFields, "Update details", JOptionPane.OK_CANCEL_OPTION);
    }
    //Arraylist for displaying database
      ArrayList<Customer> custRefresh = new ArrayList<>();
      ArrayList<Employers> employeeRefresh = new ArrayList<>();
      ArrayList<House> houseRefresh = new ArrayList<>();
      ArrayList<Rental> rentalRefresh = new ArrayList<>();
      
      public void cboHouseUpdateRefresh()
      {
            try {
            //client side
            out.writeObject("refreshCboHouse");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                cboHouse.addItem(id);
            }

        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
      }
    public void refreshCustomer()
    {
        try
        {
        //client side
            out.writeObject("refreshCustomer");
            out.flush();
            
            //recieve from server
            custRefresh = (ArrayList)in.readObject();
            
            tblDisplay.setModel(tblModel);
            tblModel = (DefaultTableModel) tblDisplay.getModel();
            tblModel.setRowCount(0);
            
            //add values from arraylist to gui JTable
            for(int i = 0; i<custRefresh.size(); i++)
            {
                int id = custRefresh.get(i).getCustomerId();
                String fName = custRefresh.get(i).getfName();
                String lName = custRefresh.get(i).getlName();
                String cellNo = custRefresh.get(i).getCell();
                Boolean canRent = custRefresh.get(i).isCanRent();
                Object[] CustomerData = {id, fName, lName, cellNo, canRent};
                tblModel.addRow(CustomerData);
            }
            
            
        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
    }
    
    public void refreshEmployee() {
        try {
            //client side
            out.writeObject("refreshEmployee");
            out.flush();

            //recieve from server
            employeeRefresh = (ArrayList) in.readObject();

            tblEmployeeDisplay.setModel(tblEmployeeModel);
            tblEmployeeModel = (DefaultTableModel) tblEmployeeDisplay.getModel();
            tblEmployeeModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < employeeRefresh.size(); i++) {
                int id = employeeRefresh.get(i).getEmployerId();
                String fName = employeeRefresh.get(i).getfName();
                String lName = employeeRefresh.get(i).getlName();
                boolean isAdmin = employeeRefresh.get(i).isAdmin();
                boolean isActive = employeeRefresh.get(i).isActive();

                Object[] employeeData = {id, fName, lName, isAdmin, isActive};
                tblEmployeeModel.addRow(employeeData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
    }

    public void refreshHouse() {
        try {
            //client side
            out.writeObject("refreshHouse");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
    }

    public void refreshCboHouse() {
        try {
            //client side
            out.writeObject("refreshCboHouseLocation");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            for (int i = 0; i < houseRefresh.size(); i++) {
                String location = houseRefresh.get(i).getLocation();
                cboFilter.addItem(location);
            }

        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
    }

    public void refreshRental() {
        try {
            //client side
            out.writeObject("refreshRental");
            out.flush();

            //recieve from server
            rentalRefresh = (ArrayList) in.readObject();

            tblRentalDisplay.setModel(tblRentalModel);
            tblRentalModel = (DefaultTableModel) tblRentalDisplay.getModel();
            tblRentalModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < rentalRefresh.size(); i++) {
                int id = rentalRefresh.get(i).getRentId();
                Date date = rentalRefresh.get(i).getDate();
                int customerId = rentalRefresh.get(i).getCustomerId();
                int houseId = rentalRefresh.get(i).getHouseId();

                Object[] rentalData = {id, date, customerId, houseId};
                tblRentalModel.addRow(rentalData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
    }

    public void houseAvailable()
    {
       try {
            //client side
            out.writeObject("Available");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        } 
    }
    public void houseNotAvailable()
    {
         try {
            //client side
            out.writeObject("Not Available");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        } 
    }
    public void cboCampsBay() {
        try {
            out.writeObject("Camps Bay");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }

    }

    public void cboConstantia() {
        try {
            out.writeObject("Constantia");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }

    }

    public void cboSeaPoint() {
        try {
            out.writeObject("Sea Point");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }

    }

    public void cboClifton() {
        try {
            out.writeObject("Clifton");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }

    }

    public void cboAthlone() {
        try {
            out.writeObject("Athlone");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }

    }

    public void cboWynberg() {
        try {
            out.writeObject("Wynberg");
            out.flush();

            //recieve from server
            houseRefresh = (ArrayList) in.readObject();

            tblHouseDisplay.setModel(tblHouseModel);
            tblHouseModel = (DefaultTableModel) tblHouseDisplay.getModel();
            tblHouseModel.setRowCount(0);

            //add values from arraylist to gui JTable
            for (int i = 0; i < houseRefresh.size(); i++) {
                int id = houseRefresh.get(i).getId();
                String noOfRooms = houseRefresh.get(i).getNumberOfRooms();
                String location = houseRefresh.get(i).getLocation();
                double price = houseRefresh.get(i).getPrice();
                boolean isRented = houseRefresh.get(i).isIsRented();

                Object[] houseData = {id, noOfRooms, location, price, isRented};
                tblHouseModel.addRow(houseData);
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        new HouseGUI().setGUI();
    }

    

}
