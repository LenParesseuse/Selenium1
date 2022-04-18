package TestCases;

import Common.Log;
import Common.TestBase;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase15 extends TestBase {
    HomePage homePage = new HomePage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "readData",description = "TicketPricePage displays with ticket details after clicking on Check price link in Train timetable page")
    public void TC15(Object[]data) {
        Log.info("TC15-Go to Login page");
        homePage.clickOnTabLogin();
        Log.info("TC15-Login");
        String username=data[0].toString();
        String password= data[1].toString();
        loginPage.logIn(username, password);
        Log.info("TC15-Check price");
        homePage.clickOntabTimetable();
        String departFrom= data[2].toString();
        String arriveAt= data[3].toString();
        timetablePage.clickLinkCheckPrice(departFrom, arriveAt);
        Log.info("TC15-Compare trip info");
        String expectedsmallHeader = "Ticket price from "+departFrom+" to "+arriveAt;
        Assert.assertEquals(ticketPricePage.getTextofSmallHeader(), expectedsmallHeader,"Trip not match.");
        Log.info("TC15-Compare prices of each seat type");
        String[] actualList = ticketPricePage.listPriceOfEachSeatType();
        String[] expectedList = {data[4].toString(), data[5].toString(), data[6].toString(),
                data[7].toString(), data[8].toString(), data[9].toString()};
        Assert.assertTrue(ticketPricePage.compareTicketPrice(actualList,expectedList),"Prices not match.");
    }
}
