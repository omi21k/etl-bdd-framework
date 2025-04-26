package utilities;

import java.sql.*;

public class DBUtils {
	
	


	// Now you can use dbUrl, username, password wherever needed!


    public static DBCredentials getDBCredFromConfig(boolean useSource) {
        String dbUrl = useSource ? ConfigReader.get("source.db.url") : ConfigReader.get("target.db.url");
        String user = ConfigReader.get("db.hr.username");
        String pass = ConfigReader.get("db.hr.password");

        return new DBCredentials(dbUrl, user, pass);
    }

}
