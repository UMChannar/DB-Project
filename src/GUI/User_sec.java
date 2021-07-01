package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;

public class User_sec extends JFrame implements ActionListener {

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    Connection con;
    JButton b1, b2, b3, b4, b5;
    JTextField t1, t2;
    JPasswordField p3;
    JLabel l1;

    public User_sec() {

        setSize(1280, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);

        b1 = new JButton("Email");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(275, 250, 175, 30);
        b1.setFocusable(false);
        b1.setFont(new Font(null, Font.PLAIN, 20));
        add(b1);

        t1 = new JTextField();
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setCaretColor(Color.black);
        t1.setBounds(475, 250, 400, 30);
        t1.setFont(new Font("null", Font.PLAIN, 20));
        add(t1);

        b2 = new JButton("Secret Phrase");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setBounds(275, 300, 175, 30);
        b2.setFocusable(false);
        b2.setFont(new Font(null, Font.PLAIN, 20));
        add(b2);

        t2 = new JTextField();
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setCaretColor(Color.black);
        t2.setBounds(475, 300, 400, 30);
        t2.setFont(new Font("null", Font.PLAIN, 20));
        add(t2);

        b3 = new JButton("Password");
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setBounds(275, 350, 175, 30);
        b3.setFocusable(false);
        b3.setFont(new Font(null, Font.PLAIN, 20));
        add(b3);

        p3 = new JPasswordField();
        p3.setEditable(true);
        p3.setBackground(Color.white);
        p3.setForeground(Color.black);
        p3.setBounds(475, 350, 400, 30);
        add(p3);

        b4 = new JButton("Change Password");
        b4.setBackground(Color.white);
        b4.setForeground(Color.black);
        b4.setBounds(510, 600, 250, 30);
        b4.setFocusable(false);
        b4.setFont(new Font(null, Font.PLAIN, 20));
        b4.addActionListener(this);
        add(b4);

        ImageIcon back = new ImageIcon(getClass().getResource("back.jpg"));

        b5 = new JButton();
        b5.setIcon(back);
        b5.setBackground(Color.GRAY);
        b5.setForeground(Color.WHITE);
        b5.setBounds(20, 20, 20, 20);
        b5.setFocusable(false);
        b5.setFont(new Font(null, Font.PLAIN, 20));
        b5.addActionListener(this);
        add(b5);

        Icon imgIcon = new ImageIcon(this.getClass().getResource("air.gif"));

        l1 = new JLabel(imgIcon);
        l1.setBounds(0, 0, 1280, 720);
        add(l1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b4) {

            if (isValid(t1.getText())) {
                try {
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "proj");
                    PreparedStatement prestat = con.prepareStatement("update client set pass=? where email=? and secret=?");

                    try {
                        prestat.setString(2, t1.getText());
                        prestat.setString(3, t2.getText());
                        prestat.setString(1, String.valueOf(p3.getPassword()));
                        int check = prestat.executeUpdate();
                        if (check == 1) {
                            JOptionPane.showMessageDialog(null, "Password Updated");
                            dispose();
                            new User_l_form();
                        } else {
                            JOptionPane.showMessageDialog(null, "User Does not exist");
                        }
                    } catch (Exception m) {
                        JOptionPane.showMessageDialog(null, "Enter all values");
                    }

                } catch (SQLException u) {
                    u.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email");
            }

        } else if (e.getSource() == b5) {
            dispose();
            new User_l_form();
        }
    }

}
