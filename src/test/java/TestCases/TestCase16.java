package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 extends TestBase {
    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(dataProvider = "readData", description = "User can cancel a ticket")
    public void TC16(Object[] data)throws InterruptedException {
        Log.info("TC16-Go to Register page");
        homePage.clickOnTabRegister();
        Log.info("TC16-Register");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password=DataFaker.generateString();
        String pid = DataFaker.generateString();
        registerPage.registerNewAccount(email, password,password,pid);
        Log.info("TC16-Login");
        registerPage.clickOnTabLogin();
        loginPage.logIn(email, password);
        Log.info("TC16- Book ticket");
        homePage.clickOnTabBookTicket();
        String departDate = DataFaker.generateDepartDate(data[1].toString());
        String departStation = data[2].toString();
        String arriveStation = data[3].toString();
        String seatType = data[4].toString();
        String ticketAmount = data[5].toString();
        bookTicketPage.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);
        Log.info("TC16- Cancel ticket");
        bookTicketPage.clickOnTabMyTicket();
        myTicketPage.cancelTicket();
        myTicketPage.confirmCancel();
        Thread.sleep(1000);
        Log.info("TC16- Verify cancelled tickets disappered");
        Assert.assertFalse(myTicketPage.findCanceledTicket(),"There still have uncancelled tickets");
    }
}
