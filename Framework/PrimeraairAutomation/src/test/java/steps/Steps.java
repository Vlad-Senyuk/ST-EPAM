package steps;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class Steps {

    private WebDriver driver;

    public void initBrowser() {
        driver = WebDriverSingleton.getDriver();
    }

    public void closeDriver(){
        WebDriverSingleton.closeDriver();
    }

    //test-case #1
    public void findTrip(String from, String cityFrom, String to, String cityTo) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchTrip(from, cityFrom, to, cityTo);
    }

    //test-case #2
    public void selectExtras(String from, String cityFrom, String to, String cityTo, String firstName, String lastName,
                                String...date) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.selectExtras(from, cityFrom, to, cityTo, firstName, lastName, date[0], date[1], date[2]);
    }

    //test-case #3
    public void selectPassengers(String from, String cityFrom, String to, String cityTo, String firstName, String lastName,
                                 String email, String city,
                                 String...date) throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.selectPassengers(from, cityFrom, to, cityTo, firstName, lastName, email, city, date[0], date[1], date[2]);
    }

    //test-case #4
}
