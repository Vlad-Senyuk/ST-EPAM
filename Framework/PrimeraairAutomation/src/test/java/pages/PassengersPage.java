package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassengersPage extends AbstractPage {

    private String baseUrl;

    @FindBy(id = "passenger_email")
    private WebElement inputEmail;

    @FindBy(id = "passenger_emailconfirm")
    private WebElement inputEmailConfirm;

    @FindBy(id = "passenger_city")
    private WebElement inputCity;

    @FindBy(xpath = "//button[@ng-click='continue()']")
    private WebElement continueButton;

    public PassengersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PassengersPage(WebDriver driver, String url) {
        super(driver);
        this.baseUrl = url;
        PageFactory.initElements(this.driver, this);
    }

    public void fillInfoFromPassengers(String email, String city){
        inputEmail.sendKeys(email);
        inputEmailConfirm.sendKeys(email);
        inputCity.sendKeys(city);
    }

    public void openPage() {
        driver.navigate().to(baseUrl);
    }
}
