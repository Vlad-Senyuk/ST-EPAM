package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/about-us/contact-us/";

    @FindBy(name = "name")
    private WebElement inputName;

    @FindBy(name = "bookingNumber")
    private WebElement inputBookingNumber;

    @FindBy(name = "email")
    private WebElement inputEmail;

    @FindBy(name = "phoneNumber")
    private WebElement inputPhoneNumber;

    @FindBy(name = "textMessage")
    private WebElement inputMessage;

    @FindBy(className = "flash")
    private WebElement validator;


    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void sendMessage(String name, String bookingNumber, String email, String phoneNumber, String message){
        inputName.sendKeys(name);
        inputBookingNumber.sendKeys(bookingNumber);
        inputEmail.sendKeys(email);
        inputPhoneNumber.sendKeys(phoneNumber);
        inputMessage.sendKeys(message);
    }

    public void sendMessage(String name, String bookingNumber, String email){
        inputName.sendKeys(name);
        inputBookingNumber.sendKeys(bookingNumber);
        inputEmail.sendKeys(email);
    }

    public String getMessageFromValidator(){
        return validator.getText();
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
