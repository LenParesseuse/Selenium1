package TestCases;

import Common.Constant;
import Common.Log;
import Common.TestBase;
import Common.WebdriverUtils;
import PageObjects.ContactPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase06 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ContactPage contactPage = new ContactPage();

    @Test(dataProvider = "readData", description = "User is redirected to Home page after logging out from tab Contact")
    public void TC06(Object[] data) {
        Log.info("TC06-Read data");
        String username = data[0].toString();
        String password = data[1].toString();
        homePage.clickOnTabLogin();
        loginPage.logIn(username, password);
        Log.info("TC06-Go to tab Contact");
        homePage.clickOnTabContact();
        Log.info("Logout from Contact Page");
        contactPage.clickOnTabLogOut();
        //Verify whether current page is Homepage
        String currentUrl = WebdriverUtils.getUrlOfPage();
        Assert.assertEquals(currentUrl, Constant.HOMEPAGEURL, "Current url is not Homepage url.");
        //Find tab Logout
        Assert.assertFalse(homePage.findTabLogOut(), "Tab Log out still exists");
    }
}
