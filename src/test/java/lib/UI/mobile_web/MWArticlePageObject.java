package lib.UI.mobile_web;

import lib.UI.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject  extends ArticlePageObject {

        static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
       // OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions #ca-watch.mw-ui-icon-mf-watch";
        CREATED_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[contains(@text,'{SUBSTRING}')]";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions #ca-watch.mw-ui-icon-mf-watched";
    }

    public MWArticlePageObject(RemoteWebDriver driver)
        {
            super(driver);
        }


    }


