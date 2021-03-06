package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        CREATED_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[contains(@text,'{SUBSTRING}')]";
    }

    public iOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


}
