package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExtrasPage extends AbstractPage {

    private String baseUrl;

    @FindBy(name = "firstName_1")
    private WebElement inputFirstName;

    @FindBy(name = "lastName_1")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@ng-value='passenger.dateOfBirth']")
    private WebElement inputDate;

    @FindBy(xpath = "//button[@ng-click='continue()']")
    private WebElement continueButton;

    public ExtrasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ExtrasPage(WebDriver driver, String url){
        super(driver);
        this.baseUrl = url;
        PageFactory.initElements(this.driver, this);
    }

    public void selectYear(String year){
        WebElement yearSelector = driver.findElement(By.className("yearselect"));
        List<WebElement> years = yearSelector.findElements(By.tagName("option"));
        WebElement inputYear = null;

        yearSelector.click();

        for (WebElement item:
                years) {
            if(item.getAttribute("value").contains(year)){
                inputYear = item;
            }
        }

        if(inputYear != null)
            inputYear.click();
        else
            return;
    }

    public void selectMonth(String month){
        WebElement monthSelector = driver.findElement(By.className("monthselect"));
        List<WebElement> months = monthSelector.findElements(By.tagName("option"));
        WebElement inputMonth = null;

        monthSelector.click();

        for (WebElement item:
                months) {
            if(item.getText().contains(month)){
                inputMonth = item;
            }
        }

        if(inputMonth != null)
            inputMonth.click();
        else
            return;
    }

    public void selectDay(String day){
        WebElement daySelector = driver.findElement(By.className("calendar-table"));
        List<WebElement> days = daySelector.findElements(By.tagName("td"));
        WebElement inputDay = null;

        for (WebElement item:
                days) {
            if(item.getText().contains(day)){
                inputDay = item;
            }
        }

        if(inputDay != null)
            inputDay.click();
        else
            return;
    }

    public void selectExtras(String firstName, String lastName, String year, String month, String day){
        inputFirstName.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.click();
        inputLastName.sendKeys(lastName);

        inputDate.click();
        selectYear(year);
        selectMonth(month);
        selectDay(day);

        continueButton.click();
    }

    public String getMessageFromValidator(){
        return driver.findElement(By.className("flash alert")).getText();
    }
    public void openPage() {
        driver.navigate().to(baseUrl);
    }
}
