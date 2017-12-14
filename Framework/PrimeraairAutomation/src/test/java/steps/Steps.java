package steps;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.*;

public class Steps {

    private WebDriver driver;

    public void initBrowser() {
        driver = WebDriverSingleton.getDriver();
    }

    public void closeDriver(){
        WebDriverSingleton.closeDriver();
    }

    //test-case #1
    public void findTrip(String from, String cityFrom, String to, String cityTo) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchTrip(from, cityFrom, to, cityTo);
    }

    //test-case #2
    public void selectExtras(String from, String cityFrom, String to, String cityTo, String firstName, String lastName,
                                String...date) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.selectExtras(from, cityFrom, to, cityTo, firstName, lastName, date[0], date[1], date[2]);
    }

    //test-case #3
    public void selectPassengers(String from, String cityFrom, String to, String cityTo, String firstName, String lastName,
                                 String email, String city,
                                 String...date) throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.selectPassengers(from, cityFrom, to, cityTo, firstName, lastName, email, city, date[0], date[1], date[2]);
    }

    //test-case #4
    public void bookingManage(String reservationNumber, String lastName){
        ManageBookingPage manageBookingPage = new ManageBookingPage(driver);
        manageBookingPage.openPage();
        manageBookingPage.signIn(reservationNumber, lastName);
    }

    //test-case #5
    public void searchInformationForFees(String query){
        FeesPage feesPage = new FeesPage(driver);
        feesPage.openPage();
        feesPage.searchInfo(query);
    }

    //test-case #6
    public void searchInformationForShopping(String query){
        ShoppingPage shoppingPage = new ShoppingPage(driver);
        shoppingPage.openPage();
        shoppingPage.searchInfo(query);
    }

    //test-case #7
    public boolean sendTextMessageToAdmin(String name, String bookingNumber, String email, String phoneNumber, String message){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.openPage();
        contactUsPage.sendMessage(name, bookingNumber, email, phoneNumber, message);
        return contactUsPage.getMessageFromValidator().equals(null);
    }

    //test-case #8
    public boolean groupBookingRequest(String firstAndLastName, String email, String phoneNumber, String travelerCount){
        GroupsPage groupsPage = new GroupsPage(driver);
        groupsPage.openPage();
        groupsPage.groupBookingRequest(firstAndLastName, email, phoneNumber, travelerCount);
        return groupsPage.getMessagesFromValidators().equals(null);
    }

    //test-case #9
    public void checkLanguage(String language, String url){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.checkLanguageOfPages(language, url);
    }

    //test-case #10
    public boolean goToFacebook() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        return homePage.goToFacebook();
    }

    //test-case #11
    public void logInToAgentPortal(String login, String userName, String password){
        AgentPage agentPage = new AgentPage(driver);
        agentPage.openPage();
        agentPage.logInToAgentPortal(login, userName, password);
    }

    //test-case #12
    public void searchForResource(String query){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchForResource(query);
    }

    //test-case #13
    public void goToPrintPage(){
        CharterPage charterPage = new CharterPage(driver);
        charterPage.openPage();
        charterPage.goToPrintPage();
    }

    //test-case #14
    public void checkIn(String bookingNumber, String lastName) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.checkIn(bookingNumber, lastName);
    }
}
