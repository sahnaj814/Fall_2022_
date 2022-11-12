package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
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
        driver.navigate().to("https://www.yahoo.com");

        //wait few seconds
        Thread.sleep(3000);

        //using find elements i want to click on seconds link with the group which
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();
    }// end of main
}// end of java class
