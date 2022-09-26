package guru99_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Payment_Gateway {
    private static WebElement element=null;
   // public int randomInt;
     final WebDriver driver;

    public Payment_Gateway(WebDriver driver) {
        this.driver = driver;
    }


    public static WebElement select_Quantity(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.name("quantity"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#three > div > form > div > div.\\31 u.\\31 2u\\$\\(small\\).select-wrapper > select > option")).size();
        System.out.println(dropdown_value);

        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);

        skills.selectByIndex(index);
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }
    public static WebElement button_click(WebDriver driver){
        element =driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[8]/ul/li/input"));
        return element;
    }

    public static WebElement write_num(WebDriver driver){
        element=driver.findElement(By.id("card_nmuber"));
        return element;
    }
     public static WebElement select_month(WebDriver driver) throws InterruptedException {
         element =driver.findElement(By.id("month"));
         Select skills = new Select(element);
         int dropdown_value= driver.findElements(By.cssSelector("#month > option")).size();
         System.out.println(dropdown_value);

         Random random2=new Random();
         int index= random2.nextInt(dropdown_value);

         skills.selectByIndex(index);
         System.out.println(" count"+index);
//         Thread.sleep(1000);
         return element;
     }
    public static WebElement select_year(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.id("year"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector(" #year > option")).size();
        System.out.println("size"+dropdown_value);

        Random random2=new Random();
        int index= random2.nextInt(dropdown_value);

        skills.selectByIndex(index);
        System.out.println(index);
//        Thread.sleep(1000);
        return element;
    }

    public static WebElement write_code(WebDriver driver){
        element=driver.findElement(By.xpath("//*[@id=\"cvv_code\"]"));
        return element;
    }
    public static WebElement button_click2(WebDriver driver){
        element=driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div[2]/div/ul/li/input"));
        return element;
    }





}
