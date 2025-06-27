package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.jar.JarFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Score extends JFrame {
    Score(String name, int score,String category){

        saveScoreToDatabase(name, score, category);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,200,200,150);
        add(image);

        JLabel heading = new JLabel("Thankyou " + name + "for Playing QUIZ Test ");
        heading.setBounds(100,80,700,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,26));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel Score = new JLabel("Your Score is " + score);
        Score.setBounds(350,200,300,30);
        Score.setFont(new Font("Tahoma", Font.BOLD,26));
        Score.setForeground(Color.WHITE);
        add(Score);



        JButton exit = new JButton("EXIT");
        exit.setBounds(380,270,120,30);
        exit.setBackground(new Color(70, 130, 180));
        exit.setForeground(Color.WHITE);
        add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }

        });


        JButton leaderboardButton = new JButton("VIEW LEADERBOARD");
        leaderboardButton.setBounds(350, 320, 180, 30);
        leaderboardButton.setBackground(new Color(70, 130, 180)); // Forest Green
        leaderboardButton.setForeground(Color.WHITE);
        add(leaderboardButton);


        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Leaderboard(); // This opens the leaderboard GUI
            }
        });

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image i22 = i11.getImage().getScaledInstance(750,550, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imagee = new JLabel(i33);
        imagee.setBounds(0,0,750,550);
        add(imagee);


       setSize(750,550);
       setLocation(400,150);
       setLayout(null);
       setUndecorated(true);
       setVisible(true);

    }
    public void saveScoreToDatabase(String username, int score, String category) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "");
            String query = "INSERT INTO leaderboard (username, score, quiz_category) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setInt(2, score);
            ps.setString(3, category);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        }

    public static void main(String[] args) {
        String username = "User";
        int score = 5;
        String selectedCategory = "java"; // or whatever default category
        new Score(username, score,selectedCategory);


    }

}
