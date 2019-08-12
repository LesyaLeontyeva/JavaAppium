package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.MyListsPageObject;
import lib.UI.android.AndroidMyListPageObject;
import lib.UI.ios.iOSMyListPageObject;
import lib.UI.mobile_web.MWMyLIstPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyLIstsPageObjectFactory {
    public static MyListsPageObject get(RemoteWebDriver driver){
        if(Platform.getInstance().isAndroid()){
            return new AndroidMyListPageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new iOSMyListPageObject(driver);
        }else {
            return new MWMyLIstPageObject(driver);
        }
    }
}
