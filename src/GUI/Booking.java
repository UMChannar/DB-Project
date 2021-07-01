package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Booking extends JFrame implements ActionListener {

    Connection con;
    JLabel l1;
    JButton b1, b2, b3, b4, b5;
    JTextField t1, t2, t3;
    JTextArea t4;
    JScrollPane s1;
    JPanel p1;

    public Booking() {

        setSize(1280, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);

        b1 = new JButton("Flight Number");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(100, 200, 175, 30);
        b1.setFocusable(false);
        b1.setFont(new Font(null, Font.PLAIN, 15));
        b1.addActionListener(this);
        add(b1);

        t1 = new JTextField();
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);
        t1.setCaretColor(Color.black);
        t1.setBounds(100, 240, 200, 30);
        t1.setFont(new Font("null", Font.PLAIN, 20));
        add(t1);

        b2 = new JButton("Children");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setBounds(100, 280, 175, 30);
        b2.setFocusable(false);
        b2.setFont(new Font(null, Font.PLAIN, 15));
        b2.addActionListener(this);
        add(b2);

        t2 = new JTextField();
        t2.setBackground(Color.white);
        t2.setForeground(Color.black);
        t2.setCaretColor(Color.black);
        t2.setBounds(100, 320, 200, 30);
        t2.setFont(new Font("null", Font.PLAIN, 20));
        add(t2);

        b3 = new JButton("Adults");
        b3.setBackground(Color.white);
        b3.setForeground(Color.black);
        b3.setBounds(100, 360, 175, 30);
        b3.setFocusable(false);
        b3.setFont(new Font(null, Font.PLAIN, 15));
        b3.addActionListener(this);
        add(b3);

        t3 = new JTextField();
        t3.setBackground(Color.white);
        t3.setForeground(Color.black);
        t3.setCaretColor(Color.black);
        t3.setBounds(100, 400, 200, 30);
        t3.setFont(new Font("null", Font.PLAIN, 20));
        add(t3);

        p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setForeground(Color.black);
        p1.setBounds(410, 100, 600, 400);
        add(p1);

        t4 = new JTextArea();
        t4.setBackground(Color.white);
        t4.setForeground(Color.black);
        t4.setEditable(false);
        t4.setFont(new Font("null", Font.PLAIN, 15));
        t4.setBounds(50, 0, 400, 400);
        t4.setVisible(true);
        t4.setColumns(5);
        p1.add(t4);

        try {

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "proj");
            PreparedStatement prestat = con.prepareStatement("SELECT\n" +
                    "    fnumber,\n" +
                    "    ftype,\n" +
                    "    destination.dname,\n" +
                    "    schedule.deptime,\n" +
                    "    schedule.arrtime\n" +
                    "FROM\n" +
                    "    flight,\n" +
                    "    destination,\n" +
                    "    schedule\n" +
                    "WHERE\n" +
                    "        flight.destination_dname = destination.dname\n" +
                    "    AND flight.schedule_deptime = schedule.deptime\n" +
                    "    AND flight.schedule_arrtime = schedule.arrtime ");
            ResultSet rs = prestat.executeQuery();
            t4.append("Flight Number" + "    " + "Flight Type" + "    " + "Destination" + "    " + "Departure time" + "    " + "Arrival Time\n");
            while (rs.next()) {
                t4.append(rs.getString(1) + "                " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getString(4) + "   " + rs.getString(5) + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        b4 = new JButton("Book");
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

            try {
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "proj");
                PreparedStatement yeah = con.prepareStatement("Insert into passenger values(?,?,?)");
                PreparedStatement prestat = con.prepareStatement("Insert into booking values(?,?,?)");

                try {
                    yeah.setString(1, User_l_form.currr);
                    yeah.setString(2, t2.getText());
                    yeah.setString(3, t3.getText());
                    yeah.executeQuery();

                    prestat.setString(1, t1.getText());
                    prestat.setString(2, t2.getText());
                    prestat.setString(3, t3.getText());
                    prestat.executeQuery();

                    JOptionPane.showMessageDialog(null, "Seats Booked\nEnjoy!!!");
                } catch (Exception m) {
                    JOptionPane.showMessageDialog(null, "Enter all values");
                }

            } catch (Exception u) {
                u.printStackTrace();
            }

        } else if (e.getSource() == b5) {
            dispose();
            new User_l_form();
        }

    }
}
