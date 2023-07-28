package view;

import Controller.CustomerController;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerForm extends JFrame {
    private JLabel titleLabel;
    private JButton addButton;
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


    AddCustomerForm() {
        setSize(800, 590);
        setTitle("Add Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon/icons8-add-properties-48.png")));
        //setLayout(null);

        titleLabel = new JLabel("      Add Customer Form    ");
        titleLabel.setFont(new Font("", 1, 35));
        //titleLabel.setBounds(220,10,350,40);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0,0,800,60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);


        addButton = new JButton("Add Customer");
        addButton.setFont(new Font("", 1, 15));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String id = idText.getText();
                String name = nameText.getText();
                String address = addressText.getText();
                String company=companyText.getText();
                double salary = Double.parseDouble(salaryText.getText());
                String birthday=birthdayText.getText();

                Customer customer = new Customer(id, name, address,company, salary,birthday);
                boolean isAdded = CustomerController.addCustomer(customer);
                if (isAdded) {
                    JOptionPane.showMessageDialog(null, "Added Success");
                    int op = JOptionPane.showConfirmDialog(null, "Do you want to add another customer");
                    if (op == JOptionPane.YES_OPTION) {
                        generateId();
                        nameText.setText("");
                        addressText.setText("");
                        companyText.setText("");
                        salaryText.setText("");
                        birthdayText.setText("");

                    } else {
                        dispose();
                    }

                }


            }
        });


        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("", 1, 15));
        cancelButton.addActionListener(evt ->dispose());

        //JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel buttonPanel = new JPanel();
        FlowLayout f1 = new FlowLayout();
        f1.setAlignment(FlowLayout.RIGHT);
        buttonPanel.setLayout(f1);
        buttonPanel.setBounds(450, 480, 300, 40);
        buttonPanel.setBackground(new Color(224, 255, 255));


        JPanel labelPanel = new JPanel();
        labelPanel.setBounds(0, 0, 800, 550);
        labelPanel.setLayout(null);
        labelPanel.setBackground(new Color(224, 255, 255));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(null);

        JPanel idTextPanel = new JPanel();

        idLabel = new JLabel("Customer ID -");
        idLabel.setFont(new Font("", 1, 15));
        idLabel.setBounds(20, 70, 300, 40);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("", 1, 15));
        nameLabel.setBounds(150, 130, 300, 40);

        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("", 1, 15));
        addressLabel.setBounds(150, 200, 300, 40);

        salaryLabel = new JLabel("Salary");
        salaryLabel.setFont(new Font("", 1, 15));
        salaryLabel.setBounds(150, 270, 300, 40);

        companyLabel = new JLabel("Company");
        companyLabel.setFont(new Font("", 1, 15));
        companyLabel.setBounds(150, 340, 300, 40);

        birthdayLabel = new JLabel("Birthday");
        birthdayLabel.setFont(new Font("", 1, 15));
        birthdayLabel.setBounds(150, 410, 300, 40);


        idText = new JTextField();
        idText.setFont(new Font("", 1, 15));
        idText.setEditable(false);
        idText.setBounds(130, 75, 100, 30);



        nameText = new JTextField(15);
        nameText.setBounds(300, 130, 350, 40);
        nameText.setFont(new Font("", 1, 15));

        addressText = new JTextField(20);
        addressText.setBounds(300, 200, 350, 40);
        addressText.setFont(new Font("", 1, 15));

        salaryText = new JTextField(10);
        salaryText.setFont(new Font("", 1, 15));
        salaryText.setBounds(300, 270, 350, 40);

        companyText = new JTextField(10);
        companyText.setFont(new Font("", 1, 15));
        companyText.setBounds(300, 340, 350, 40);

        birthdayText = new JTextField(10);
        birthdayText.setFont(new Font("", 1, 15));
        birthdayText.setBounds(300, 410, 350, 40);

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        labelPanel.add(titleLabel);
        labelPanel.add(idLabel);
        labelPanel.add(idText);
        labelPanel.add(nameLabel);
        labelPanel.add(addressLabel);
        labelPanel.add(salaryLabel);
        labelPanel.add(companyLabel);
        labelPanel.add(birthdayLabel);
        labelPanel.add(buttonPanel);
        labelPanel.add(nameText);
        labelPanel.add(addressText);
        labelPanel.add(salaryText);
        labelPanel.add(companyText);
        labelPanel.add(birthdayText);


        //textPanel.add(idTextPanel);
        //textPanel.add(nameText);
        //textPanel.add(addressText);
        //textPanel.add(salaryText);

        add(labelPanel);
        add(textPanel);


        generateId();
    }

    private void generateId() {
        String lastId = CustomerController.lastId();
        if (lastId == null) {
            idText.setText("C0001");
        } else {
            String s = lastId.substring(1);
            int x = Integer.parseInt(s);
            lastId = String.format("C%04d", ++x);
            idText.setText(lastId);
        }


    }



}
