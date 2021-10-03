/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.term4project.houserentals.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zaeem
 */
public class HouseGUI implements ActionListener{
    
   
    //JPanels
    private JPanel panelTop;
    private JPanel panelCenter;
    private JPanel panelBottom;
    private JPanel panelLeft;
    
    //JLabel Heading
    private JLabel lblHeading;
    
    // JLabel input
    private JLabel lblId;
    private JLabel lblFName;
    private JLabel lblLName;
    private JLabel lblPhoneNum;
    private JLabel lblCanRent;
    
    //JTextFields input
    private JTextField txtId;
    private JTextField txtFName;
    private JTextField txtLName;
    private JTextField txtPhoneNum;
    
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
    
    public HouseGUI()
    {
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
        lblHeading = new JLabel("Rent a Blikkie");
        
        //Label input
        lblId = new JLabel("ID: ");
        lblFName = new JLabel("First Name: ");
        lblLName = new JLabel("Last Name: ");
        lblPhoneNum = new JLabel("Phone Number: ");
        lblCanRent = new JLabel("Can Rent: ");
        
        //TextField input
        txtId = new JTextField(10);
        txtFName = new JTextField(10);
        txtLName = new JTextField(10);
        txtPhoneNum = new JTextField(10);
        
        //Checkbox input
        chkCanRent = new JCheckBox();
        
        //Buttons
        btnAdd = new JButton("ADD");
        btnAdminAgent = new JButton("ADMIN/AGENT");
        btnHouses = new JButton("HOUSES");
        btnCustomers = new JButton("CUSTOMERS");
        btnRentals = new JButton("RENTALS");
        btnExit = new JButton("EXIT");
        
        //ComboBox
        cboUser = new JComboBox();
        
        //Table
        tblModel = new DefaultTableModel();
        tblDisplay = new JTable(tblModel);
    }
    
    public void setGUI()
    {
        //Apply font change
        lblHeading.setFont(Hft);
        lblHeading.setForeground(new Color(0, 0, 0));
        
        //Add Top panel
        frame.add(panelTop, BorderLayout.NORTH);
        panelTop.setLayout(new GridLayout(1, 1));
        panelTop.setSize(300,300);
        
        //Add Center panel
        frame.add(panelCenter, BorderLayout.CENTER);
        
        //Add Bottom panel
        frame.add(panelBottom, BorderLayout.SOUTH);
        panelBottom.setSize(300,300);
        
        //Add Left panel
        frame.add(panelLeft,BorderLayout.WEST);
        panelLeft.setPreferredSize(new Dimension(300, 300));
        panelLeft.setLayout(new GridLayout(6,2));
        
        //Add Labels
        panelLeft.add(lblId);
        panelLeft.add(txtId);
        
        panelLeft.add(lblFName);
        panelLeft.add(txtFName);
        
        panelLeft.add(lblLName);
        panelLeft.add(txtLName);
        
        panelLeft.add(lblPhoneNum);
        panelLeft.add(txtPhoneNum);
        
        panelLeft.add(lblCanRent);
        panelLeft.add(chkCanRent);
      
        //Heading
        panelTop.add(lblHeading);
        
        //ComboBox
        panelTop.add(cboUser);
        cboUser.addItem("-no selection made-");
        
        //Buttons
        btnAdd.setPreferredSize(new Dimension(90,40));
        btnAdminAgent.setPreferredSize(new Dimension(110,40));
        btnHouses.setPreferredSize(new Dimension(90,40));
        btnCustomers.setPreferredSize(new Dimension(90,40));
        btnRentals.setPreferredSize(new Dimension(90,40));
        btnExit.setPreferredSize(new Dimension(150,50));
        
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
        
        panelLeft.add(btnAdd);
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
        tblModel.addColumn("Name");
        tblModel.addColumn("contact number?");
        tblModel.addColumn("other stuff??");
        
        panelCenter.add(new JScrollPane(tblDisplay));
        
        //Show on form
        frame.setSize(900,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //EXIT BUTTON
        if (e.getActionCommand().equals("EXIT"))
       {
           System.exit(0);
       }
        //ADD BUTTON
        if(e.getActionCommand().equals("ADD"))
        {
            btnAdminAgent.setBackground(Color.red);
            tblModel.addColumn("other stuff??");
            tblModel.addColumn("other stuff??");
        }
    }
    
    public static void main(String[] args) {
        new HouseGUI().setGUI();
    }
    
}
