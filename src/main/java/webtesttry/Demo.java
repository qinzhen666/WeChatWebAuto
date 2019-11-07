package webtesttry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) {
//        String path = "src/main/drivers/chromedriver";
//        System.setProperty("webdriver.chrome.driver",path);
//
//        String firefoxPath = "src/main/drivers/geckodriver";
//
//        System.setProperty("webdriver.gecko.driver",firefoxPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        /*WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.baidu.com/");
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

        driver.findElement(By.id("kw")).sendKeys("mp3");
        driver.findElement(By.id("su")).click();
        /*firefoxDriver.findElement(By.id("kw")).sendKeys("mp3");
        firefoxDriver.findElement(By.id("su")).click();*/
    }



}
