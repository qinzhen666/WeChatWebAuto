package poshow.page.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import poshow.page.BasePage;
import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

import java.util.ArrayList;
import java.util.List;

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
    By reNameDepart = By.cssSelector(".js_rename_input");
    By save = By.linkText("保存");

    By allDeparts =  By.cssSelector("[class=jstree-children]>li>a");
    By allSubDeparts = By.xpath("(//*[@class='jstree-children'])[2]/li/a");



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

    /*
    修改名称
     */
    public DepartPage changeDepartName(String departName,String newName){
        waitSleep(1);
        findElement(By.xpath("(//*[text()='"+departName+"'])[1]")).click(); //点击部门
        findElement(By.xpath("(//*[text()='"+departName+"'])/span")).click(); //点击选项
        waitSleep(1);
        findElement(By.linkText("修改名称")).click();
        sendKeys(reNameDepart,newName);
        click(save);
        return this;
    }

    /*
    获取所有部门信息
     */
    public List<String> getAllDepart(String departType){
        List<String> list = new ArrayList<>();
        waitVisibility(By.id("js_tips"));
        waitSleep(1);
        if (departType.equals("Depart")){
            List<WebElement> webElements = finElements(allDeparts);
            for (int i = 0; i < webElements.size(); i++) {
                list.add(webElements.get(i).getText());
        }
        }else if (departType.equals("subDepart")){
            List<WebElement> webElements = finElements(allSubDeparts);
            for (int i = 0; i < webElements.size(); i++) {
                list.add(webElements.get(i).getText());
            }
        }
        return list;
    }

}
