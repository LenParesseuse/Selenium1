package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends TestBase {
    HomePage homePage=new HomePage();
    RegisterPage registerPage=new RegisterPage();

    @Test(dataProvider = "readData",description = "User can't create account while password and PID fields are empty")
    public void TC11(Object[]data) {
        Log.info("TC11-Go to Register page");
        homePage.clickOnTabRegister();
        Log.info("TC11-Register with empty password and PID fields");
        String username= DataFaker.generateRandomEmail(data[0].toString());
        registerPage.registerNewAccount(username, "", "", "");
        Log.info("TC11-Verify error message");
        String expectedErrorMessage = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertTrue(registerPage.verifyErrorMsgcontains(expectedErrorMessage));
        Log.info("TC11- Verify messages beside Password and PID fields");
        Assert.assertEquals(registerPage.getTextMessagePasword(), "Invalid password length");
        Assert.assertEquals(registerPage.getTextMessagePID(), "Invalid ID length");
    }
}
