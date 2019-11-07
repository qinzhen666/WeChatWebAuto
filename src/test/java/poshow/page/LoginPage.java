package poshow.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{
    //定位器
    By usernameInput = By.name("u");  //获取用户名输入框
    By passwordInput = By.id("p");    //获取密码输入框
    By submitLogin = By.cssSelector("#login_button"); //获取登录按钮
    By ErrM = By.id("err_m");  //获取错误提示信息


    public void openUrl(){
        String url = "https://mail.qq.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.switchTo().frame("login_frame");

    }


    //业务方法

    /*
    登录方法
     */
    private void login(String username,String password){
        findElement(usernameInput).clear();
        findElement(passwordInput).clear();
        sendKeys(usernameInput,username);
        sendKeys(passwordInput,password);
        click(submitLogin);
    }

    /*
      成功登录
     */
    public MainPage loginSuccess(String username,String password){
        login(username,password);
        return new MainPage();
    }


    /*
     密码错误登录
     message:你输入的帐号或密码不正确，请重新输入。
     */
    public String loginWithErrPassword(String username,String password ){
        login(username,password);
        return getText(ErrM);
    }

    /*
    账号为空登录
    你还没有输入帐号！
     */
    public String loginWithErrUsername(String username,String password){
        login(username,password);
        return getText(ErrM);

    }

    /*
    密码为空登录
     */
    public String loginWithoutPassword(String username,String password){
        login(username,password);
        return getText(ErrM);
    }
}
