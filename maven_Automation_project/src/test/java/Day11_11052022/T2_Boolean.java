package Day11_11052022;

import Reusable_library_Loggers.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {
    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void tc001_verifySignInOptionIsChecked() {
        driver = Reusable_Actions.setUpDriver();
        //navigate to usps.com home page
        driver.navigate().to("https://www.Yahoo.com/");
        //nect we click on sign in button
        Reusable_Actions.clickAction(driver, "//*[@class='_yb_1933e']", "sign in button");

        //we need to verify that sign in butotn is checked
        boolean isSignInchecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The Checkbox condition is:" + isSignInchecked);
    }//end of test1
    @Test(dependsOnMethods = "tc001_verifySignInOptionIsChecked")
    public void tc002_verifySignInOptionIsChecked() {

        //nect we click on sign in button
        Reusable_Actions.clickAction(driver, "//*[@class='stay-signed-in checkbox-container']", "signedinchekbox");

//we need to verify that sign in option is checked after we unchecked it, result should be false since its unchecked
        boolean isSignInchecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The Checkbox condition is:" + isSignInchecked);

    }//end of test 2
}//end of class
