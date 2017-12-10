package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

    private static WebDriver driver;
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String GECKODRIVER_GECKODRIVER_EXE_PATH = "E:\\Learning\\Testing Software\\PrimeraairAutomation\\src\\webdriver\\geckodriver.exe";

    public WebDriverSingleton() {
    }

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty(WEBDRIVER_GECKO_DRIVER,
                    GECKODRIVER_GECKODRIVER_EXE_PATH);

            driver = new FirefoxDriver();
            driver.manage().window().maximize();

            System.out.println("Firefox Browser is started");
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
