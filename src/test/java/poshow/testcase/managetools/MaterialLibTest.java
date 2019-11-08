package poshow.testcase.managetools;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poshow.page.App;
import poshow.page.managetools.MaterialLibPage;

public class MaterialLibTest {

    public static App app;
    public static MaterialLibPage materialPage;

    @BeforeAll
    static void loginFirst(){
        if (app == null){
            app = new App();
        }
        if (materialPage == null){
            materialPage = new MaterialLibPage();
        }
        app.loginWithCookie().toMaterialLib();
    }

    @Test
    void uploadMaterial(){
        String context = "web自动化实战";
        String title = "WeChat自动化测试";
        String picText = "WeChat自动化测试演示";
        String picPath = "/Users/qinzhen/Documents/TestDev/WebAuto/projects/WeChatWebAutoTest/src/test/java/poshow/data/myPic.jpeg";
        materialPage.addText(context)
                    .addPicText(title,picText,picPath);

    }

    @AfterAll
    static void quit(){
        app.quit();
    }
}
