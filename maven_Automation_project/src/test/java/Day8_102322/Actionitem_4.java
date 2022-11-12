package Day8_102322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Actionitem_4 {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome option
        ChromeOptions options = new ChromeOptions();
        // add the options for maximizing the chrome meeting
        options.addArguments("start-maximized");
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        //create array list for destinations
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("Ohio");
        destinations.add("Florida");
        destinations.add("Nevada");
        //create an arraylist for adults
        //had to lower number of adults because couldnt find available rooms
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(3);
        adults.add(4);
        adults.add(5);
        //create an arraylist for children age
        ArrayList<String> kAge = new ArrayList<>();
        kAge.add("1");
        kAge.add("2");
        kAge.add("3");

        //create for loop to iterate through destinations
        for (int i = 0; i < destinations.size(); i++) {
            //navigate to hotels.com
            try {
                driver.navigate().to("https://www.hotels.com");
            } catch (Exception e) {
                System.out.println("Unable to click on Going to.. " + e);
            }
            // wait 3 sec
            Thread.sleep(3000);

            // click on search bar "Going to"
            try {
                driver.findElement(By.xpath("//*[@class= 'uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Going to.. " + e);
            }

            // type in destination
            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destinations.get(i));
                //wait 1 second
                Thread.sleep(1000);
                //click on the first suggestions from the search box
                driver.findElements(By.xpath("//*[@class = 'truncate']")).get(0).click();
                //alternative way to enter your search criteria
                //driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to type in destinations.. " + e);
            }

            // click on travelers
            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on travelers.. " + e);
            }
            // wait a sec
            Thread.sleep(1000);
            //create an arraylist to store all - and + elements
            ArrayList<WebElement> plusMinus = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));
            //click to add one child
            try {
                //this will set the adult size to 1
                plusMinus.get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on + to add a child.. " + e);
            }

            //create for loop for adults age
            //click on the plus icon to change the adult size to n number
            for (int j = 1; j < adults.get(i); j++) {
                // add adults age
                try {
                    //this will click on the adult size plus sign n number of times
                    plusMinus.get(1).click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Unable to add adults age.. " + e);
                }
            }// end of adults loop

            //click to add one child
            try {
                plusMinus.get(3).click();
            } catch (Exception e) {
                System.out.println("Unable to add one child.. " + e);
            }
            //use select command for children
            WebElement child = driver.findElement(By.xpath("//*[@id= 'age-traveler_selector_children_age_selector-0-0']"));
            Select childDropDown = new Select(child);
            //select by value
            try {
                childDropDown.selectByValue(kAge.get(i));
            } catch (Exception e) {
                System.out.println("Unable to select value.. " + e);
            }
            //click done
            try {
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click done.. " + e);
            }
            //click on the search button
            try {
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on the search button.. " + e);
            }
            // wait a couple seconds
            Thread.sleep(3000);


            //create an arraylist for hotels
            ArrayList<WebElement> hotelList = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid= 'open-hotel-information']")));
            //click on first hotel address
            if (i == 0) {
                try {
                    hotelList.get(0).click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Unable to click on first link..." + e);
                }
            }// end of if statement
            else if (i == 1) {
                try {
                    hotelList.get(2).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on third link..." + e);
                }
            }
            // end of 2nd if statement
            else if (i == 2) {
                try {
                    hotelList.get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on second link..." + e);
                }
            }
            //end of 3rd if statement
            // capture all tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            // switch to new tabs
            driver.switchTo().window(tabs.get(1));
            //wait 8 seconds
            Thread.sleep(3000);
            // capture name of the hotel
            try {
                String hotelName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
                //print out hotel name
                System.out.println(hotelName);
            } catch (Exception e) {
                System.out.println("Unable to print out hotel name...." + e);
            }
            //click on reserve
            try {
//                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")).click();
                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }
            // wait two seconds
            Thread.sleep(2000);

            //capture price of hotel
            try {
                String prices = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                // print out price of hotel
                System.out.println(prices);
            } catch (Exception e) {
                System.out.println("Unable to capture the price of the hotel.." + e);
            }

            //click on reserve now
            try {
                driver.findElements(By.xpath("//*[@data-stid= 'submit-hotel-reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }
            // wait a sec
            Thread.sleep(5000);

            //handle pop up window with pay now button
            try {
                WebElement reserveNowPopUp = driver.findElement(By.xpath("//*[@class='uitk-toolbar-title-content']"));
                if (reserveNowPopUp.isDisplayed()) {
                    //if the pop up is displayed then click on pay now
                    driver.findElement(By.xpath("//span[text() = 'Pay now']")).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to find pop up window " + e);
            }
            //capture dates
            try {
                String dates = driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText();
                //print out dates
                System.out.println(dates);
            } catch (Exception e) {
                System.out.println("Unable to capture and print out dates.." + e);
            }
            //close tab
            driver.close();
            //switch back to orignal tab
            driver.switchTo().window(tabs.get(0));
        }//end of destinations loop
        driver.quit();
    }// end of main



}// end of java class
