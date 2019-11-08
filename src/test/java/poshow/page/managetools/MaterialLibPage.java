package poshow.page.managetools;

import org.openqa.selenium.By;
import poshow.page.BasePage;

public class MaterialLibPage extends BasePage {

    By grayText = By.cssSelector(".ww_icon_GrayText");
    By addBtn = By.cssSelector(".ww_commonImg_AddMember");
    By textInput = By.cssSelector(".js_text_content");
    By save = By.linkText("保存");

    By grayMpNews = By.cssSelector(".ww_icon_GrayMpNews");
    By titleInput = By.xpath("(//*[contains(@class,'ww_editorTitleWrap')]/input)[1]");
    By frameBodyInput = By.cssSelector(".msg_mpNewsEditor_frameBody");
    By coverPicBtn = By.cssSelector(".msg_infoItem_coverPlaceHolder");//
//    By chosePic = By.xpath("(//*[@class='ww_fileInput js_file'])[1]");
    By chosePic = By.cssSelector("[class='qui_btn ww_btn ww_fileInputWrap']>input");
    By submit = By.linkText("确定");

    /*
    添加文字
     */
    public MaterialLibPage addText(String Context){
        waitVisibility(grayText);
        click(grayText);
        click(addBtn);
        sendKeys(textInput,Context);
        click(save);
        return this;
    }

    /*
    添加图文
     */
    public MaterialLibPage addPicText(String title,String picText,String picPath){
        waitVisibility(addBtn);
        click(grayMpNews);
        click(addBtn);
        sendKeys(titleInput,title);
        driver.switchTo().frame(0);
        sendKeys(frameBodyInput,picText);
        driver.switchTo().defaultContent();
        click(coverPicBtn);
        //todo:用带显示等待waitClickable封装的方法就取法找到元素
//        sendKeys(chosePic,picPath);
        driver.findElement(chosePic).sendKeys(picPath);
        click(submit);
        findElement(By.linkText("完成"));
        return this;
    }




}
