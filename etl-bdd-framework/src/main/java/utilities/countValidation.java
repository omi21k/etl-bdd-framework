package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class countValidation {
	
	
	static DBCredentials sourceDB;

	static String dbUrl;
	static String user;
	static String pass;

	static {
	    sourceDB = DBUtils.getDBCredFromConfig(true);
	    dbUrl = sourceDB.getDbUrl();
	    user = sourceDB.getUsername();
	    pass = sourceDB.getPassword();
	}
	
	
    public static int getCount(String query) {
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

	
	

}
