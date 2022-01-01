import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement elementSec(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> tumElementleriSec(By locator){
        return driver.findElements(locator);
    }

    public void elementTikla(By locator){
        elementSec(locator).click();
    }


    public Boolean elementKontrol(By locater){
        return elementSec(locater).isDisplayed();
    }

    public void textYaz(By locator, String text){
        elementSec(locator).sendKeys(text);
    }


}
