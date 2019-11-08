package poshow.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {


    public static WebDriver driver;


    //默认当元素可被点击时的显示等待5秒find方法
    public WebElement findElement(By by){
        waitClickable(by);
        return driver.findElement(by);
    }

    //自定义元素可点击的显示等待时间的find方法，timeout为0时就无需等待
    public WebElement findElement(By by,int timeout){
        if (timeout > 0){
            waitClickable(by,timeout);
        }
        return driver.findElement(by);
    }

    //设置元素可点击时候的显示等待的时间,默认5秒
    private void waitClickable(By by,int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    private void waitClickable(By by){
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(by));
    }

    //设置元素出现在DOM，可见时候的显示等待时间，默认5秒
    //presenceOfElementLocated是指元素出现在DOM内，并不一定可见
    public void waitVisibility(By by,int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitVisibility(By by){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitSleep(int timeout){
        try {
            Thread.sleep(timeout*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public List<WebElement> finElements(By by){
        return driver.findElements(by);
    }

    public void click(By by){
       findElement(by).click();
    }

    public void click(By by,int timeout){
        findElement(by,timeout).click();
    }

    public void sendKeys(By by,String context){
        findElement(by).sendKeys(context);
    }

    public void sendKeys(By by,String context,int timeout){
        findElement(by,timeout).sendKeys(context);
    }

    public String getText(By by){
        return findElement(by).getText();
    }

    public String getText(By by,int timeout){
        return findElement(by,timeout).getText();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void quit(){
        driver.quit();
    }
}
