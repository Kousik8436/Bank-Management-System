import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{

    String pin;
    TextField textField;
    JButton b1; 
    JButton b2;

    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,820);
        this.add(l3);

        JLabel label1 = new JLabel("PLEASE ENTER YOUR AMOUNT TO WITHDRAWAL");
        label1.setForeground(new Color(0,102,204));
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setBounds(460,180,600,35);
        l3.add(label1);

        JLabel label2 = new JLabel("(MAXIMUM WITHDRAWAL IS RS. 10,000)");
        label2.setForeground(new Color(0,102,204));
        label2.setFont(new Font("Tahoma",Font.BOLD,20));
        label2.setBounds(460,220,600,35);
        l3.add(label2);

        this.textField = new TextField();
        this.textField.setBackground(new Color(0,0,0,180));
        this.textField.setForeground(Color.WHITE);
        this.textField.setBounds(460,260,420,30);
        this.textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(this.textField);

        b1 = new JButton("WITHDRAWAL");
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
        if(e.getSource()==b1){
        try{
            String amount = textField.getText();
            Date date = new Date();
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawal");
            }else{
                DBConnection c = new DBConnection();
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                setVisible(false);
                new main_Class(pin);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }else if(e.getSource() == b2){
        setVisible(false);
        new main_Class(pin);
    }
}
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
