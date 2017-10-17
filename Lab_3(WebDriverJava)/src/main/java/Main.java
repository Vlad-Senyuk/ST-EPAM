import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Main {

    @Test
    private static void testMethod(){
        System.setProperty("webdriver.chrome.driver", ".//src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.github.com/");

        WebElement buttonSignIn = driver.findElement(By.xpath("//a[text() = 'Sign in']"));
        buttonSignIn.click();

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='login_field']"));
        inputUsername.sendKeys("Hello from Selenium");
    }

    public static void main(String[] args){
        testMethod();
    }
}
