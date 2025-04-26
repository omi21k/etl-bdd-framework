package stepDef;

import org.testng.Assert;
import io.cucumber.java.en.*;
import utilities.DBUtils;
import utilities.countValidation;

import java.sql.DriverManager;

public class ETL_Steps {
    int sourceCount, targetCount;

    @Given("I have source and target DB connections")
    public void setUp() {
        // Connections handled inside DBUtils
    }

    @When("I fetch record count from source and target tables")
    public void fetchCounts() {
    	System.out.println("I am here now");
        sourceCount = countValidation.getCount("SELECT COUNT(*) FROM EMPLOYEES");
        targetCount = countValidation.getCount("SELECT COUNT(*) FROM EMPLOYEES");
    
        System.out.println("Source count " + sourceCount);
        System.out.println("Source count " + targetCount);
    }

    @Then("the record counts should match")
    public void validateCounts() {
    	Assert.assertEquals(sourceCount, targetCount, "Record counts do not match!");

    }
}
