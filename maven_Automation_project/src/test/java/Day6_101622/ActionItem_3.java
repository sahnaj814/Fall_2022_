package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_3 {
    public static void main(String[] args) throws InterruptedException {
        //define webdrivermanager set up for chromedriver
        WebDriverManager.chromedriver().setup();
        //define chrome options
        ChromeOptions options = new ChromeOptions();
        // add options to maximizing and incognito
        options.addArguments("start-maximized","incognito");
        //define the webdriver and finding the method.
        WebDriver driver = new ChromeDriver(options);
        //

        ArrayList<String> zipcode;
        //create an array list of zipcodes
        zipcode = new ArrayList<>();
        zipcode.add("11209");
        zipcode.add("11223");
        zipcode.add("11217");
        //java script executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < zipcode.size(); i++) {
            //go to weightwatchers site
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //sleep statement
            Thread.sleep(2000);
            //click on find workshop
            driver.findElement(By.xpath("//*[@class='menuItemIconWrapper-1Hrfo']")).click();
            //click on in
            driver.findElement(By.xpath("//*[@class='buttonText-3DCCO']")).click();
            //sleep statement
            Thread.sleep(2000);
            //clear and click on the search
            WebElement search = driver.findElement(By.xpath("//*[@id='location-search']"));
            //clear the search
            search.clear();
            //type the new zipcode
            search.sendKeys(zipcode.get(i));
            //click on search arrow
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            //wait 2 secs
            Thread.sleep(2000);
            // //scroll down to 800 pixels
            jse.executeScript("scroll(0,800)");
            ArrayList<WebElement> address = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'wrapperLink-2NobU')]")));
            if (i == 0) {
                address.get(1).click();
                Thread.sleep(1000);

            }//end first statement
         else if (i == 1) {
                // //scroll down to 1300 pixels
                jse.executeScript("scroll(0,1300)");
                address.get(2).click();
                Thread.sleep(2000);
            }//end second statement

           else if ( i == 2) {
                address.get(0).click();
            }// end of 3rd statement
            String location  = driver.findElements(By.xpath("//*[contains(@class, 'address')]")).get(1).getText();
           //"\n" that means spacing result
            String[] splitLocation = location.split("\n");
            System.out.println (splitLocation[0] + "\n"+splitLocation[1] );
            jse.executeScript("scroll(0,700)");
            String schedule = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainerMobile')]")).getText();
            System.out.println(schedule);
            System.out.println();

        }//end of loop
        driver.quit();
    }// end of main
}// end of java class

