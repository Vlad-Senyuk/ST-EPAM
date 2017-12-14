package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/travel-info/shopping-onboard/";

    @FindBy(name = "t")
    private WebElement inputQueryOfSearch;

    @FindBy(className = "icon-search")
    private WebElement searchButton;

    public ShoppingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void searchInfo(String query){
        inputQueryOfSearch.sendKeys(query);
        searchButton.click();
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
