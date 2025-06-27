package quiz.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection connectDB() {
        try {
            // Update with your DB name, user, and password
            String url = "jdbc:mysql://localhost:3306/quizdb";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
