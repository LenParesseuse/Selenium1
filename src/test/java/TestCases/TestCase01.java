package TestCases;

import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "readData", description = "User can login with valid username and password")
    public void TC01(Object[] data) {
        Log.info("TC01-Click on Login tab");
        homePage.clickOnTabLogin();
        Log.info("TC01-Login with valid info");
        String username = data[0].toString();
        String password = data[1].toString();
        loginPage.logIn(username, password);
        Log.info("TC01-Verify username displays in welcome message");
        Assert.assertTrue(homePage.verifyUsername(username), "Username is not displayed in Welcome message");
    }
}
