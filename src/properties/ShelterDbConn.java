// Denne klassen er laget med utgangspunkt i forelesers kode
// Modul 18: Forberedelse til eksamen - Film: eksamen 2023 - kom i gang-koding
package properties;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ShelterDbConn {
    public static final Properties PROPS;

    static {
        PROPS = new Properties();

        try{
            PROPS.load(new FileReader("src/files/shelter.properties"));
        }  catch (IOException e) {
            throw new RuntimeException("Feil ved lesing av properties-fil: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ShelterDB?allowPublicKeyRetrieval=true&useSSL=false";
        String user = PROPS.getProperty("uname");
        String password = PROPS.getProperty("pwd");
        return DriverManager.getConnection(url, user, password);
    }
}
