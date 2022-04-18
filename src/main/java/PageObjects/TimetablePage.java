package PageObjects;

import Common.Constant;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage{

    protected WebElement getLinkCheckPrice(String departFrom, String ariveAt){
        return Constant.DRIVER.findElement(By.xpath("//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1][text()='"
                +departFrom+"']/following-sibling::td[text()='"+ariveAt+"']/following-sibling::td//a[text()='check price']"));
    }
    /*
     * */
    public void clickLinkCheckPrice(String departFrom, String arriveAt){
        WebdriverUtils.scrollDowntoElement(getLinkCheckPrice(departFrom,arriveAt));
        getLinkCheckPrice(departFrom,arriveAt).click();
    }
}
