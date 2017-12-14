package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CharterPage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/about-us/charters/";

    //without attributes
    @FindBy(xpath = "/html/body/div[3]/div/div[1]/a[1]/span[2]")
    private WebElement printButton;

    public CharterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void goToPrintPage(){
        printButton.click();
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
