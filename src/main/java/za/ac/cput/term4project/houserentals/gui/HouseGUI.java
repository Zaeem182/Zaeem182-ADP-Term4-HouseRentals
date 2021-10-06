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

    //JFrame 2
    JFrame frame2 = new JFrame();

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
        lblHeading = new JLabel("Rent a Blikkie");

        //TextField input
        txtId = new JTextField(10);
        txtFName = new JTextField(10);
        txtLName = new JTextField(10);
        txtPhoneNum = new JTextField(10);

        //Checkbox input
        chkCanRent = new JCheckBox();

        //Buttons
        btnAdd = new JButton("Add Customer");
        btnAdminAgent = new JButton("Add Employee");
        btnHouses = new JButton("HOUSES");
        btnCustomers = new JButton("CUSTOMERS");
        btnRentals = new JButton("Add Rental");
        btnExit = new JButton("EXIT");

        //ComboBox
        cboUser = new JComboBox();

        //Table
        tblModel = new DefaultTableModel();
        tblDisplay = new JTable(tblModel);

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
        frame.add(panelLeft, BorderLayout.WEST);
        panelLeft.setPreferredSize(new Dimension(300, 300));
        panelLeft.setLayout(new GridLayout(6, 2));

        //Add Labels
//        panelLeft.add(lblId);
        panelLeft.add(txtId);

//        panelLeft.add(lblFName);
        panelLeft.add(txtFName);

//        panelLeft.add(lblLName);
        panelLeft.add(txtLName);

//        panelLeft.add(lblPhoneNum);
        panelLeft.add(txtPhoneNum);

//        panelLeft.add(lblCanRent);
        panelLeft.add(chkCanRent);

        //Heading
        panelTop.add(lblHeading);

        //ComboBox
        panelTop.add(cboUser);
        cboUser.addItem("-no selection made-");

        //Buttons
        btnAdd.setPreferredSize(new Dimension(90, 40));
        btnAdminAgent.setPreferredSize(new Dimension(110, 40));
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
        tblModel.addColumn("ID");
        tblModel.addColumn("First Name");
        tblModel.addColumn("Last Name");
        tblModel.addColumn("Phone Number");
        tblModel.addColumn("Can Rent");

        panelCenter.add(new JScrollPane(tblDisplay));

        //Show on form
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //EXIT BUTTON
        if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);

        }
        //Button Admin Agent
        if (e.getActionCommand().equals("")) {
        }

        //Button Houses
        if (e.getActionCommand().equals("HOUSES")) {

        }
        //ADD BUTTON
        if (e.getActionCommand().equals("Add Customer")) {
            clientAddCustomerDetails();
        }

        if (e.getActionCommand().equals("Add Employee")) {
            clientAddEmployeeDetails();
        }

        if (e.getActionCommand().equals("Add Rental")) {
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
