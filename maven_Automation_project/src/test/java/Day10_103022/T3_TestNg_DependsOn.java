package Day10_103022;

import Reusable_library_Loggers.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T3_TestNg_DependsOn {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test()
    public void TC01_SearchForCar(){
        driver.navigate().to("https://www.google.com");
        //enter a car on the search field
        Reusable_Actions.sendKeysAction(driver,"//*[@name='q']", "BMW", "Search Field");
        //hit submit on the Google button
        Reusable_Actions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
    }//end of test 1

    //since we can not search without navigating to google.com, we use depends on method to
    // execute test 1 first
    @Test(dependsOnMethods = "TC01_SearchForCar")
    public void TC02_CaptureSearchNumber(){
        String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']", "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is " + arrayResult[1]);
    }//end of test 2
}//end of class



