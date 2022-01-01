import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UrunlerClass extends BasePage{

    By sepetimButton = By.xpath("//a/span[contains(text(),'Sepetim')]");
    By urunlerList = new By.ByCssSelector("div[class='m-productImageList']");
    By olculer = new By.ByCssSelector("span[class='m-variation__item']");
    By sepeteEkleButon = By.id("addBasket");
    By productPrice = new By.ByCssSelector("ins[class='m-price__new']");
    By basketPriceLocator = new By.ByCssSelector("span[class='m-productPrice__salePrice']");

    public UrunlerClass(WebDriver driver) {
        super(driver);
    }

    public void urunSec(){
        List<WebElement> products = tumElementleriSec(urunlerList);
        products.get(25).click();
    }

    public int getPrice(){
        String price = elementSec(productPrice).getText();
        String cleanPrice = price.substring(0, price.length()-3);
        cleanPrice = cleanPrice.replace(".","");
        cleanPrice = cleanPrice.replace(",","");
        int intPrice = Integer.parseInt(cleanPrice);
        return intPrice;
    }

    public void bedenSec() throws InterruptedException {
        List<WebElement> bedenler = tumElementleriSec(olculer);
        Thread.sleep(3000);
        bedenler.get(0).click();
        Thread.sleep(2000);
        elementTikla(sepeteEkleButon);
        Thread.sleep(1000);

        elementTikla(sepetimButton);
    }



    public boolean comparePrices(int productPrice) throws InterruptedException {
        Thread.sleep(2000);
        String basketPrice = elementSec(basketPriceLocator).getText();
        basketPrice = basketPrice.substring(0, basketPrice.length()-3);
        basketPrice = basketPrice.replace(".","");
        basketPrice = basketPrice.replace(",","");
        int intBasketPrice = Integer.parseInt(basketPrice);
        if(intBasketPrice == productPrice){
            return true;
        }else{
            return false;
        }
    }


}
