package TestCases;

import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "readData", description = "User cannot login with invalid password")
    public void TC03(Object[] data) {
        Log.info("TC03-Read data");
        String username = data[0].toString();
        String password = data[1].toString();
        Log.info("TC03-Login with invalid password");
        homePage.clickOnTabLogin();
        loginPage.logIn(username, password);
        //Verify login error message
        String expectedErrorMessage = "Invalid username or password. Please try again.";
        Assert.assertEquals(loginPage.getTxtLoginErrorMsg(), expectedErrorMessage, "Error message not match");
    }
}
