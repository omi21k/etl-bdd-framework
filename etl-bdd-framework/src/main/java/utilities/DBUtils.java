package utilities;

import java.sql.*;

public class DBUtils {

    public static int getCount(String query, String dbUrl, String user, String pass) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (Connection conn = DriverManager.getConnection(dbUrl, user, pass);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                if (rs.next()) return rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Optional: Overloaded method using config
    public static int getDBCredFromConfig(String query, boolean useSource) {
        String dbUrl = useSource ? ConfigReader.get("source.db.url") : ConfigReader.get("target.db.url");
        String user = ConfigReader.get("db.username");
        String pass = ConfigReader.get("db.password");

        return getCount(query, dbUrl, user, pass);
    }
}
