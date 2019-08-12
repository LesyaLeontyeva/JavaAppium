package lib.UI.android;

import io.appium.java_client.AppiumDriver;
import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPageObject extends MyListsPageObject {

    static {
                FOLDER_BY_NAME_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[contains(@text,'{FOLDER_NAME}')]";
                ARTICLE_BY_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'{TITLE}')]";
                ARTICLE_TITLE = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_title']";
                ARTICLE_TITLE_ON_PAGE = "id:org.wikipedia:id/view_page_title_text";
    }
    public AndroidMyListPageObject(RemoteWebDriver driver){
        super(driver);
    }
}