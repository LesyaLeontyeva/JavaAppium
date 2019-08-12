package lib.UI.mobile_web;

import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyLIstPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
        ARTICLE_TITLE = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_title']";
        ARTICLE_TITLE_ON_PAGE = "id:org.wikipedia:id/view_page_title_text";
    }
    public MWMyLIstPageObject(RemoteWebDriver driver){
        super(driver);
    }
}

