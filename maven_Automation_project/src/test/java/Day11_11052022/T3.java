package Day11_11052022;

import Reusable_library_Loggers.Reusable_Actions;
import Reusable_library_Loggers.Reusable_Annotations;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3 extends Reusable_Annotations {
        @Test(priority = 1)
        public void tc001_verifySignedInOptionIsChecked() {
            //first navigate to yahoo homepage
            driver.navigate().to("https://www.yahoo.com/");
            //next we need to click on sign in button
            Reusable_Actions.clickAction(driver, "//*[@class = '_yb_1933e']", "Sign in button");
            //we need to verify that signed in option is checked
            boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
            System.out.println("The checkbox check condition is: " + isSignInChecked);
        }//end of test 1

        @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
        public void tc002_verifySignedInOptionIsUnChecked() {
            //click on check box to uncheck it
            Reusable_Actions.clickAction(driver, "//*[@class= 'stay-signed-in checkbox-container']", "SignedInCheckBox");
            //we need to verify that signed in option is checked
            boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
            System.out.println("The checkbox check condition is: " + isSignInChecked);
        }//end of test 2

    }


