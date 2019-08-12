package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {
    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            ARTICLE_TITLE,
            ARTICLE_TITLE_ON_PAGE,
            REMOVE_FROM_SAVED_BUTTON,
            ARTICLE_BY_TYPE;

    private static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }
    private static String getRemoveButtonTitle(String article_title) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                10
        );
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath,
                "Cannot find saved article by title " + article_xpath,
                15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath,
                "Saved article still present with title " + article_title,
                15);
    }

    public void swipeByArticleToDelete(String article_title) {

        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article"
            );
        } else {
            String remove_locator = getRemoveButtonTitle(article_title);
            this.waitForElementAndClick(remove_locator,
                    "Cannot click button to remove article from saved",
                    10);
        }

       // this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");

        //this.swipeElementToLeft(article_xpath,
        //        "Cannot find saved article"
       // );
        if(Platform.getInstance().isIOS()){
        this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        if(Platform.getInstance().isMv()){
            driver.navigate().refresh();
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public int getElementsCountInList() {
        if(Platform.getInstance().isAndroid()) {
            return this.getAmountOfElements(ARTICLE_TITLE);
        }
        else {
            return this.getAmountOfElements(ARTICLE_BY_TYPE);
        }
    }



    public String getArticleNameInList() {
        if(Platform.getInstance().isAndroid()) {
            String name_of_article_in_list = this.waitForElementAndGetAttribute(
                    ARTICLE_TITLE,
                    "text",
                    "We don't find attribute of article in list",
                    15
            );
            return name_of_article_in_list;
        }
        else {
            String name_of_article_in_list = this.waitForElementAndGetAttribute(
                    ARTICLE_BY_TYPE,
                    "name",
                    "We don't find attribute of article in list",
                    15
            );
            return name_of_article_in_list;
        }
    }

    public void openArticleByIdInList() {
        if(Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    ARTICLE_TITLE,
                    "Cannot find article",
                    15
            );
        } else {
            this.waitForElementAndClick(
                    ARTICLE_BY_TYPE,
                    "Cannot find article",
                    15
            );
        }
    }

    public String getArticleTitleOnPage() {
        if(Platform.getInstance().isAndroid()) {
            String name_of_article_on_page = this.waitForElementAndGetAttribute(
                    ARTICLE_TITLE_ON_PAGE,
                    "text",
                    "We don't find attribute of article on page",
                    15
            );
            return name_of_article_on_page;
        }
        else {
            String name_of_article_on_page = this.waitForElementAndGetAttribute(
                    ARTICLE_TITLE_ON_PAGE,
                    "name",
                    "We don't find attribute of article on page",
                    15
            );
            return name_of_article_on_page;
        }
    }


    public void CheckArticleInList(String expTitle){
        this.waitForElementPresent(getSavedArticleXpathByTitle(expTitle), "Target article is not present in list " + ARTICLE_BY_TITLE_TPL);
    }

    public void CheckArticleNotInList(String expTitle){
        this.waitForElementNotPresent(getSavedArticleXpathByTitle(expTitle), "Target article is presented in list " + ARTICLE_BY_TITLE_TPL, 5);
    }
}