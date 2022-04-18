package TestCases;

import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "readData", description = "System shows message when user tries to login with wrong password several times")
    public void TC05(Object[] data) {
        Log.info("TC05-Go to Login page");
        homePage.clickOnTabLogin();
        Log.info("TC05-Login many time");
        String username = data[0].toString();
        String password = data[1].toString();
        loginPage.logInManyTimes(username, password, 4);
        Log.info("TC05-Verify error message displays after the 4th login with wrong password");
        String expectedErrorMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(loginPage.getTxtLoginErrorMsg(), expectedErrorMessage);
    }
}
