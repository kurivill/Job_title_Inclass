
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;


public class MariaDbConnection {

    private static Connection connection = null;

    private static String getDatabaseUrl() throws Exception {
        // try getting the DATABASE_URL from the environment variable(for jenkins
        String url = System.getenv("DATABASE_URL");

        if (url == null) {
            // if not found, load from .env (for local development)
            Dotenv dotenv = Dotenv.load();
            url = dotenv.get("DATABASE_URL");
        }

        if (url == null) {
            throw new Exception("DATABASE_URL not found in environment or .env file");
        }

        return url;
    }
    public static Connection getConnection() throws Exception{
        String url = getDatabaseUrl();

        System.out.println("Connecting to database: " + url);


        try {
            Class.forName("org.mariadb.jdbc.Driver"); //Debugaamista varten. Varmistaa, että maven ladattu oikein
        } catch (ClassNotFoundException e) {
            System.out.println("MariaDB driver not found");
            throw new Exception("MariaDB driver not found");
        }

        if (connection == null) { // Tämän voi korjata, sillä ei handlaa sitä, että jos yhteys katkeaa jostain syystä
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println("Connection failed" + e.getMessage());
                throw new Exception("Connection failed");
            }
            return connection;
        } else {
            return connection;
        }
    }

    public static void terminate() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}