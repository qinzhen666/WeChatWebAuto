package poshow.page.contact;

import org.openqa.selenium.By;
import poshow.page.BasePage;

public class DepartPage extends BasePage {


    //定位器
    By addBtn = By.cssSelector(".member_colLeft_top_addBtn");
    By addDepart = By.linkText("添加部门");
    By departNameInput = By.cssSelector(".inputDlg_item>input");
    By chooseParentDepartBtn = By.cssSelector(".js_parent_party_name");
    By chooseParentDepart = By.xpath("(//*[text()='demo'])[2]");
    By submit = By.linkText("确定");

    By expandBtn = By.xpath("(//*[text()='demo'])[1]/preceding-sibling::i");
    By deleteBtn = By.linkText("删除");
    By upBtn = By.linkText("上移");



    /*
    添加部门
     */
    public DepartPage addDepart(String departName,String DadDepart){
        click(addBtn);
        click(addDepart);
        sendKeys(departNameInput,departName);
        click(chooseParentDepartBtn);
        findElement(By.xpath("(//a[text()='"+DadDepart+"'])[2]")).click();
        click(submit);
        return this;
    }

    /*
    删除部门
     */
    public DepartPage deleteDepart(String departName){
        waitSleep(1);
        findElement(By.xpath("(//*[text()='"+departName+"'])[1]")).click(); //点击部门
        findElement(By.xpath("(//*[text()='"+departName+"'])/span")).click(); //点击选项
        waitSleep(1);
        click(deleteBtn,10);
        click(submit);
        return this;
    }

    /*
    上移部门
     */
    public DepartPage upDepart(String departName){
        waitSleep(1);
        findElement(By.xpath("(//*[text()='"+departName+"'])[1]")).click(); //点击部门
        findElement(By.xpath("(//*[text()='"+departName+"'])/span")).click(); //点击选项
        click(upBtn);
        return this;
    }
}
