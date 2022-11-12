package Day12_110622;

import Reusable_library_Loggers.Reusable_Actions;
import Reusable_library_Loggers.Reusable_Annotations;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Actionitem_6 extends Reusable_Annotations {

    @BeforeSuite
    public void setChromeDriver() {

        driver = Reusable_Actions.setUpDriver();
    }//end of set up driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of the after suite

    @Test()
    public void personalbanking () throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.pnc.com/en/personal-banking/banking/online-and-mobile-banking/online-banking.html/");
        //wait a bit
        //Thread.sleep(2000);
        Reusable_Actions.clickAction(driver, "//*[class=cmp-listpro__item-text']", "cilcik on learing");
        Reusable_Actions.clickAction(driver, "//*[//*[ class=cmp-listpro__item-text')](0)='click on save']", "");
//switch tabs
        Reusable_Actions.switchToTabsAction(driver, 1);
        Thread.sleep(2000);
        Reusable_Actions.clickAction(driver, "//*[text()='Invest ']", "invest");
    }
        @Test(dependsOnMethods = "bank brenchs")
        public void menu() {

            Reusable_Actions.clickActionByIndex(driver, "//*[@cmp-listpro__item-text(1)']", 0, "support");
            //click on save button
            Reusable_Actions.clickActionByIndex(driver, "//*[@class=cmp-listpro__item-text']", 2, "Auto loans");
            //capture address, miles, & network type
            String info = Reusable_Actions.getTextAction(driver, "//*[@class='outer-container tbl']", "Address, Miles, & Network Type");
            //print out information
            System.out.println(info);
            //close out the tab
            driver.close();
        }//test 3
        @Test(dependsOnMethods = "small business")
        public void doctor() throws InterruptedException {
            //switch back to default tab
            Reusable_Actions.switchToTabsAction(driver, 0);
            //navigate back to website
            driver.navigate().to("https://www.pnc.com/en/personal-banking.html?lnksrc=topnav/");
            Thread.sleep(1000);

            Reusable_Actions.sendKeysAction(driver, "//*[@class=cmp-listpro__item aem-GridColumn']", "samll business", "small Business");

            Reusable_Actions.clickAction(driver, "//*[@class=cmp-listpro__item aem-GridColumn(0)']", "");

            String searchResult = Reusable_Actions.getTextAction(driver, "//*[@class=cmp-listpro__item aem-GridColumn']", "Search ");

            String[] arrayMessage = searchResult.split(" ");
            System.out.println(arrayMessage[0] + arrayMessage[1] + arrayMessage[2]);
        }// end of test 4
    }



