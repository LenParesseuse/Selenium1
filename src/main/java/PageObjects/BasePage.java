package PageObjects;

import Common.Constant;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final By header = By.cssSelector("div#content h1");
    private final By textWelcomeAccount= By.cssSelector("div.account strong");
    private final By tabLogin= By.xpath("//a//span[text()='Login']");
    private final By tabLogout= By.xpath("//a//span[text()='Log out']");
    private final By tabTimetable= By.xpath("//a//span[text()='Timetable']");
    private final By tabBookTicket= By.xpath("//a//span[text()='Book ticket']");
    private final By tabRegister= By.xpath("//a//span[text()='Register']");
    private final By tabContact= By.xpath("//a//span[text()='Contact']");
    private final By tabChangePassword= By.xpath("//a//span[text()='Change password']");
    private final By tabMyTicket= By.xpath("//a//span[text()='My ticket']");
    /*
     * */
    protected WebElement getPageHeader() {return Constant.DRIVER.findElement(header);}
    protected WebElement getBlockWelcomeAccount(){return Constant.DRIVER.findElement(textWelcomeAccount);}
    protected WebElement getTabLogin() {return Constant.DRIVER.findElement(tabLogin);}
    protected WebElement getTabLogout(){return Constant.DRIVER.findElement(tabLogout);}
    protected WebElement getTabTimetable() {return Constant.DRIVER.findElement(tabTimetable);}
    protected WebElement getTabBookTicket(){return Constant.DRIVER.findElement(tabBookTicket);}
    protected WebElement getTabRegister(){return Constant.DRIVER.findElement(tabRegister);}
    protected WebElement getTabContact(){return Constant.DRIVER.findElement(tabContact);}
    protected WebElement getTabChangePassword(){return Constant.DRIVER.findElement(tabChangePassword);}
    protected WebElement getTabMyTicket(){return Constant.DRIVER.findElement(tabMyTicket);}
    /*
     * */
    public String getTextPageHeader(){return getPageHeader().getText();}
    public String getTextWelcomeAccount(){return getBlockWelcomeAccount().getText();}
    public void clickOnTabLogin(){getTabLogin().click();}
    public void clickOnTabLogOut(){getTabLogout().click();}
    public void clickOntabTimetable(){getTabTimetable().click();}
    public void clickOnTabBookTicket(){getTabBookTicket().click();}
    public void clickOnTabRegister(){getTabRegister().click();}
    public void clickOnTabContact(){getTabContact().click();}
    public void clickOnTabChangePassword(){getTabChangePassword().click();}
    public void clickOnTabMyTicket(){getTabMyTicket().click();}
    public Boolean findTabLogOut(){
        try {
            WebdriverUtils.waitTillVisible(getTabLogout(),5);
            return true;}
        catch(NoSuchElementException ex){return false;}
    }
    public Boolean verifyUsername(String userName){
        return getTextWelcomeAccount().contains(userName);
    }
}
