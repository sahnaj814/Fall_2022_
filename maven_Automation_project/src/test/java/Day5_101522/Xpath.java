package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static void main(String[] args) throws InterruptedException {
        //setup yor chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver
        WebDriver driver = new ChromeDriver();
        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com/");
        // maximize the driver
        driver.manage().window().maximize();

        //click on sig in button
        driver.findElement(By.xpath("//*[text='sign in']")).click();
      // wait 2 seconds
        Thread.sleep(2000);
        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com/");
        Thread.sleep(2000);
        //click on the ball icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor']")).click();
        //wait 2 seconds
        Thread.sleep(2000);



        //quit chrome
        driver.quit();


    }// end of main
}// end of java class
