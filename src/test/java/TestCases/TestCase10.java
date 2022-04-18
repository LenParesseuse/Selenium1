package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase {
    HomePage homePage=new HomePage();
    RegisterPage registerPage=new RegisterPage();

    @Test(dataProvider = "readData",description = "User can't create account with an already in-use email")
    public void TC10(Object[]data) {
        Log.info("TC10-Go to Register page");
        homePage.clickOnTabRegister();
        Log.info("TC10-Register with already in-use email");
        String email=data[0].toString();
        String password=data[1].toString();
        String pid = DataFaker.generateString();
        registerPage.registerNewAccount(email, password, password, pid);
        Log.info("TC10-Verify error message");
        String expectedMsg = "This email address is already in use.";
        Assert.assertTrue(registerPage.verifyErrorMsgcontains(expectedMsg), "Expected message is not displayed.");
    }
}
