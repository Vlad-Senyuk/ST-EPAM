import driver.WebDriverSingleton;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class PrimeraairAutomationTest {
    private HomePage page;

    @BeforeMethod
    public void setUp(){
        page = new HomePage(WebDriverSingleton.getDriver());
    }

    @Test
    public void firstTest() throws InterruptedException {
        page.openPage();
        page.checkIn(",3535", "...547475...");
    }
}
