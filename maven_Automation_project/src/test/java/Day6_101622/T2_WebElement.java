package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ObjectInputStream;

public class T2_WebElement {


    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manger setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome meting
        //option.addArguments("start-fullscreen") for mac
        options.addArguments("start-maximized");
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        //navigate  to google site
        driver.navigate().to("https://www.mlcalc.com");

        //wait few seconds
        Thread.sleep(3000);

        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the purchase price
         pPrice.clear();
        //type new value on the purchase price
        pPrice.sendKeys("450000");
        //clear and enter a new value on down payment field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        //clear the down payment
        dPayment.clear();
        //type new value on the down payment
        dPayment.sendKeys("25");
    }//end of main
}//end of java
