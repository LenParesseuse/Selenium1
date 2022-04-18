package PageObjects;

import Common.Constant;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By boxEmail = By.cssSelector("input#username");
    private final By boxPassword = By.cssSelector("input#password");
    private final By buttonLogin = By.cssSelector("input[type='submit']");
    private final By loginErrorMessage = By.cssSelector("p[class='message error LoginForm']");

    /*
     * */
    protected WebElement getBoxEmail() {
        return Constant.DRIVER.findElement(boxEmail);
    }
    protected WebElement getBoxPassword() {
        return Constant.DRIVER.findElement(boxPassword);
    }
    protected WebElement getButtonLogin() {
        return Constant.DRIVER.findElement(buttonLogin);
    }
    protected WebElement getLoginErrorMessage() {
        return Constant.DRIVER.findElement(loginErrorMessage);
    }

    /*
     * */
    public void logIn(String email, String password) {
        getBoxEmail().sendKeys(email);
        getBoxPassword().sendKeys(password);
        WebdriverUtils.scrollDowntoElement(getButtonLogin());
        WebdriverUtils.waitTillClickable(getButtonLogin(),Constant.SHORT_WAIT);
        getButtonLogin().click();
    }

    public void logInManyTimes(String email, String password, int numberOfTimes) {
        int time = 1;
        while (time <= numberOfTimes) {
            getBoxEmail().sendKeys(email);
            getBoxPassword().sendKeys(password);
            WebdriverUtils.scrollDowntoElement(getButtonLogin());
            getButtonLogin().click();
            time++;
        }
    }

    public String getTxtLoginErrorMsg() {
        String txtErrorMsg = "";
        try {
            WebdriverUtils.waitTillVisible(getLoginErrorMessage(), Constant.MEDIUM_WAIT);
            txtErrorMsg = getLoginErrorMessage().getText();
        } catch (NoSuchElementException e) {
            System.out.println("No Login error message found.");
        }
        return txtErrorMsg;
    }

}
