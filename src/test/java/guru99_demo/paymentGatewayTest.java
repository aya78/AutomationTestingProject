package guru99_demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class paymentGatewayTest {
    private WebDriver driver=null;

    @BeforeTest
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
    }
    @Test
    public void Guru99_demo() throws InterruptedException {

        String random1 = RandomStringUtils.random(16, false, true);

        String r = RandomStringUtils.random(3, 1,100,false ,true);
        //Integer random2 = TestRandomBigInteger.random(3, false, true);

        System.out.println(random1);
        System.out.println(r);

        driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
        driver.manage().window().maximize();
        Payment_Gateway.select_Quantity(driver);
        //click on  search button
        //another solution
        Payment_Gateway.button_click(driver).sendKeys(Keys.RETURN);
        //////////////////////////////////
//        // Switching to Alert
//        Alert alert = driver.switchTo().alert();
//        // Capturing alert message.
//        String alertMessage= driver.switchTo().alert().getText();
//        // Displaying alert message
//        System.out.println(alertMessage);
//        Thread.sleep(5000);
//
//        // Accepting alert
//        alert.accept();
/////////////////////////////////////////////////
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        Payment_Gateway.write_num(driver).sendKeys("" + random1);
//        new Actions(driver)
//             .moveToElement(Payment_Gateway.write_num(driver))
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold()
//                .pause(Duration.ofSeconds(1))
//                .sendKeys("1234567891234567")
//                .perform();

        Payment_Gateway.select_month(driver);

        Payment_Gateway.select_year(driver);
        Payment_Gateway.write_code(driver).sendKeys("" + r);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Payment_Gateway.button_click2(driver).sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    @AfterTest
    public void TearDownTest()
    {
        //CLOSE DRIVER
        driver.quit();
        System.out.println("test complete successfully");

    }

}
