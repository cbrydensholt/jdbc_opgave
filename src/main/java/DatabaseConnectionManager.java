import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    //ansvars område, skal håndtere et objekt der er et forbindelse til mySQL
    //når vi bruger final, betyder det at vores viarable URL ikke kan forandres. skriv final variable med STORT
    private final String URL;
    private final String DATABASE;
    private final String USERNAME;
    private final String PASSWORD;
    private final String TIMEZONE; //virker ikke i vores getDatabaseConnection

    public DatabaseConnectionManager(){
        this.URL = "jdbc:mysql://localhost:3306/";
        this.TIMEZONE = "serverTimezone=UTC";
        this.DATABASE = "dept";
        this.USERNAME = "root";
        this.PASSWORD = "Brunoven321";

    }

    public Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(URL+DATABASE, USERNAME, PASSWORD);

    }

}
