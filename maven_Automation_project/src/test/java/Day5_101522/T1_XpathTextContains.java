package Day5_101522;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();


        //go to yahoo home page
            driver.navigate().to("https://www.yahoo.com/");

            //maximize my window
            //for windows
            driver.manage().window().maximize();

            //click on sig in button
            driver.findElement(By.xpath("//*[text='search_icon']")).submit();

            //click on sign in button
            Thread.sleep(2000);



            //quit chrome
            driver.quit();


    }// end of the main
}// end of class
