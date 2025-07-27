import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;

public class FastCash extends JFrame implements ActionListener{
     JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("PLEASE SELECT WITHDRAWAL AMOUNT");
        label.setBounds(415,190,700,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial",Font.BOLD,23));
        l3.add(label);

        b1 = new JButton("Rs. 100");
        b1.setFont(new Font("Arial",Font.BOLD,16));
        b1.setForeground(Color.white);
        b1.setBackground(Color.decode("#0057A3"));
        b1.setBounds(275,355,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setForeground(Color.white);
        b2.setBackground(Color.decode("#0057A3"));
        b2.setBounds(835,355,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setFont(new Font("Arial",Font.BOLD,16));
        b3.setForeground(Color.white);
        b3.setBackground(Color.decode("#0057A3"));
        b3.setBounds(275,394,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setFont(new Font("Arial",Font.BOLD,16));
        b4.setForeground(Color.white);
        b4.setBackground(Color.decode("#0057A3"));
        b4.setBounds(835,394,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setFont(new Font("Arial",Font.BOLD,16));
        b5.setForeground(Color.white);
        b5.setBackground(Color.decode("#0057A3"));
        b5.setBounds(275,433,150,35);
        b5.addActionListener(this);
        l3.add(b5);


        b6 = new JButton("Rs. 10000");
        b6.setFont(new Font("Arial",Font.BOLD,16));
        b6.setForeground(Color.white);
        b6.setBackground(Color.decode("#0057A3"));
        b6.setBounds(835,433,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setFont(new Font("Arial",Font.BOLD,16));
        b7.setForeground(Color.white);
        b7.setBackground(Color.decode("#0057A3"));
        b7.setBounds(835,470,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b7){
            setVisible(false);
            new main_Class(pin);
        }else{
            String amount = ((JButton)e.getSource()).getText().substring(4);
            DBConnection c = new DBConnection();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if(e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }


                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. " +amount+ " Debited Successfuly");

            }catch(Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin);

            }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
