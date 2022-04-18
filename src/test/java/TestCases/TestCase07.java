package TestCases;

import Common.DataFaker;
import Common.Log;
import Common.TestBase;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase07 extends TestBase {
    HomePage homePage=new HomePage();
    RegisterPage registerPage=new RegisterPage();

    @Test(dataProvider = "readData", description = "User can create new account")
    public void TC07(Object[] data) {
        Log.info("TC07-Go to Register page");
        homePage.clickOnTabRegister();
        Log.info("TC07-Create new account");
        String email = DataFaker.generateRandomEmail(data[0].toString());
        String password = data[1].toString();
        String pid = DataFaker.generateString();
        registerPage.registerNewAccount(email, password, password, pid);
        Log.info("TC07-Verify message of successful register");
        String actualMessage = registerPage.getTextRegisterSuccesfully();
        Assert.assertEquals(actualMessage, "You're here", "Message not match");
    }
}
