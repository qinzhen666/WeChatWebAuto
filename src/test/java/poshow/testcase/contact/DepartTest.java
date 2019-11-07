package poshow.testcase.contact;

import org.junit.jupiter.api.*;
import poshow.page.App;
import poshow.page.BasePage;
import poshow.page.contact.DepartPage;

import java.util.List;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
    @DisplayName("添加部门")  //Depart
    void addDepart(){
        String departName = "测试部门001";
        String DadDepart = "秦氏测开部";
        departPage.addDepart(departName,DadDepart);
        //assert添加断言
        List<String> allDepart = departPage.getAllDepart("Depart");
        assertThat(allDepart,hasItem(departName));
        //删除测试数据
        departPage.deleteDepart(departName);
    }

    @Test
    @DisplayName("添加子部门") //subDepart
    void addSubDepart(){
        String departName = "demo子部门001";
        String DadDepart = "demo";
        departPage.addDepart(departName,DadDepart);

        List<String> allDepart = departPage.getAllDepart("subDepart");
        assertThat(allDepart,hasItem(departName));
        departPage.deleteDepart(departName);
    }

    @Test
    @DisplayName("删除部门")
    void deleteDepart(){
        String departName = "测试部门002";
        String DadDepart = "秦氏测开部";
        departPage.addDepart(departName,DadDepart)
                  .deleteDepart(departName);
        List<String> allDepart = departPage.getAllDepart("Depart");
        assertThat(allDepart,not(hasItem(departName)));
    }

    @Test
    @DisplayName("删除子部门")
    void deleteSubDepart(){
        String departName = "测试部门002";
        String DadDepart = "demo";
        departPage.addDepart(departName,DadDepart)
                  .deleteDepart(departName);
        //assert
        List<String> allDepart = departPage.getAllDepart("subDepart");
        assertThat(allDepart,not(hasItem(departName)));
    }

    @Test
    @DisplayName("部门位置上移")
    void upDepart(){
        String departName = "测试部门003";
        String DadDepart = "秦氏测开部";
        departPage.addDepart(departName,DadDepart)
                  .upDepart(departName);
//        departPage.upDepart(departName);
        //assert
        departPage.deleteDepart(departName);
    }

    @Test
    @DisplayName("修改部门名称")
    void reNameDepart(){
        String departName = "测试部门004";
        String DadDepart = "秦氏测开部";
        String newName = "new测试部门004";
        departPage.addDepart(departName,DadDepart)
                  .changeDepartName(departName,newName);
        //assert
        List<String> allDepart = departPage.getAllDepart("Depart");
        assertThat(allDepart,hasItem(newName));

        departPage.deleteDepart(newName);

    }

    @AfterAll
    static void quit(){
        app.quit();
    }
}
