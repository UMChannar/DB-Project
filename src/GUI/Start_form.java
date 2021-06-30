package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start_form extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3;

    public Start_form() {

        setSize(1280, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);

        ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));

        l2 = new JLabel();
        l2.setIcon(logo);
        l2.setBounds(540, 250, 200, 200);
        add(l2);

        b1 = new JButton("Employee");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(450,600,150,30);
        b1.setFocusable(false);
        b1.setFont(new Font(null,Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("User");
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.setBounds(675,600,150,30);
        b2.setFocusable(false);
        b2.setFont(new Font(null,Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);

        ImageIcon back = new ImageIcon(getClass().getResource("back.jpg"));

        b3 = new JButton();
        b3.setIcon(back);
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        b3.setBounds(20,20,20,20);
        b3.setFocusable(false);
        b3.setFont(new Font(null,Font.PLAIN,20));
        b3.addActionListener(this);
        add(b3);

        Icon imgIcon = new ImageIcon(this.getClass().getResource("air.gif"));

        l1 = new JLabel(imgIcon);
        l1.setBounds(0, 0, 1280, 720);
        add(l1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1){
            dispose();
            new Emp_S_form();
        }else if(e.getSource()==b2){
            dispose();
            new User_S_form();
        }else if(e.getSource()==b3){
            JOptionPane.showMessageDialog(null,"Program Closing");
            System.exit(0);
        }

    }
}
