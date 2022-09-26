package guru99_demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static guru99_demo.SelectRandomValueFromDropdown.Random_dd.randomDecimalString;


public class SelectRandomValueFromDropdown {
    public class Random_dd {
        static char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public static char randomDecimalDigit() {
            return digits[(int) Math.floor(Math.random() * 10)];
        }

        public static String randomDecimalString(int ndigits) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < ndigits; i++) {
                result.append(randomDecimalDigit());
            }
            return result.toString();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebElement element=null;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/payment-gateway/process_purchasetoy.php");
        driver.manage().window().maximize();
        WebElement ID= driver.findElement(By.id("card_nmuber"));
        ID.click();
//        Random randomGenerator = new Random();
//        int rand = 0;
//        while (true){
//            rand = randomGenerator.nextInt(17);
//            if(rand !=0) break;
//        }
//        System.out.println(rand);
        //////////////
        ThreadLocalRandom random = ThreadLocalRandom.current();
//
//        Long l = random.nextLong();
//        System.out.println(l);
//        int randomInt = randomGenerator.nextInt(9000);

//        ID.sendKeys(" "+ l );
//        Random random1 = new Random();
//        int num= random1.nextInt();
//        System.out.println(num);
//        Thread.sleep(5000);

        WebElement Dropdown =driver.findElement(By.id("month"));
        Select skills = new Select(Dropdown);
        int dropdown_value= driver.findElements(By.cssSelector("#month > option")).size();
        System.out.println(dropdown_value);

        Random random2=new Random();
        int index= random2.nextInt(dropdown_value);

        skills.selectByIndex(index);
        System.out.println(index);
        Thread.sleep(5000);
//        driver.quit();
        WebElement code= driver.findElement(By.xpath("//*[@id=\"cvv_code\"]"));
        code.sendKeys(randomDecimalString(3));
        System.out.println( "num"+randomDecimalString(3));
//        String exp = "Please enter a valid email address or mobile number.";
//        //identify actual error message
//        WebElement m = driver.findElement(By.className("alert-content"));
//        String act = m.getText();
//        System.out.println("Error message is: "+ act);
//        //verify error message with Assertion
//        assertEquals(exp, act);



//        System.out.println(random.nextInt(20)); //value displayed should be between 0:20

    }
}
