package TestCases;

import Common.Log;
import Common.TestBase;
import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase04 extends TestBase {
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    BasePage page=new BasePage();

    @Test(dataProvider = "readData",description = "User is redirected to Book ticket page after login")
    public void TC04(Object[]data) {
        Log.info("TC04-Go to tab Book ticket");
        homePage.clickOnTabBookTicket();
        Log.info("TC04-Login");
        String username=data[0].toString();
        String password=data[1].toString();
        loginPage.logIn(username,password);
        Log.info("TC04-Verify current page is Book ticket page");
        String currentPage = page.getTextPageHeader();
        Assert.assertEquals(currentPage, "Book ticket", "User is directed to " + currentPage);
    }
}
