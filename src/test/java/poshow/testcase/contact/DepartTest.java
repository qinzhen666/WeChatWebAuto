package poshow.testcase.contact;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poshow.page.App;
import poshow.page.BasePage;
import poshow.page.contact.DepartPage;

public class DepartTest {

    public static App app;
    public static DepartPage departPage;
    public static BasePage basePage;

    @BeforeAll
    static void loginFirst(){
        if (app == null){
            app = new App();
        }
        if (departPage == null){
            departPage = new DepartPage();
        }
        if (basePage == null){
            basePage = new BasePage();
        }
        app.loginWithCookie().toContact();
    }

    @BeforeEach
    void beforeEach(){
        basePage.refresh();
    }

    @Test
    void addDepart(){
        String departName = "测试部门001";
        String DadDepart = "demo";
        departPage.addDepart(departName,DadDepart);
        //assert
        departPage.deleteDepart(departName);
    }

    @Test
    void deleteDepart(){
        String departName = "测试部门002";
        String DadDepart = "demo";
        departPage.addDepart(departName,DadDepart);
        departPage.deleteDepart(departName);
    }

    @Test
    void upDepart(){
        String departName = "测试部门003";
        String DadDepart = "秦氏测开部";
        departPage.addDepart(departName,DadDepart);
        departPage.upDepart(departName);
        //assert
        departPage.deleteDepart(departName);
    }

    @AfterAll
    static void quit(){
        app.quit();
    }
}
