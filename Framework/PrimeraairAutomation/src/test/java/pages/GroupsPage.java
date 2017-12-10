package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GroupsPage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/about-us/groups/";

    @FindBy(id = "group_firstname_surname")
    private WebElement inputFirstAndLasnName;

    @FindBy(id = "group_email")
    private WebElement inputEmail;

    @FindBy(id = "group_phone_contact")
    private WebElement inputPhone;

    @FindBy(id = "group_traveler_count")
    private WebElement inputTravelerCount;

    public GroupsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void groupBookingRequest(String firstAndLastName, String email, String phoneNumber, String travelerCount){
        inputFirstAndLasnName.sendKeys(firstAndLastName);
        inputEmail.sendKeys(email);
        inputPhone.sendKeys(phoneNumber);
        inputTravelerCount.sendKeys(travelerCount);
    }

    public String getMessagesFromValidators(){
        StringBuilder fullMessage = new StringBuilder();
        List<WebElement> validators = driver.findElements(By.className("flash"));

        for (WebElement item:
             validators) {
            fullMessage.append(item.getText() + "\n");
        }

        return fullMessage.toString();
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
