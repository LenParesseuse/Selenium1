package TestCases;

import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "readData", description = "User cannot login with blank Username textbox")
    public void TC02(Object[] data) {
        Log.info("TC02-Read data");
        String password = data[0].toString();
        Log.info("TC02-Login with blank username");
        homePage.clickOnTabLogin();
        loginPage.logIn("", password);
        //Verify login error message
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(loginPage.getTxtLoginErrorMsg(), expectedErrorMsg, "Error message does not match.");
    }
}
