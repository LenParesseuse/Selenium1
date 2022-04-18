package TestCases;

import Common.Log;
import Common.TestBase;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(dataProvider = "readData",description = "User cannot change password when New Password and Confirm Password are different")
    public void TC09(Object[]data) {
        Log.info("TC09-Go to Login page");
        homePage.clickOnTabLogin();
        Log.info("TC09-Login");
        String username=data[0].toString();
        String password=data[1].toString();
        loginPage.logIn(username, password);
        Log.info("TC09-Change password");
        homePage.clickOnTabChangePassword();
        String newPassword=data[2].toString();
        String confirmNewPass=data[3].toString();
        changePasswordPage.changePassword(password, newPassword, confirmNewPass);
        Log.info("TC09-Verify error message");
        String expectedErrorMessage = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(changePasswordPage.getTextMessageError(), expectedErrorMessage, "Message not match");
    }
}
