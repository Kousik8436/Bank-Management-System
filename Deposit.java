import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

public class Deposit extends JFrame implements ActionListener{
    String pin;
    TextField textField;
    JButton b1; 
    JButton b2;
    
    Deposit(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        this.add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(new Color(0,102,204));
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setBounds(460,180,600,35);
        l3.add(label1);

        this.textField = new TextField();
        this.textField.setBackground(new Color(0,0,0,180));
        this.textField.setForeground(Color.WHITE);
        this.textField.setBounds(460,230,420,30);
        this.textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(this.textField);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Arial",Font.BOLD,16));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(835,355,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setForeground(Color.white);
        b2.setBackground(Color.decode("#0057A3"));
        b2.setBounds(835,394,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout((LayoutManager)null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        String amount = this.textField.getText();
        Date date = new Date();
        if(e.getSource() == this.b1){
            if(this.textField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
            }else{
                DBConnection c = new DBConnection();
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+String.valueOf(date)+"','Deposit','"+amount+"')");
                JOptionPane.showMessageDialog((Component)null, "Rs. "+amount+" Deposited Successfully");
                setVisible(false);
                new main_Class(pin);
            }
        }else if(e.getSource() == this.b2){
            this.setVisible(false);
            new main_Class(pin);
        }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
