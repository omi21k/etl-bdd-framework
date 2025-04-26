package utilities;

import java.sql.*;

public class DBUtils {
	
	
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

	// Now you can use dbUrl, username, password wherever needed!


    public static DBCredentials getDBCredFromConfig(boolean useSource) {
        String dbUrl = useSource ? ConfigReader.get("source.db.url") : ConfigReader.get("target.db.url");
        String user = ConfigReader.get("db.username");
        String pass = ConfigReader.get("db.password");

        return new DBCredentials(dbUrl, user, pass);
    }

}
