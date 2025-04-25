package stepDef;

import org.testng.Assert;
import io.cucumber.java.en.*;
import utilities.DBUtils;
import java.sql.DriverManager;

public class ETL_Steps {
    int sourceCount, targetCount;
    String sourceDB = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    String targetDB = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    String user = "hr", pass = "hr";

    @Given("I have source and target DB connections")
    public void setUp() {
        // Connections handled inside DBUtils
    }

    @When("I fetch record count from source and target tables")
    public void fetchCounts() {
    	System.out.println("I am here now");
        sourceCount = DBUtils.getCount("SELECT COUNT(*) FROM EMPLOYEES", sourceDB, user, pass);
        targetCount = DBUtils.getCount("SELECT COUNT(*) FROM EMPLOYEES", targetDB, user, pass);
    
        System.out.println("Source count " + sourceCount);
        System.out.println("Source count " + targetCount);
    }

    @Then("the record counts should match")
    public void validateCounts() {
    	Assert.assertEquals(sourceCount, targetCount, "Record counts do not match!");

    }
}
