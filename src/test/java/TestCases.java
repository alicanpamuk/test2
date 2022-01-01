import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestCases extends BaseClass {

    AnasayfaClass anasayfaClass;
    UrunlerClass urunlerClass;
    SepetClass sepetClass;

    @Test
    @Order(1)
    public void anasayfaKontrolu() throws InterruptedException {
        anasayfaClass = new AnasayfaClass(driver);
        Assertions.assertTrue(anasayfaClass.anasayfaButonKontrolu(), "Butonlar sayfada görüntülenemedi.");
    }

    @Test
    @Order(2)
    public void urunAratma() throws InterruptedException {
        anasayfaClass.urunAra();
        anasayfaClass.scrollEtme();
    }

    @Test
    @Order(3)
    public void urunSecme() throws InterruptedException {
        urunlerClass = new UrunlerClass(driver);
        urunlerClass.urunSec();
        int urunFiyati = urunlerClass.getPrice();
        urunlerClass.bedenSec();
        Assertions.assertTrue(urunlerClass.comparePrices(urunFiyati),"Ürün fiyatları aynı değil.");
    }

    @Test
    @Order(4)
    public void adetArttirma() throws InterruptedException {
        sepetClass = new SepetClass(driver);
        Assertions.assertTrue(sepetClass.adetiArttir(),"Sepetteki ürünün adeti arttırılamadı.");
    }

    @Test
    @Order(5)
    public void sepettenUrunSil() throws InterruptedException {
        Assertions.assertTrue(sepetClass.sepetBosKontrolu(),"Sepetten ürünler silinemedi");
    }
}



