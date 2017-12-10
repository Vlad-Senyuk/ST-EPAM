package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/about-us/contact-us/";

    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div/form[1]/div/div/div/div/div[1]/div/input")
    private WebElement inputName;

    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div/form[1]/div/div/div/div/div[2]/div/input")
    private WebElement inputBookingNumber;

    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div/form[1]/div/div/div/div/div[3]/div/input")
    private WebElement inputEmail;

    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div/form[1]/div/div/div/div/div[4]/div/input")
    private WebElement inputPhoneNumber;

    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div/form[1]/div/div/div/div/div[6]/div/textarea")
    private WebElement inputMessage;

    @FindBy(xpath = "/html/body/div[3]/div/div[4]/div/div[1]")
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
