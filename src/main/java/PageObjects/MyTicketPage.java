package PageObjects;

import Common.Constant;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {

    private final By buttonCancel = By.xpath("//input[@value='Cancel']");
    /*
     * */
    protected WebElement getButtonCancel() {
        return Constant.DRIVER.findElement(buttonCancel);
    }
    /*
     * */
    public void cancelTicket() {
        WebdriverUtils.scrollDowntoElement(getButtonCancel());
        WebdriverUtils.waitTillClickable(getButtonCancel(),Constant.SHORT_WAIT);
        getButtonCancel().click();
    }

    public void confirmCancel() {
        Constant.DRIVER.switchTo().alert().accept();
    }

    public Boolean findCanceledTicket() {
        try {
            this.getButtonCancel();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
