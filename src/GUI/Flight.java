package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Flight extends JFrame implements ActionListener {

    String aircraft;
    String des;
    Connection con;
    JLabel l1;
    JTextField t1, t2, t3, t4;
    JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;

    public Flight() {

        setSize(1280, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);

        b1 = new JButton("Flight Number");
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

        b2 = new JButton("Flight Type");
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

        b3 = new JButton("Departure Time");
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setBounds(275, 300, 175, 30);
        b3.setFocusable(false);
        b3.setFont(new Font(null, Font.PLAIN, 20));
        b3.addActionListener(this);
        add(b3);

        t3 = new JTextField();
        t3.setEditable(true);
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setCaretColor(Color.black);
        t3.setBounds(475, 300, 400, 30);
        t3.setFont(new Font("null", Font.PLAIN, 20));
        add(t3);

        b4 = new JButton("Arrival Time");
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

        b5 = new JButton("Aircraft Model");
        b5.setBackground(Color.white);
        b5.setForeground(Color.black);
        b5.setBounds(275, 400, 175, 30);
        b5.setFocusable(false);
        b5.setFont(new Font(null, Font.PLAIN, 20));
        b5.addActionListener(this);
        add(b5);

        r1 = new JRadioButton();
        r1.setText("A650");
        r1.setBounds(475, 400, 100, 30);
        r1.setFont(new Font(null, Font.PLAIN, 15));
        r1.addActionListener(this);
        add(r1);

        r2 = new JRadioButton();
        r2.setText("B780C");
        r2.setBounds(585, 400, 100, 30);
        r2.setFont(new Font(null, Font.PLAIN, 15));
        r2.addActionListener(this);
        add(r2);

        r3 = new JRadioButton();
        r3.setText("BB450");
        r3.setBounds(695, 400, 100, 30);
        r3.setFont(new Font(null, Font.PLAIN, 15));
        r3.addActionListener(this);
        add(r3);

        r4 = new JRadioButton();
        r4.setText("C560C");
        r4.setBounds(805, 400, 100, 30);
        r4.setFont(new Font(null, Font.PLAIN, 15));
        r4.addActionListener(this);
        add(r4);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g1.add(r4);

        b6 = new JButton("Destiantion");
        b6.setBackground(Color.white);
        b6.setForeground(Color.black);
        b6.setBounds(275, 450, 175, 30);
        b6.setFocusable(false);
        b6.setFont(new Font(null, Font.PLAIN, 20));
        b6.addActionListener(this);
        add(b6);

        r5 = new JRadioButton();
        r5.setText("Karachi");
        r5.setBounds(475, 450, 100, 30);
        r5.setFont(new Font(null, Font.PLAIN, 15));
        r5.addActionListener(this);
        add(r5);

        r6 = new JRadioButton();
        r6.setText("Aberdeen");
        r6.setBounds(585, 450, 100, 30);
        r6.setFont(new Font(null, Font.PLAIN, 15));
        r6.addActionListener(this);
        add(r6);

        r7 = new JRadioButton();
        r7.setText("Lahore");
        r7.setBounds(695, 450, 100, 30);
        r7.setFont(new Font(null, Font.PLAIN, 15));
        r7.addActionListener(this);
        add(r7);

        r8 = new JRadioButton();
        r8.setText("Moscow");
        r8.setBounds(805, 450, 100, 30);
        r8.setFont(new Font(null, Font.PLAIN, 15));
        r8.addActionListener(this);
        add(r8);

        ButtonGroup g2 = new ButtonGroup();
        g2.add(r5);
        g2.add(r6);
        g2.add(r7);
        g2.add(r8);

        b7 = new JButton("Enter Data");
        b7.setBackground(Color.white);
        b7.setForeground(Color.black);
        b7.setBounds(510, 600, 250, 30);
        b7.setFocusable(false);
        b7.setFont(new Font(null, Font.PLAIN, 20));
        b7.addActionListener(this);
        add(b7);

        ImageIcon back = new ImageIcon(getClass().getResource("back.jpg"));

        b8 = new JButton();
        b8.setIcon(back);
        b8.setBackground(Color.GRAY);
        b8.setForeground(Color.WHITE);
        b8.setBounds(20, 20, 20, 20);
        b8.setFocusable(false);
        b8.setFont(new Font(null, Font.PLAIN, 20));
        b8.addActionListener(this);
        add(b8);

        Icon imgIcon = new ImageIcon(this.getClass().getResource("air.gif"));

        l1 = new JLabel(imgIcon);
        l1.setBounds(0, 0, 1280, 720);
        add(l1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == r1) {
            aircraft = r1.getText();
            System.out.println(aircraft);
        } else if (e.getSource() == r2) {
            aircraft = r2.getText();
            System.out.println(aircraft);
        } else if (e.getSource() == r3) {
            aircraft = r3.getText();
            System.out.println(aircraft);
        } else if (e.getSource() == r4) {
            aircraft = r4.getText();
            System.out.println(aircraft);
        } else if (e.getSource() == r5) {
            des = r5.getText();
            System.out.println(des);
        } else if (e.getSource() == r6) {
            des = r6.getText();
            System.out.println(des);
        } else if (e.getSource() == r7) {
            des = r7.getText();
            System.out.println(des);
        } else if (e.getSource() == r8) {
            des = r8.getText();
            System.out.println(des);
        } else if (e.getSource() == b7) {

            try {

                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "proj");
                PreparedStatement time = con.prepareStatement("Insert into schedule values (?,?)");
                PreparedStatement prestat = con.prepareStatement("Insert into flight values(?,?,?,?,?,?,?,?)");

                try {
                    time.setString(1, t3.getText());
                    time.setString(2, t4.getText());
                    time.executeQuery();

                    prestat.setString(1, Emp_l_form.curr);
                    prestat.setString(2, t1.getText());
                    prestat.setString(3, t2.getText());
                    prestat.setString(4, aircraft);
                    prestat.setString(5, des);
                    prestat.setString(6, t3.getText());
                    prestat.setString(7, t4.getText());
                    prestat.setString(8, "Islamabad Airport");
                    prestat.executeQuery();
                    JOptionPane.showMessageDialog(null, "Data Entered");
                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Enter all values");
                }

            } catch (SQLException u) {
                u.printStackTrace();
            }

        } else if (e.getSource() == b8) {
            dispose();
            new Emp_l_form();
        }

    }
}
