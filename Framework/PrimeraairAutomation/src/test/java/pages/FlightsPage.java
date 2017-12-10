package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends AbstractPage {

    private String baseUrl;

    @FindBy(xpath = "/html/body/div[3]/div/form/div[1]/div[1]/div[3]/div/div[2]/div/div/button[2]")
    private WebElement continueButton;

    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public FlightsPage(WebDriver driver, String url){
        super(driver);
        this.baseUrl = url;
        PageFactory.initElements(this.driver, this);
    }

    public void nextPage(){
        continueButton.click();
    }

    public void openPage() {
        driver.navigate().to(baseUrl);
    }
}
