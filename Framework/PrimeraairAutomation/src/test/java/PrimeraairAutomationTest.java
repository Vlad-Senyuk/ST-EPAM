import helpers.Helper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class PrimeraairAutomationTest {

    private final String HOME_FROME = "Iceland";
    private final String HOME_CITY_FROM = "Reykjavík";
    private final String HOME_TO = "Italy";
    private final String HOME_CITY_TO = "Trieste";
    private final String EMAIL = "test_email";
    private final String CITY = "test_city";
    private final String LANGUAGE = "Fran";
    private final String URL = "https://primeraair.com/travel-info/fees/";

    private Steps steps;
    private Random random;

    @BeforeMethod
    public void setUp(){
        steps = new Steps();
        steps.initBrowser();
        random = new Random();
    }

    @Test
    public void findTrip(){
        try {
            steps.findTrip(HOME_FROME, HOME_CITY_FROM, HOME_TO, HOME_CITY_TO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectExtras() {
        try {
            steps.selectExtras(HOME_FROME, HOME_CITY_FROM, HOME_TO, HOME_CITY_TO,
                    Helper.getRandomString(10),
                    Helper.getRandomString(10),
                    String.valueOf(random.nextInt(2017)),
                    String.valueOf(random.nextInt(12)),
                    String.valueOf(random.nextInt(30)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectPassengers() {
        try {
            steps.selectPassengers(HOME_FROME, HOME_CITY_FROM, HOME_TO, HOME_CITY_TO,
                    Helper.getRandomString(10),
                    Helper.getRandomString(10),
                    EMAIL, CITY,
                    String.valueOf(random.nextInt(2017)),
                    String.valueOf(random.nextInt(12)),
                    String.valueOf(random.nextInt(30)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bookingManage(){
        steps.bookingManage(
                Helper.getRandomString(15),
                Helper.getRandomString(20)
        );
    }

    @Test
    public void searchInformationForFees(){
        steps.searchInformationForFees("");
    }

    @Test
    public void searchInformationForShopping(){
        steps.searchInformationForShopping(Helper.getRandomString(20));
    }

    @Test
    public void sendTextMessageToAdmin(){
        boolean hasMessage = steps.sendTextMessageToAdmin(
                Helper.getRandomString(15),
                Helper.getRandomString(15),
                EMAIL,
                Helper.getRandomString(15),
                Helper.getRandomString(30)
        );
        assertEquals(hasMessage, true);
    }

    @Test
    public void groupBookingRequest(){
        boolean hasMessage = steps.groupBookingRequest(
                Helper.getRandomString(30),
                EMAIL,
                Helper.getRandomString(10),
                String.valueOf(random.nextInt(100))
        );

        assertEquals(hasMessage, true);
    }

    @Test
    public void checkLanguage(){
        steps.checkLanguage(
                LANGUAGE,
                URL
        );
    }

    @Test
    public void goToFacebook(){
        try {
            boolean hasLink = steps.goToFacebook();
            assertEquals(hasLink, true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void logInToAgentPortal(){
        steps.logInToAgentPortal(
                Helper.getRandomString(20),
                Helper.getRandomString(20),
                Helper.getRandomString(20)
        );
    }

    @Test
    public void searchForResource(){
        steps.searchForResource(Helper.getRandomString(100));
    }

    @Test
    public void goToPrintPage(){
        steps.goToPrintPage();
    }

    @Test
    public void checkIn() {
        try {
            steps.checkIn(
                    Helper.getRandomString(10),
                    Helper.getRandomString(20)
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closeFromBrowser(){
        steps.closeDriver();
    }
}
