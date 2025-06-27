package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    JTextField text;
    JButton Next, back;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(450, 0, 550, 500);
        add(image);

        JLabel heading = new JLabel("QUIZ TEST");
        heading.setBounds(140, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(70, 130, 180));
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(160, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(70, 130, 180));
        add(name);

        text = new JTextField();
        text.setBounds(80, 200, 300, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(text);

        Next = new JButton("Next");
        Next.setBounds(100, 270, 120, 25);
        Next.setBackground(new Color(70, 130, 180));
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        add(Next);

        back = new JButton("Back");
        back.setBounds(250, 270, 120, 25);
        back.setBackground(new Color(70, 130, 180));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        Next.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2, true));
        Next.setFocusPainted(false);
        Next.setContentAreaFilled(true);


        setSize(1000, 500);
        setLocation(200, 150);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Next) {
            String name = text.getText();

            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your name!");
                return;
            }

            Connection conn = DatabaseConnection.connectDB();
            try {
                PreparedStatement pst = conn.prepareStatement("INSERT INTO users(name) VALUES(?)");
                pst.setString(1, name);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Name saved successfully!");

                setVisible(false);
                new Category(name);


            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            }

        } else if (e.getSource() == back) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
