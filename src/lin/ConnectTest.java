package lin;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectTest {
    @Test
    public void testConnect1() throws SQLException{
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://120.78.186.255:3306/db_score";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "xiongDA@001");

        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
}
