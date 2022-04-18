package PageObjects;

import Common.Constant;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    private final By boxEmail = By.cssSelector("#email");
    private final By boxPassword = By.cssSelector("#password");
    private final By boxConfirmPassword = By.cssSelector("#confirmPassword");
    private final By boxPIDnumber = By.cssSelector("#pid");
    private final By buttonRegister = By.cssSelector("input[type='submit']");
    private final By messageSuccessfulRegister = By.cssSelector("#content p");
    private final By messageError = By.cssSelector("#content p[class='message error']");
    private final By messagePassword = By.cssSelector("label[for='password'][class='validation-error']");
    private final By messagePID = By.cssSelector("label[for='pid'][class='validation-error']");

    /*
     * */
    protected WebElement getBoxEmail() {
        return Constant.DRIVER.findElement(boxEmail);
    }

    protected WebElement getBoxPassword() {
        return Constant.DRIVER.findElement(boxPassword);
    }

    protected WebElement getBoxConfirmPassword() {
        return Constant.DRIVER.findElement(boxConfirmPassword);
    }

    protected WebElement getBoxPIDnumber() {
        return Constant.DRIVER.findElement(boxPIDnumber);
    }

    protected WebElement getButtonRegister() {
        return Constant.DRIVER.findElement(buttonRegister);
    }

    protected WebElement getMessageRegisterSuccess() {
        return Constant.DRIVER.findElement(messageSuccessfulRegister);
    }

    protected WebElement getMessageError() {
        return Constant.DRIVER.findElement(messageError);
    }

    protected WebElement getMessagePassword() {
        return Constant.DRIVER.findElement(messagePassword);
    }

    protected WebElement getMessagePID() {
        return Constant.DRIVER.findElement(messagePID);
    }

    /*
     * */
    public void enterEmail(String email) {
        WebdriverUtils.waitTillVisible(getBoxEmail(),Constant.SHORT_WAIT);
        getBoxEmail().sendKeys(email);
    }

    public void enterPassword(String password) {
        WebdriverUtils.waitTillVisible(getBoxPassword(),Constant.SHORT_WAIT);
        getBoxPassword().sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebdriverUtils.waitTillVisible(getBoxConfirmPassword(),Constant.SHORT_WAIT);
        getBoxConfirmPassword().sendKeys(password);
    }

    public void enterPIDnumber(String pIDnumber) {
        WebdriverUtils.waitTillVisible(getBoxPIDnumber(),Constant.SHORT_WAIT);
        getBoxPIDnumber().sendKeys(pIDnumber);
    }

    public void clickButtonRegister() {
        WebdriverUtils.scrollDowntoElement(getButtonRegister());
        WebdriverUtils.waitTillClickable(getButtonRegister(),Constant.SHORT_WAIT);
        getButtonRegister().click();
    }

    public void registerNewAccount(String email, String password, String confirmpassword, String pIDnumber) {
        this.enterEmail(email);
        this.enterPassword(password);
        this.confirmPassword(confirmpassword);
        this.enterPIDnumber(pIDnumber);
        this.clickButtonRegister();
    }

    public String getTextRegisterSuccesfully() {
        return getMessageRegisterSuccess().getText();
    }

    public String getTextMessageError() {
        try {
            return getMessageError().getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public Boolean verifyErrorMsgcontains(String expectedMessage) {
        return getTextMessageError().contains(expectedMessage);
    }

    public String getTextMessagePasword() {
        try {
            return getMessagePassword().getText();
        }catch(NoSuchElementException e){
            return "";
        }
    }

    public String getTextMessagePID() {
        try {
            return getMessagePID().getText();
        }catch(NoSuchElementException e){
            return "";
        }
    }

}
