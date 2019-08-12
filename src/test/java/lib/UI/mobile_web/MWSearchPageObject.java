package lib.UI.mobile_web;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
        static {
            SEARCH_INIT_ELEMENT = "css:button#searchIcon";
            SEARCH_INPUT = "css:form>input[type='search']";
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikipedia-description')][contains(text(),'{SUBSTRING}')]";
            SEARCH_CANCEL_BUTTON = "css:button.cancel";
            SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
            SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
            SEARCH_ELEMENT_TEXT_ATTRIBUTE = "id:org.wikipedia:id/search_src_text";
            SEARCH_EMPTY_MESSAGE = "id:org.wikipedia:id/search_empty_message";
            SEARCH_TITLE_TEXT = "id:org.wikipedia:id/view_page_title_text";
        }

        public MWSearchPageObject(RemoteWebDriver driver)
        {
            super(driver);
        }
    }


