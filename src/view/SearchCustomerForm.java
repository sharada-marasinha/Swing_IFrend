package view;

import Controller.CustomerController;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SearchCustomerForm extends JFrame{
    private JLabel titleLabel;
    private JButton searchButton;
    private JButton cancelButton;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel salaryLabel;
    private JLabel companyLabel;
    private JLabel birthdayLabel;


    private JTextField idText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField salaryText;
    private JTextField companyText;
    private JTextField birthdayText;
    private JTextField idTextL;


    SearchCustomerForm(){
        setSize(800,590);
        setTitle("Search Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon/icons8-search-in-list-48.png")));


        JPanel labelPanel=new JPanel();
        labelPanel.setBackground(new Color(224, 255, 255));
        labelPanel.setLayout(null);
        labelPanel.setBounds(0,0,800,590);

        JPanel buttonPanel=new JPanel();
        FlowLayout f1=new FlowLayout();
        f1.setAlignment(FlowLayout.RIGHT);
        buttonPanel.setLayout(f1);
        buttonPanel.setBounds(450, 480, 300, 40);
        buttonPanel.setBackground(new Color(224, 255, 255));
        //JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));

        titleLabel=new JLabel("Search Customer Form");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0,0,800,60);
        titleLabel.setBackground(new Color(47,79,79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);



        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("",1,15));
        cancelButton.addActionListener(evt ->dispose());


        searchButton=new JButton("Search");
        searchButton.setFont(new Font("",1,15));
        searchButton.setBounds(650, 80, 100, 30);
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String id=idText.getText();
                Customer customer= CustomerController.CustomerController.searchCustomer(id);
                if(customer!=null){
                    idTextL.setText(customer.getId());
                    nameText.setText(customer.getName());
                    addressText.setText(customer.getAddress());
                    salaryText.setText(""+customer.getSalary());
                    companyText.setText(customer.getCompany());
                    birthdayText.setText(customer.getBirthday());
                }else if(idText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,
                            "Please Enter Customer ID For Search",
                            "Empty warning",
                            JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Customer Not Fount",
                            "Not Found",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        idLabel = new JLabel("Customer ID -");
        idLabel.setFont(new Font("", 1, 15));
        idLabel.setBounds(20, 70, 300, 40);

        nameLabel=new JLabel("Name");
        nameLabel.setFont(new Font("",1,15));
        nameLabel.setBounds(150, 130, 300, 40);

        addressLabel=new JLabel("Address");
        addressLabel.setFont(new Font("",1,15));
        addressLabel.setBounds(150, 200, 300, 40);

        salaryLabel=new JLabel("Salary");
        salaryLabel.setFont(new Font("",1,15));
        salaryLabel.setBounds(150, 270, 300, 40);

        companyLabel = new JLabel("Company");
        companyLabel.setFont(new Font("", 1, 15));
        companyLabel.setBounds(150, 340, 300, 40);

        birthdayLabel = new JLabel("Birthday");
        birthdayLabel.setFont(new Font("", 1, 15));
        birthdayLabel.setBounds(150, 410, 300, 40);




        //JPanel textPanel=new JPanel(new GridLayout(4,1));
        //JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        idText=new JTextField();
        idText.setFont(new Font("",1,15));
        idText.setBounds(320, 80, 300, 30);
        idText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String id=idText.getText();
                Customer customer= CustomerController.CustomerController.searchCustomer(id);
                if(customer!=null){
                    idTextL.setText(customer.getId());
                    nameText.setText(customer.getName());
                    addressText.setText(customer.getAddress());
                    salaryText.setText(""+customer.getSalary());
                    companyText.setText(customer.getCompany());
                    birthdayText.setText(customer.getBirthday());
                }else if(idText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,
                            "Please Enter Customer ID For Search",
                            "Empty warning",
                            JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Customer Not Fount",
                            "Not Found",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        idTextL = new JTextField();
        idTextL.setFont(new Font("", 1, 15));
        idTextL.setEditable(false);
        idTextL.setBounds(130, 75, 100, 30);

        nameText=new JTextField(15);
        nameText.setFont(new Font("",1,15));
        nameText.setBounds(300, 130, 350, 40);
        nameText.setEditable(false);

        addressText=new JTextField(20);
        addressText .setFont(new Font("",1,15));
        addressText.setBounds(300, 200, 350, 40);
        addressText.setEditable(false);

        salaryText=new JTextField(10);
        salaryText.setFont(new Font("",1,15));
        salaryText.setBounds(300, 270, 350, 40);
        salaryText.setEditable(false);

        companyText = new JTextField(10);
        companyText.setFont(new Font("", 1, 15));
        companyText.setBounds(300, 340, 350, 40);
        companyText.setEditable(false);

        birthdayText = new JTextField(10);
        birthdayText.setFont(new Font("", 1, 15));
        birthdayText.setBounds(300, 410, 350, 40);
        birthdayText.setEditable(false);


        labelPanel.add(titleLabel);
        labelPanel.add(idLabel);
        labelPanel.add(nameLabel);
        labelPanel.add(addressLabel);
        labelPanel.add(companyLabel);
        labelPanel.add(salaryLabel);
        labelPanel.add(birthdayLabel);

        labelPanel.add(idText);
        labelPanel.add(idTextL);
        labelPanel.add(nameText);
        labelPanel.add(companyText);
        labelPanel.add(addressText);
        labelPanel.add(salaryText);
        labelPanel.add(birthdayText);
        labelPanel.add(searchButton);

       // buttonPanel.add(searchButton);
        buttonPanel.add(cancelButton);


        labelPanel.add(buttonPanel);

        add(labelPanel);
    }


}
