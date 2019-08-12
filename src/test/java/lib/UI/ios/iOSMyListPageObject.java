package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListPageObject extends MyListsPageObject {
    static {
    ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
    ARTICLE_TITLE = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_title']";
    ARTICLE_TITLE_ON_PAGE = "id:org.wikipedia:id/view_page_title_text";
    ARTICLE_BY_TYPE = "xpath://XCUIElementTypeLink";

    }
    public iOSMyListPageObject(RemoteWebDriver driver){
        super(driver);
    }
}

