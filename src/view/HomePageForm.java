package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HomePageForm extends JFrame{
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnSearch;
    private JButton btnDelete;
    private JButton btnView;
    private AddCustomerForm addCustomerForm;
    private SearchCustomerForm searchCustomerForm;
    private UpdateCustomerForm updateCustomerForm;
    private ViewCustomerForm viewCustomerForm;

    private JLabel labelHomeP;
    private JLabel labelDCm;
    private JLabel labelIfriend;
    private JLabel labelCopyWrite;

    public HomePageForm(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        panel.setBounds(0,0,350,550);




        btnAdd = new JButton();
        btnAdd.setFocusable(false);
        btnAdd.setText("Add Contact");
        btnAdd.setFont(new Font("", 1, 15));
        btnAdd.setBounds(70,130,300,40);
        btnAdd.setBorder(BorderFactory.createEtchedBorder());
        btnAdd.addActionListener(evt ->
                new AddCustomerForm().setVisible(true)
        );

        btnUpdate = new JButton();
        btnUpdate.setFocusable(false);
        btnUpdate.setText("Update Contact");
        btnUpdate.setFont(new Font("", 1, 15));
        btnUpdate.setBounds(70,200,300,40);
        btnUpdate.addActionListener(evt -> new UpdateCustomerForm().setVisible(true));

        btnSearch = new JButton();
        btnSearch.setFocusable(false);
        btnSearch.setText("Search Contact");
        btnSearch.setFont(new Font("", 1, 15));
        btnSearch.setBounds(70,270,300,40);
        btnSearch.addActionListener(evt -> new SearchCustomerForm().setVisible(true));

        btnDelete = new JButton();
        btnDelete.setFocusable(false);
        btnDelete.setText("Delete Contact");
        btnDelete.setFont(new Font("", 1, 15));
        btnDelete.setBounds(70,340,300,40);
        btnDelete.addActionListener(evt -> new DeleteCustomerForm().setVisible(true));

        btnView = new JButton();
        btnView.setFocusable(false);
        btnView.setText("View");
        btnView.setFont(new Font("", 1, 15));
        btnView.setBounds(70,410,300,40);
       // btnView.setFont(new Font("",Font.PLAIN,15));
        btnView.addActionListener(evt -> {
            if(viewCustomerForm==null){
                viewCustomerForm=new ViewCustomerForm();
            }
            viewCustomerForm.setVisible(true);
        });



        JPanel panel2 = new JPanel();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icons8-customer-48.png")));
        panel2.setBackground(new Color(0,206,209));
        panel2.setBounds(352,0,432,550);

        labelDCm = new JLabel();
        labelDCm.setText("<< Contact Manager >>");
        labelDCm.setBounds(190,220,150,100);

        labelIfriend = new JLabel();
        labelIfriend.setText("iFRIEND");
        labelIfriend.setFont(new Font("MV Boli",Font.PLAIN,60));
        labelIfriend.setBounds(50,180,250,100);
        labelIfriend.setVerticalAlignment(JLabel.CENTER);
        labelIfriend.setHorizontalAlignment(JLabel.CENTER);



        Border border = BorderFactory.createLineBorder(Color.white, 3);
        labelHomeP = new JLabel();
        labelHomeP.setText("   Home Page   ");
        labelHomeP.setFont(new Font("",Font.PLAIN,40));
        //labelHomeP.setBorder(border);
        labelHomeP.setForeground(Color.white);

        labelHomeP.setVerticalAlignment(JLabel.CENTER);
        labelHomeP.setHorizontalAlignment(JLabel.CENTER);
        labelHomeP.setBounds(0,0,432,70);
        labelHomeP.setBackground(new Color(47,79,79));
        labelHomeP.setOpaque(true);

        labelCopyWrite=new JLabel();
        labelCopyWrite.setText("@Sharada-Marasinha");
        labelCopyWrite.setBounds(120,400,150,100);


        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800,550);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);






        panel2.add(labelHomeP);
        panel.add(labelIfriend);
        panel.add(labelDCm);
        panel.add(labelCopyWrite);

        panel2.add(btnAdd);
        panel2.add(btnUpdate);
        panel2.add(btnSearch);
        panel2.add(btnView);
        panel2.add(btnDelete);




        panel.setLayout(null);
        panel2.setLayout(null);

        add(panel);
        add(panel2);




    }


}
