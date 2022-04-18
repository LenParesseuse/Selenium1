package PageObjects;

import Common.Constant;
import Common.Log;
import Common.WebdriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TicketPricePage extends BasePage {
    private final By smallHeaderofTicketPrice = By.cssSelector(".TableSmallHeader th");
    private final By listOfPriceForEachSeattype = By.xpath("//th[contains(text(),'Price')]/following-sibling::td");

    /*
     * */
    protected WebElement getSmallHeader() {
        return Constant.DRIVER.findElement(smallHeaderofTicketPrice);
    }

    public List<WebElement> getListPriceForEachSeatType() {
        return Constant.DRIVER.findElements(listOfPriceForEachSeattype);
    }

    /*
     * */
    public String getTextofSmallHeader() {
        return getSmallHeader().getText();
    }

    public String[] listPriceOfEachSeatType() {
        String[] array = new String[6];
        for (int i = 0; i < 6; i++) {
            array[i] = getListPriceForEachSeatType().get(i).getText();
        }
        return array;
    }

    public boolean compareTicketPrice(String[] a, String[] b) {
        boolean result=true;
        if (a.length != b.length){
            Log.error("Missing prices of one/some seat types");
            result=false;
        }
        else{
            for (int i = 0; i < a.length; i++) {
                Log.info(a[i]+"-----"+b[i]);
                if (!a[i].equals(b[i])){
                    Log.error("Price of seat type "+String.valueOf(i+1)+" is wrong");
                    result=false;}
            }
            }
        return result;
        }
    }
