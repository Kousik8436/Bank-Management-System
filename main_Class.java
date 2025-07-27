import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class main_Class extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    main_Class(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430,190,700,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial",Font.BOLD,28));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Arial",Font.BOLD,16));
        b1.setForeground(Color.white);
        b1.setBackground(Color.decode("#0057A3"));
        b1.setBounds(275,355,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("WITHDRAWL");
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setForeground(Color.white);
        b2.setBackground(Color.decode("#0057A3"));
        b2.setBounds(835,355,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("Arial",Font.BOLD,16));
        b3.setForeground(Color.white);
        b3.setBackground(Color.decode("#0057A3"));
        b3.setBounds(275,394,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("STATEMENT");
        b4.setFont(new Font("Arial",Font.BOLD,16));
        b4.setForeground(Color.white);
        b4.setBackground(Color.decode("#0057A3"));
        b4.setBounds(835,394,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("CHANGE PIN");
        b5.setFont(new Font("Arial",Font.BOLD,16));
        b5.setForeground(Color.white);
        b5.setBackground(Color.decode("#0057A3"));
        b5.setBounds(275,433,150,35);
        b5.addActionListener(this);
        l3.add(b5);


        b6 = new JButton("CHECK BALANCE");
        b6.setFont(new Font("Arial",Font.BOLD,13));
        b6.setForeground(Color.white);
        b6.setBackground(Color.decode("#0057A3"));
        b6.setBounds(835,433,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
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
        if(e.getSource() == b1){
            new Deposit(pin);
            setVisible(false);
        }else if(e.getSource() == b7){
            System.exit(0);
        }else if(e.getSource() == b2){
            new Withdrawl(pin);
            setVisible(false);
        }else if(e.getSource() == b6){
            new BalanceEnquriy(pin);
            setVisible(false);
        }else if(e.getSource() == b3){
            new FastCash(pin);
            setVisible(false);
        }else if(e.getSource() == b5){
            new Pin(pin);
            setVisible(false);
        }else if(e.getSource() == b4){
            new mini(pin);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new main_Class("");      
    }
}
