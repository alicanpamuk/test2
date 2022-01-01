import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLoggerClass.class)
public class BaseClass {

    static WebDriver driver;

    @BeforeAll
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.beymen.com/");

        driver.manage().window().maximize();
    }

    @AfterAll
    public void afterAll(){

        driver.quit();
    }

}