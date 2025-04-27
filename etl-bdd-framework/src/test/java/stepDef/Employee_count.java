package stepDef;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.*;
import utilities.SQLFileReader;
import utilities.countValidation;

public class Employee_count {
	
    int sourceCount, targetCount;
	
	
	@Given("I have source and target HR DB connections")
	public void i_have_source_and_target_hr_db_connections() {
	    // Write code here that turns the phrase above into concrete actions
		

	}

	@When("I fetch record count from {string} table by running {string} and {string} queries")
	public void i_fetch_record_count_from_and_tables(String tableName, String sourceSqlFile, String targetSqlFile) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
        String sourceQuery = SQLFileReader.readQueryFromFile("sqlFiles/" + sourceSqlFile);
        String targetQuery = SQLFileReader.readQueryFromFile("sqlFiles/" + targetSqlFile);
        
    	System.out.println("I am here now");
        sourceCount = countValidation.getCount(sourceQuery);
        targetCount = countValidation.getCount(targetQuery);
    
        System.out.println("Source "+tableName+" count " + sourceCount);
        System.out.println("Source "+tableName+" count " + targetCount);
		
		
	}

	@Then("the record counts should match of given tables.")
	public void the_record_counts_should_match_of_given_tables() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(sourceCount, targetCount, "Record counts do not match!");

	}

}
