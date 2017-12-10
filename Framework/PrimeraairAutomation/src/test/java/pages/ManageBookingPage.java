package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageBookingPage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/manage-booking/";

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[3]/div[1]/div/form/div/div[1]/div[1]/input")
    private WebElement inputReservationNumber;

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[3]/div[1]/div/form/div/div[1]/div[3]/input")
    private WebElement inputLastName;

    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[3]/div[1]/div/form/div/div[2]/div/button")
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
