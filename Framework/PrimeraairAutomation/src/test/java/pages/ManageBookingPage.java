package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageBookingPage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/manage-booking/";

    @FindBy(name = "reservationNumber")
    private WebElement inputReservationNumber;

    @FindBy(name = "lastName")
    private WebElement inputLastName;

    @FindBy(name = "//button[@ng-click='submitLogin()']")
    private WebElement signInButton;

    public ManageBookingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void signIn(String reservationNumber, String lastName){
        inputReservationNumber.sendKeys(reservationNumber);
        inputLastName.sendKeys(lastName);
        signInButton.click();
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
