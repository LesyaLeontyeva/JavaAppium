package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {
     protected static  String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT ,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_CANCEL_BUTTON ,
            SEARCH_RESULT_ELEMENT ,
            SEARCH_EMPTY_RESULT_ELEMENT ,
            SEARCH_ELEMENT_TEXT_ATTRIBUTE ,
            SEARCH_EMPTY_MESSAGE ,
            SEARCH_TITLE_TEXT ;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    /* TEMPLATES METHODS */

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    /* TEMPLATES METHODS */
    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INPUT, "Cannot find search input after clicking search init element");
    }

    public String defineElementText() {
        WebElement title_element = this.waitForElementPresent(SEARCH_ELEMENT_TEXT_ATTRIBUTE,
                "Cannot find search string",
                15
        );
        return title_element.getAttribute("text");
    }



    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button!", 5);

    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present!", 5);

    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);

        this.waitForElementAndClick(
                search_result_xpath,
                "Cannot find and click search result with substring " + substring,
                10
        );

    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,"Cannot find empty result element", 15);

    }
    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,"Cannot find empty result element");

    }
    public int getAmountOfElements(){
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }
    public void waitForEmptyMessage(){
        this.waitForElementPresent(SEARCH_EMPTY_MESSAGE,"\n" + "We did not find a placeholder on the search results page ");
    }
    public void waitForElementMustNotPresent(){
        this.assertElementPresent(
                SEARCH_TITLE_TEXT,
                "Cannot find article title"
        );

    }



}
