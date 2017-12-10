package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPage extends AbstractPage{

    private final String BASE_URL = "https://agent.primeraair.com/";

    @FindBy(id = "agencycode")
    private WebElement inputLogin;

    @FindBy(id = "username")
    private WebElement inputUserName;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public AgentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void logInToAgentPortal(String login, String userName, String password){
        inputLogin.sendKeys(login);
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password);
        submitButton.click();
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
