package PageObjects;

import Common.Constant;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage{
    private final By boxCurentPassword = By.cssSelector("#currentPassword");
    private final By boxNewPassword = By.cssSelector("#newPassword");
    private final By boxConfirmPassword = By.cssSelector("#confirmPassword");
    private final By buttonChangePassword =By.cssSelector("input[type='submit'][value='Change Password']");
    private final By messageError =By.cssSelector("p[class='message error']");
    /*
     * */
    protected WebElement getBoxCurentPassword(){return Constant.DRIVER.findElement(boxCurentPassword);}
    protected WebElement getBoxNewPassword(){return Constant.DRIVER.findElement(boxNewPassword);}
    protected WebElement getBoxConfirmPassword(){return Constant.DRIVER.findElement(boxConfirmPassword);}
    protected WebElement getButtonChangePassword(){return Constant.DRIVER.findElement(buttonChangePassword);}
    protected WebElement getMessageError(){return Constant.DRIVER.findElement(messageError);}
    /*
     * */
    public void enterCurentPassword(String currentPassword){getBoxCurentPassword().sendKeys(currentPassword);}
    public void enterNewPassword(String newPassword){getBoxNewPassword().sendKeys(newPassword);}
    public void confirmPassword(String confirmPassword){getBoxConfirmPassword().sendKeys(confirmPassword);}
    public void clickButtonChangePassword(){
        WebdriverUtils.scrollDowntoElement(getButtonChangePassword());
        getButtonChangePassword().click();
    }
    public void changePassword(String currentPassword,String newPassword,String confirmNewPassword){
        enterCurentPassword(currentPassword);
        enterNewPassword(newPassword);
        confirmPassword(confirmNewPassword);
        this.clickButtonChangePassword();
    }
    public String getTextMessageError(){return getMessageError().getText();}
}
