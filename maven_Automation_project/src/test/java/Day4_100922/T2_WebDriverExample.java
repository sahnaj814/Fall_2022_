package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebDriverExample {
    public static void main(String[] args) throws InterruptedException {
        //define the  webdriver manger setup for chromedriver
        WebDriverManager.chromedriver(). setup();
        //define the chrome driver to use for your test
        //creating an instance for chrome driver (browser) to use for automation
        WebDriver driver = new ChromeDriver();
        //nav

        driver.navigate(). to ("http://www.google.com");

        //wait few seconds
        Thread.sleep(3000);
        //quit
        driver.quit();


    }// end of main
}//end of java class
