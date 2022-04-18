package PageObjects;

import Common.Constant;
import Common.Log;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage{
    private final By boxDepartDate=By.cssSelector("select[name='Date']");
    private final By boxDepartFrom= By.cssSelector("select[name='DepartStation']");
    private final By boxArriveAt= By.cssSelector("#ArriveStation select");
    private final By boxSeatType=By.cssSelector("select[name='SeatType']");
    private final By boxTicketAmount=By.cssSelector("select[name='TicketAmount']");
    private final By buttonBookTicket=By.cssSelector("input[value='Book ticket']");
    private final By infoBookedDepartDate=
            By.xpath("//td[count(//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By infoBookedDepartStation=
            By.xpath("//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By infoBookedArriveStation=
            By.xpath("//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By infoBookedSeatType=
            By.xpath("//td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private final By infoBookedTicketAmount=
            By.xpath("//td[count(//th[text()='Amount']/preceding-sibling::th)+1]");
    /*
     * */
    protected WebElement getBoxDepartDate(){return Constant.DRIVER.findElement(boxDepartDate);}
    protected WebElement getBoxDepartFrom(){return Constant.DRIVER.findElement(boxDepartFrom);}
    protected WebElement getBoxArriveAt(){return Constant.DRIVER.findElement(boxArriveAt);}
    protected WebElement getBoxSeatType(){return Constant.DRIVER.findElement(boxSeatType);}
    protected WebElement getBoxTicketAmount(){return Constant.DRIVER.findElement(boxTicketAmount);}
    protected WebElement getButtonBookTicket(){return Constant.DRIVER.findElement(buttonBookTicket);}

    /*
     * */
    public void selectDepartDate(String departDate){
        WebdriverUtils.scrollDowntoElement(getBoxDepartDate());
        Select selectDate= new Select(getBoxDepartDate());
        selectDate.selectByVisibleText(departDate);
    }
    public void selectDepartStation(String departStation){
        WebdriverUtils.scrollDowntoElement(getBoxDepartFrom());
        Select selectDepart= new Select(getBoxDepartFrom());
        selectDepart.selectByVisibleText(departStation);
    }
    public void selectArriveStation(String arrStation){
        WebdriverUtils.scrollDowntoElement(getBoxArriveAt());
        Select selectArr= new Select(getBoxArriveAt());
        selectArr.selectByVisibleText(arrStation);
    }
    public void selectSeatType(String seat){
        WebdriverUtils.scrollDowntoElement(getBoxSeatType());
        Select selectSeattype= new Select(getBoxSeatType());
        selectSeattype.selectByVisibleText(seat);
    }
    public void selectTicketAmount(String amount){
        WebdriverUtils.scrollDowntoElement(getBoxTicketAmount());
        Select selectAmount= new Select(getBoxTicketAmount());
        selectAmount.selectByVisibleText(amount);
    }
    public void clickButtonBookTicket(){
        WebdriverUtils.scrollDowntoElement(getButtonBookTicket());
        WebdriverUtils.waitTillClickable(getButtonBookTicket(),Constant.SHORT_WAIT);
        getButtonBookTicket().click();
    }
    public void bookTicket(String date,String departStation,String arrStation,String seat,String ticketAmount){
        this.selectDepartDate(date);
        this.selectDepartStation(departStation);
        try{Thread.sleep(Constant.SHORT_SLEEP);}catch (InterruptedException e){
            Log.error("Interupted Exception");}
        this.selectArriveStation(arrStation);
        this.selectSeatType(seat);
        this.selectTicketAmount(ticketAmount);
        this.clickButtonBookTicket();
    }
    public String getTextMessageBookSuccess(){return getTextPageHeader();}
    public String getInfoBookedDepartDate(){return Constant.DRIVER.findElement(infoBookedDepartDate).getText();}
    public String getInfoBookedDepartStation(){return Constant.DRIVER.findElement(infoBookedDepartStation).getText();}
    public String getInfoBookedAriveStation(){return Constant.DRIVER.findElement(infoBookedArriveStation).getText();}
    public String getInfoBookedSeatType(){return Constant.DRIVER.findElement(infoBookedSeatType).getText();}
    public String getInfoBookedAmount(){return Constant.DRIVER.findElement(infoBookedTicketAmount).getText();}
}
