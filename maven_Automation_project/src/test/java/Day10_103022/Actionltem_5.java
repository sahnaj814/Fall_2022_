package Day10_103022;

import Reusable_library_Loggers.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Actionltem_5 {
    WebDriver driver;

    @BeforeSuite
    public void setChromeDriver() {

        driver = Reusable_Actions.setUpDriver();
    }//end of set up driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of the after suite

    @Test()
    public void findADoctor() throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.uhc.com/");
        //wait a bit
        //Thread.sleep(2000);
        //click on find a doctor
        Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a doctor");
        //Thread.sleep(1000);
        //clicking no on pop up
        Reusable_Actions.clickAction(driver, "//*[@id='ip-no']", "clickPopUp");
        // Thread.sleep(3000);
        //scroll to view find a doctor
       // Reusable_Actions.scrollByViewAction(driver, "//*[@id= 'main-content']", 0, "Main Content");
        //Thread.sleep(3000);
        // click on find a dentist
        Reusable_Actions.clickAction(driver, "//*[text()='Find a dentist']", "Find a Dentist");
        //Thread.sleep(3000);
        //switch tabs
        Reusable_Actions.switchToTabsAction(driver, 1);
        Thread.sleep(2000);
        // refresh the website
        //driver.navigate().refresh();
        //click on employer and individual plan
        Reusable_Actions.clickAction(driver, "//*[text()='Employer and Individual Plans']", "Employer and Individual Plans");
        //Thread.sleep(3000);
        // refresh website
        // driver.navigate().refresh();
    } // end of test 1

    @Test(dependsOnMethods = "findADoctor")
    public void zipCode() throws InterruptedException {
        //input zipcode
        Reusable_Actions.sendKeysAction(driver, "//*[@id= 'location']", "10009", "Zip Code");
        // wait a sec
        Thread.sleep(2000);
        //click submit
        Reusable_Actions.clickAction(driver, "//*[@type='submit']", "Submit");
        Thread.sleep(2000);
        //click on National Options
        Reusable_Actions.clickActionByIndex(driver, "//*[@class= 'sc-jomqko TEkcT']", 1, "National Options");
        Thread.sleep(10000);
        // click on general dentist
        Reusable_Actions.clickAction(driver, "//*[@id='nodeDescription1']", "general dentist");
        Thread.sleep(5000);
    }// end of test 2

    @Test(dependsOnMethods = "zipCode")
    public void menu() {
        //select a different mileage
       // Reusable_Actions.selectByTextAction(driver, "//*[@id='distance']", 0, "Within 50 Miles", "miles dropdown on general dentist page ");
        //class="radiusMiles ng-valid ng-not-empty ng-touched ng-dirty ng-valid-parse ally-focus-within"
        //click on first doctor
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0, "First Doctor");
        //click on save button
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='saved-provider-button']", 0, "Save button");
        //capture address, miles, & network type
        String info = Reusable_Actions.getTextAction(driver, "//*[@class='outer-container tbl']", "Address, Miles, & Network Type");
        //print out information
        System.out.println(info);
        //close out the tab
        driver.close();
    }//test 3

    @Test(dependsOnMethods = "menu")
    public void doctor() throws InterruptedException {
        //switch back to default tab
        Reusable_Actions.switchToTabsAction(driver, 0);
        //navigate back to website
        driver.navigate().to("https://www.uhc.com/");
        Thread.sleep(1000);
        //enter keyword doctor on the search field
        Reusable_Actions.sendKeysAction(driver, "//*[@id='search-desktop']", "Doctor", "Search Doctor");
        // click submit on the search
        Reusable_Actions.clickAction(driver, "//*[@id='search__button-desktop']", "submit icon");
        //capture search results
        String searchResult = Reusable_Actions.getTextAction(driver, "//*[@id='search-results-count__header']", "Search Results");

        String[] arrayMessage = searchResult.split(" ");
        System.out.println(arrayMessage[0] + arrayMessage[1] + arrayMessage[2]);
    }// end of test 4

}// end of class


