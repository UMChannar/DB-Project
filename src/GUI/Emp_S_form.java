package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;

public class Emp_S_form extends JFrame implements ActionListener {

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
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    JTextField t1, t2, t4;
    JPasswordField p3;

    public Emp_S_form() {

        setSize(1280, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);

        b1 = new JButton("Email");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(275, 200, 175, 30);
        b1.setFocusable(false);
        b1.setFont(new Font(null, Font.PLAIN, 20));
        b1.addActionListener(this);
        add(b1);

        t1 = new JTextField();
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setCaretColor(Color.black);
        t1.setBounds(475, 200, 400, 30);
        t1.setFont(new Font("null", Font.PLAIN, 20));
        add(t1);

        b2 = new JButton("Name");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setBounds(275, 250, 175, 30);
        b2.setFocusable(false);
        b2.setFont(new Font(null, Font.PLAIN, 20));
        b2.addActionListener(this);
        add(b2);

        t2 = new JTextField();
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setCaretColor(Color.black);
        t2.setBounds(475, 250, 400, 30);
        t2.setFont(new Font("null", Font.PLAIN, 20));
        add(t2);

        b3 = new JButton("Password");
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setBounds(275, 300, 175, 30);
        b3.setFocusable(false);
        b3.setFont(new Font(null, Font.PLAIN, 20));
        b3.addActionListener(this);
        add(b3);

        p3 = new JPasswordField();
        p3.setEditable(true);
        p3.setBackground(Color.white);
        p3.setForeground(Color.black);
        p3.setBounds(475, 300, 400, 30);
        add(p3);

        b4 = new JButton("Secret Phrase");
        b4.setBackground(Color.white);
        b4.setForeground(Color.black);
        b4.setBounds(275, 350, 175, 30);
        b4.setFocusable(false);
        b4.setFont(new Font(null, Font.PLAIN, 20));
        b4.addActionListener(this);
        add(b4);

        t4 = new JTextField();
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setCaretColor(Color.black);
        t4.setBounds(475, 350, 400, 30);
        t4.setFont(new Font("null", Font.PLAIN, 20));
        add(t4);

        b5 = new JButton("SignUp");
        b5.setBackground(Color.white);
        b5.setForeground(Color.black);
        b5.setBounds(450, 600, 150, 30);
        b5.setFocusable(false);
        b5.setFont(new Font(null, Font.PLAIN, 20));
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Login");
        b6.setBackground(Color.white);
        b6.setForeground(Color.black);
        b6.setBounds(675, 600, 150, 30);
        b6.setFocusable(false);
        b6.setFont(new Font(null, Font.PLAIN, 20));
        b6.addActionListener(this);
        add(b6);

        ImageIcon back = new ImageIcon(getClass().getResource("back.jpg"));

        b7 = new JButton();
        b7.setIcon(back);
        b7.setBackground(Color.GRAY);
        b7.setForeground(Color.WHITE);
        b7.setBounds(20, 20, 20, 20);
        b7.setFocusable(false);
        b7.setFont(new Font(null, Font.PLAIN, 20));
        b7.addActionListener(this);
        add(b7);

        Icon imgIcon = new ImageIcon(this.getClass().getResource("air.gif"));

        l1 = new JLabel(imgIcon);
        l1.setBounds(0, 0, 1280, 720);
        add(l1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b5) {

            if (isValid(t1.getText())) {
                try {
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "proj");
                    PreparedStatement prestat = con.prepareStatement("Insert into employee values(?,?,?,?)");

                    try {
                        prestat.setString(1, t1.getText());
                        prestat.setString(2, t2.getText());
                        prestat.setString(3, String.valueOf(p3.getPassword()));
                        prestat.setString(4, t4.getText());
                        prestat.executeQuery();
                        JOptionPane.showMessageDialog(null, "User Added");
                    } catch (Exception m) {
                        JOptionPane.showMessageDialog(null, "Enter all values");
                    }

                } catch (SQLException u) {
                    u.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email");
                dispose();
                new Emp_S_form();
            }

        } else if (e.getSource() == b6) {
            dispose();
            new Emp_l_form();
        } else if (e.getSource() == b7) {
            dispose();
            new Start_form();
        }

    }
}
