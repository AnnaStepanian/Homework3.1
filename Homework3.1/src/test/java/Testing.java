import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class Testing {
    public static WebDriver webDriver;

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
    @AfterTest
    public static void tearDown() {
        webDriver.quit();
    }

    @Test
    public void Search(){
        webDriver.get("https://www.schreursgerbera.com/");
        webDriver.findElement(By.cssSelector("#search")).sendKeys("gerbera", Keys.ENTER);
        Assert.assertEquals(webDriver.findElement(By.cssSelector("body > main > section.mainVisual.Page > div > h1")).getText(), "You searched for 'gerbera'", "You searched for 'gerbera'");
    }

    @Test
    public void Collection(){
        webDriver.get("https://www.schreursgerbera.com/");
        webDriver.findElement(By.xpath("/html/body/header/section/nav/ul/li[2]/a")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.schreursgerbera.com/products", "https://www.schreursgerbera.com/products");
    }

    @Test
    public void Propagation(){
        webDriver.get("https://www.schreursgerbera.com/");
        webDriver.findElement(By.xpath("/html/body/header/section/nav/ul/li[4]/a")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.schreursgerbera.com/propagation", "https://www.schreursgerbera.com/propagation");
    }

    @Test
    public void AboutUs(){
        webDriver.get("https://www.schreursgerbera.com/");
        webDriver.findElement(By.xpath("/html/body/main/div[1]/section[1]/div/div/a")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.schreursgerbera.com/about-us", "https://www.schreursgerbera.com/about-us");
    }
}
