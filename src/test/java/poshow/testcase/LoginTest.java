package poshow.testcase;

import org.junit.jupiter.api.*;
import poshow.page.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    LoginPage loginPage = new LoginPage();

   @BeforeAll
   static void openUrl(){
        new LoginPage().openUrl();
    }


    @Test
    @DisplayName("密码错误登录")
    @Order(1)
    void loginWithErrPassword(){
        String username = "376057520";
        String password = "123456";
        String expectedErrM = "你输入的帐号或密码不正确，请重新输入。";

        String errM = loginPage.loginWithErrPassword(username, password);
        assertThat(errM,equalTo(expectedErrM));
    }

    @Test
    @DisplayName("账号错误登录")
    @Order(2)
    void loginWithErrUsername(){
        String username = "111";
        String password = "123456";
        String expectedErrM = "请输入正确的帐号！";

        String errM = loginPage.loginWithErrUsername(username, password);
        assertThat(errM,equalTo(expectedErrM));
    }

    @Test
    @DisplayName("空密码登录")
    @Order(3)
    void loginWithoutPassword(){
        String username = "376057520";
        String password = "";
        String expectedErrM = "你还没有输入密码！";

        String errM = loginPage.loginWithoutPassword(username, password);
        assertThat(errM,equalTo(expectedErrM));
    }

    @Test
    @DisplayName("正确登录")
    @Order(4)
    void logSuccess(){
       String username = "376057520";
       String password = "qazQAZ123@";
       loginPage.loginSuccess(username,password);
    }

}
