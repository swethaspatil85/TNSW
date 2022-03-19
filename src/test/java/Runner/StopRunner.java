package Runner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(   features="features",
glue="stepDefination",
tags = "not @ignore",
plugin= { "pretty", "html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json", "pretty:target/cucumber-reports/cucumber-pretty.txt",

        "usage:target/cucumber-reports/cucumber-usage.json", "junit:target/cucumber-reports/cucumber-results.xml"  }
)
public class StopRunner {
    private TestNGCucumberRunner testNGCucumberRunner;  

  @BeforeClass(alwaysRun = true)  
    public void setUpClass() throws Exception {  
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
  }  

    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
  }  

    @DataProvider  
  public Object[][] scenarios() {  
        return testNGCucumberRunner.provideScenarios();  
  }  

    @AfterClass(alwaysRun = true)  
    public void tearDownClass() throws Exception {  
        testNGCucumberRunner.finish();  
  } 
	
}
