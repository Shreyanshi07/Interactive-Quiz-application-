package quiz.app;

import javax.swing.*;

import java.awt.*;
import java.sql.*;

public class Leaderboard extends JFrame {

    Leaderboard() {
        setTitle("Leaderboard");
        setSize(750, 550);
        setLocation(400, 150);
        setLayout(null);
        setUndecorated(true); // Remove window borders

        // Background image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
        ImageIcon bgResized = new ImageIcon(bgImage);
        JLabel background = new JLabel(bgResized);
        background.setBounds(0, 0, 750, 550);
        add(background);

        // Heading
        JLabel heading = new JLabel(" Top 5 Players");
        heading.setBounds(250, 30, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        // Column labels
        JLabel userLabel = new JLabel("Username");
        JLabel scoreLabel = new JLabel("Score");
        JLabel catLabel = new JLabel("Category");

        int y = 100;
        for (JLabel lbl : new JLabel[]{userLabel, scoreLabel, catLabel}) {
            lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
            lbl.setForeground(Color.YELLOW);
            background.add(lbl);
        }

        userLabel.setBounds(150, y, 150, 30);
        scoreLabel.setBounds(300, y, 100, 30);
        catLabel.setBounds(420, y, 150, 30);

        // Fetch and display leaderboard data
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "");
            String query = "SELECT * FROM leaderboard ORDER BY score DESC LIMIT 5";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                System.out.println("No data found in the leaderboard.");
            }

            int row = 140;
            while (rs.next()) {
                JLabel username = new JLabel(rs.getString("username"));
                JLabel score = new JLabel(String.valueOf(rs.getInt("score")));
                JLabel category = new JLabel(rs.getString("quiz_category"));

                username.setBounds(150, row, 150, 30);
                score.setBounds(300, row, 100, 30);
                category.setBounds(420, row, 150, 30);

                for (JLabel lbl : new JLabel[]{username, score, category}) {
                    lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
                    lbl.setForeground(Color.WHITE);
                    background.add(lbl);
                }
                row += 40;
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Back button
        JButton back = new JButton("BACK");
        back.setBounds(300, 450, 150, 30);
        back.setBackground(new Color(70, 130, 180));
        back.setForeground(Color.WHITE);
        background.add(back);

        back.addActionListener(e -> {
            setVisible(false);
            new Login(); // Go back to login screen or Score if you want
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Leaderboard();
    }
}
