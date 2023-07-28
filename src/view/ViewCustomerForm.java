package view;

import Controller.CustomerController;
import db.DBConnection;
import model.Customer;
import model.CustomerList;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class ViewCustomerForm extends JFrame{
    private JTable customerTable;
    private DefaultTableModel dtm;
    private JLabel titleLabel;
    private JButton btnSortByBirthday;
    private JButton btnSortBySalary;
    private JButton btnSortByName;
    ViewCustomerForm(){
        setSize(800,600);
        setTitle("View Customer Details");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon/icons8-view-48.png")));

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 800, 570);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(224, 255, 255));

        titleLabel = new JLabel("      View Customer Form    ");
        titleLabel.setFont(new Font("", 1, 35));
        //titleLabel.setBounds(220,10,350,40);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0,0,800,60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);


        String[] columnNames={"Customer Id","Name","Address","Company","Salary","Birthday"};
        dtm=new DefaultTableModel(columnNames,0);
        customerTable=new JTable(dtm);

        JScrollPane tablePane=new JScrollPane(customerTable);
        tablePane.setBounds(70,80,650,400);


        btnSortByBirthday=new JButton("View Sort by Birthday");
        btnSortByBirthday.setFont(new Font("",1,15));
        btnSortByBirthday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                titleLabel.setText("View Sort by Birthday");
                Customer[] customerArray= CustomerController.CustomerController.getAllCustomerSortByBirthday();
                dtm.setRowCount(0);
                for (int i = 0; i < customerArray.length; i++){
                    Customer customer=customerArray[i];
                    Object[] rowData={customer.getId(),customer.getName(), customer.getAddress(),customer.getCompany(),customer.getSalary(),customer.getBirthday()};
                    dtm.addRow(rowData);
                }
            }
        });

        btnSortByName=new JButton("View Sort by Name");
        btnSortByName.setFont(new Font("",1,15));
        btnSortByName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                titleLabel.setText("View Sort by Name");
                Customer[] customerArray= CustomerController.CustomerController.getAllCustomerSortByName();
                dtm.setRowCount(0);
                for (int i = 0; i < customerArray.length; i++){
                    Customer customer=customerArray[i];
                    Object[] rowData={customer.getId(),customer.getName(), customer.getAddress(),customer.getCompany(),customer.getSalary(),customer.getBirthday()};
                    dtm.addRow(rowData);
                }
            }
        });
        btnSortBySalary=new JButton("View Sort by Salary");
        btnSortBySalary.setFont(new Font("",1,15));
        btnSortBySalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                titleLabel.setText("View Sort by Salary");
                Customer[] customerArray= CustomerController.CustomerController.getAllCustomerSortBySalary();
                dtm.setRowCount(0);
                for (int i = 0; i < customerArray.length; i++){
                    Customer customer=customerArray[i];
                    Object[] rowData={customer.getId(),customer.getName(), customer.getAddress(),customer.getCompany(),customer.getSalary(),customer.getBirthday()};
                    dtm.addRow(rowData);
                }
            }
        });

        JPanel buttonPanel=new JPanel();
        FlowLayout f1=new FlowLayout();
        f1.setAlignment(FlowLayout.CENTER);
        buttonPanel.setLayout(f1);
        buttonPanel.setBackground(new Color(224, 255, 255));
        buttonPanel.setBounds(96, 500, 600, 40);


        buttonPanel.add(btnSortByBirthday);
        buttonPanel.add(btnSortByName);
        buttonPanel.add(btnSortBySalary);

        mainPanel.add(titleLabel);
        mainPanel.add(tablePane);
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }


}

