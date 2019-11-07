package poshow.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poshow.page.contact.ContactPage;

import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    public App loginWithCookie(){
        String url = "https://work.weixin.qq.com/";

        ChromeOptions chromeOptions = new ChromeOptions();

        //配置等待策略：page load:normal,eager,none
        chromeOptions.setCapability("pageLoadStrategy","eager");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        click(By.linkText("企业登录"));

        driver.manage().addCookie(new Cookie("wwrtx.sid","0Ur3QJ8bY3XpZL9u1TGYYQDsG8_BaviUBLQ5ficQilrmG9N0C6V1IJyym0WhpNEb"));
        driver.navigate().refresh();
        return this;
    }

    public ContactPage toContact(){
        click(By.linkText("通讯录"));
        return new ContactPage();
    }

//    public


}
