package poshow.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poshow.page.contact.ContactPage;
import poshow.page.managetools.MaterialLibPage;

import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    public App loginWithCookie(){
        String url = "https://work.weixin.qq.com/";

        ChromeOptions chromeOptions = new ChromeOptions();

        //配置等待策略：page load:normal,eager,none
        chromeOptions.setCapability("pageLoadStrategy","none");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        click(By.linkText("企业登录"));

        driver.manage().addCookie(new Cookie("wwrtx.sid","0Ur3QJ8bY3XpZL9u1TGYYTm9tv3b4tASd9TageEFjJHoh8y7whcSRu6PtHtIOIsc"));
        driver.navigate().refresh();
        return this;
    }

    public ContactPage toContact(){
        click(By.linkText("通讯录"));
        return new ContactPage();
    }

    public MaterialLibPage toMaterialLib(){
        click(By.linkText("管理工具"));
        click(By.cssSelector(".ww_icon_AppMaterialBig"),15);
        return new MaterialLibPage();
    }


}
