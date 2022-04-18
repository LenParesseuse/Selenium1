package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends TestBase {
    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(dataProvider = "readData", description = "User can book many tickets at a time")
    public void TC14(Object[] data) {
        Log.info("TC14-Read data");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password=DataFaker.generateString();
        String pid = DataFaker.generateString();
        String departDate = DataFaker.generateDepartDate(data[1].toString());
        String departStation = data[2].toString();
        String arriveStation = data[3].toString();
        String seatType = data[4].toString();
        String ticketAmount = data[5].toString();
        Log.info("TC14-Register and login");
        homePage.clickOnTabRegister();
        registerPage.registerNewAccount(email,password, password, pid);
        registerPage.clickOnTabLogin();
        loginPage.logIn(email, password);
        Log.info("TC14-Book many ticket");
        homePage.clickOnTabBookTicket();
        bookTicketPage.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);
        //compare messages informing successful book
        Assert.assertEquals(bookTicketPage.getTextMessageBookSuccess(), "Ticket Booked Successfully!", "Message not match.");
        //compare booked info
        Assert.assertEquals(bookTicketPage.getInfoBookedDepartDate(), departDate, "Different Depart date");
        Assert.assertEquals(bookTicketPage.getInfoBookedDepartStation(), departStation, "Different Depart Station");
        Assert.assertEquals(bookTicketPage.getInfoBookedAriveStation(), arriveStation, "Different Arrive Station.");
        Assert.assertEquals(bookTicketPage.getInfoBookedSeatType(), seatType, "Different seat type");
        Assert.assertEquals(bookTicketPage.getInfoBookedAmount(), ticketAmount, "Different ticket amount ");
    }
}
