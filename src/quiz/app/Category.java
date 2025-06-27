package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Category extends JFrame implements ActionListener {

    JButton next, back;
    JRadioButton java, cpp, python,Gk;
    ButtonGroup group;
    String name, category = "default";

    Category(String name) {
        this.name = name;

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Select Quiz Category");
        heading.setBounds(150, 50, 400, 40);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(70, 130, 180));
        add(heading);

        java = new JRadioButton("Java");
        java.setBounds(180, 120, 150, 30);
        java.setFont(new Font("Tahoma", Font.PLAIN, 20));
        java.setBackground(Color.WHITE);
        java.setSelected(true);
        add(java);

        cpp = new JRadioButton("C++");
        cpp.setBounds(180, 170, 150, 30);
        cpp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cpp.setBackground(Color.WHITE);
        add(cpp);

        python = new JRadioButton("Python");
        python.setBounds(180, 220, 150, 30);
        python.setFont(new Font("Tahoma", Font.PLAIN, 20));
        python.setBackground(Color.WHITE);
        add(python);

        Gk = new JRadioButton("GK");
        Gk.setBounds(180, 270, 150, 30);
        Gk.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Gk.setBackground(Color.WHITE);
        add(Gk);

        group = new ButtonGroup();
        group.add(java);
        group.add(cpp);
        group.add(python);
        group.add(Gk);

        next = new JButton("Next");
        next.setBounds(100, 320, 120, 30);
        next.setBackground(new Color(70, 130, 180));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBounds(250, 320, 120, 30);
        back.setBackground(new Color(70, 130, 180));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(500, 400);
        setLocation(400, 200);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (java.isSelected()) category = "Java";
            else if (cpp.isSelected()) category = "C++";
            else if (python.isSelected()) category = "Python";
            else if (Gk.isSelected()) category = "GK";

            setVisible(false);
            new Rules(name, category);// You can pass category to Rules too if needed
        } else {
            setVisible(false);
            new Login();

        }
    }

    public static void main(String[] args) {
        new Category("User");
    }
}
