package pages;

import helpers.Type;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends AbstractPage {

    private final String BASE_URL = "https://primeraair.com/";

    @FindBy(id = "from_string")
    private WebElement inputFromName;

    @FindBy(id = "to_string")
    private WebElement inputToName;

    @FindBy(id = "departure_string")
    private WebElement inputDepartureName;

    @FindBy(id = "arrive_string")
    private WebElement inputArriveName;

    @FindBy(xpath = "/html/body/section/div[3]/div[1]/div/div/div[1]/div[1]/form/div[4]/div[4]/button")
    private WebElement searchTripButton;

    @FindBy(xpath = "/html/body/div[1]/nav/div/div[2]/ul/li[5]/a/i")
    private WebElement languageButton;

    @FindBy(xpath = "/html/body/div[1]/nav/div/div[2]/ul/li[6]/a/i")
    private WebElement searchButton;

    @FindBy(id = "search-input")
    private WebElement inputSearch;

    @FindBy(xpath = "/html/body/div[1]/nav/div/div[2]/ul/li[6]/ul/li/form/div/span/button")
    private WebElement searchSubmit;

    @FindBy(xpath = "/html/body/section/div[3]/div[1]/div/div/div[1]/div[1]/form/div[4]/div[5]/div[2]/div/div/div[1]/div[2]")
    private WebElement countOfPassengersButton;

    //@FindBy(xpath = "/html/body/footer/div[1]/div/div[1]/div[2]/div/a[1]")
    //private WebElement facebookButton;

    @FindBy(xpath = "//div[@class='container']//a[@href='https://www.facebook.com/primeraair']")
    private WebElement facebookButton;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']//a[@href='#check_in']")
    private WebElement checkInItem;

    @FindBy(name = "booking_number")
    private WebElement inputBookingNumber;

    @FindBy(name = "to_string")
    private WebElement inputLastName;

    @FindBy(xpath = "//div[@class='col-sm-3']//button[@class='btn btn-primary btn-block']")
    private WebElement checkInButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void checkIn(String bookingNumber, String lastName) throws InterruptedException {
        checkInItem.click();
        Thread.sleep(3000);
        inputBookingNumber.click();
        inputBookingNumber.sendKeys(bookingNumber);
        inputLastName.click();
        inputLastName.sendKeys(lastName);
        checkInButton.click();
    }

    public void checkLanguageOfPages(String language, String url){
        languageButton.click();
        setLanguage(language);
        goToPage(url);
    }

    private void setLanguage(String language){
        WebElement rootElement = driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/ul/li[5]/ul"));
        List<WebElement> selectedLanguage = rootElement.findElements(By.className("col-sm-4"));

        WebElement selectedElement = null;

        for (int i = 0; i < selectedLanguage.size(); i++) {
            if(selectedLanguage.get(i).findElement(By.tagName("a")).getText().contains(language)){
                selectedElement = selectedLanguage.get(i);
            }
        }

        try {
            selectedElement.click();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void goToPage(String url){
        driver.navigate().to(url);
    }

    public void searchForResource(String query){
        searchButton.click();
        inputSearch.sendKeys(query);
        searchSubmit.click();
    }

    public void searchTrip(String from, String cityFrom, String to, String cityTo) throws InterruptedException {
        inputFromName.click();
        selectCountry(from, Type.From).click();
        selectCity(cityFrom, Type.From).click();
        inputToName.click();
        selectCountry(to, Type.To).click();
        selectCity(cityTo, Type.To).click();
        Thread.sleep(5000);
        selectEnabledDateOfTrip(Type.From).click();
        Thread.sleep(2000);
        selectEnabledDateOfTrip(Type.To).click();
        countOfPassengersButton.click();
        searchTripButton.click();
    }

    public void skipFlightsPage(String from, String cityFrom, String to, String cityTo) throws InterruptedException {
        searchTrip(from, cityFrom, to, cityTo);
        Thread.sleep(10000);
        new FlightsPage(driver, driver.getCurrentUrl()).nextPage();
    }

    /* TODO String...date: format arg0 - yyyy, arg1 - mm, arg2 - dd */
    public void selectExtras(String from, String cityFrom, String to, String cityTo, String firstName, String lastName,
                             String...date)
            throws InterruptedException {
        skipFlightsPage(from, cityFrom, to, cityTo);
        Thread.sleep(20000);
        ExtrasPage extrasPage = new ExtrasPage(driver, driver.getCurrentUrl());
        extrasPage.selectExtras(firstName, lastName, date[0], date[1], date[2]);
    }

    /* TODO String...date: format arg0 - yyyy, arg1 - mm, arg2 - dd */
    public void selectPassengers(String from, String cityFrom, String to, String cityTo, String firstName, String lastName,
                                 String email, String city,
                                 String...date) throws InterruptedException{
        selectExtras(from, cityFrom, to, cityTo, firstName, lastName, date[0], date[1], date[2]);
        Thread.sleep(20000);
        new PassengersPage(driver, driver.getCurrentUrl()).fillInfoFromPassengers(email, city);
    }

    private WebElement selectCountry(String from, Type type){
        WebElement retWebElement = null;

        WebElement rootElement = null;

        if(type.equals(Type.From)) {
            rootElement = driver.findElement(
                    By.xpath("/html/body/section/div[3]/div[1]/div/div/div[1]/div[1]/form/div[2]/div[4]/div[2]/div[2]/div[1]/div")
            );
        }else if(type.equals(Type.To)){
            rootElement = driver.findElement(
                    By.xpath("/html/body/section/div[3]/div[1]/div/div/div[1]/div[1]/form/div[2]/div[5]/div[2]/div[2]/div[1]/div")
            );
        }

        List<WebElement> elements = rootElement.findElements(By.tagName("a"));

        for (WebElement item:
             elements) {
            if (item.getText().contains(from)){
                retWebElement = item;
            }
        }

        return retWebElement;
    }

    private WebElement selectCity(String city, Type type){
        WebElement retWebElement = null;
        WebElement rootElement = null;

        if(type.equals(Type.From)) {
            rootElement = driver.findElement(
                    By.xpath("/html/body/section/div[3]/div[1]/div/div/div[1]/div[1]/form/div[2]/div[4]/div[2]/div[2]/div[2]")
            );
        }else if(type.equals(Type.To)){
            rootElement = driver.findElement(
              By.xpath("//*[@id=\"populate_to_airports\"]")
            );
        }

        List<WebElement> elements = rootElement.findElements(By.tagName("div"));

        for (WebElement item:
                elements) {
            if (item.getText().contains(city)){
                retWebElement = item;
            }
        }

        return retWebElement;
    }

    private WebElement selectEnabledDateOfTrip(Type type){
        WebElement rootElement = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div/div/div[1]/div[1]/form/div[6]/div[2]"));
        List<WebElement> elements = rootElement.findElements(By.tagName("td"));
        WebElement firstEnabledDate = null;

        if (type.equals(Type.From)) {
            for (WebElement item :
                    elements) {
                if (!item.getAttribute("class").contains("disabled")) {
                    firstEnabledDate = item;
                    break;
                }
            }
        }else if(type.equals(Type.To)) {
            for (int i = elements.size() - 1; i > -1; --i) {
                if (!elements.get(i).getAttribute("class").contains("disabled")) {
                    firstEnabledDate = elements.get(i);
                    break;
                }
            }
        }

        return firstEnabledDate;
    }

    public boolean goToFacebook() throws InterruptedException {
        facebookButton.click();
        return checkLinksOfFacebookBtnAndPage();
    }

    public String getLinkFromFacebookButton(){
        return facebookButton.getAttribute("href");
    }

    public boolean checkLinksOfFacebookBtnAndPage(){
        return getLinkFromFacebookButton().equals(null);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
