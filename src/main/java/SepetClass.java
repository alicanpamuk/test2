import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SepetClass extends BasePage{

    By adetArttirmaBari = By.id("quantitySelect0");
    By adetMiktari = new By.ByCssSelector("option[value='2']");
    By itemDeleteButton = By.id("removeCartItemBtn0");
    By sepettekiUrunler = new By.ByCssSelector("div[class='m-basket__item']");


    public SepetClass(WebDriver driver) {
        super(driver);
    }

    public boolean adetiArttir() throws InterruptedException {
        elementTikla(adetArttirmaBari);
        Thread.sleep(2000);
        elementTikla(adetMiktari);
        Thread.sleep(2000);
        String quantity = elementSec(adetMiktari).getText();
        Thread.sleep(2000);
        if(quantity.equals("2 adet")){
            return true;
        }else{
            return false;
        }
    }


    public boolean sepetBosKontrolu() throws InterruptedException {
        sepettenUrunSil();
        Thread.sleep(3000);
        List<WebElement> basketElements = tumElementleriSec(sepettekiUrunler);
        if(basketElements.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void sepettenUrunSil(){
        elementTikla(itemDeleteButton);
    }
}
