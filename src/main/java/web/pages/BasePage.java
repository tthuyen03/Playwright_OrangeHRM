package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import web.constants.Constants;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;


public class BasePage {
    public Page page;


    public BasePage(Page page){
        this.page = page;
    }

    public void navigateToPage() {
        page.navigate(Constants.URL,
                new Page.NavigateOptions()
                        .setTimeout(60000)
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }


    public Locator getLinkInNav(String tabName){
        return page.locator("a.oxd-main-menu-item:has-text('" + tabName + "')");
    }


    public void takeScreenshot(String fileName){
        try{
            String time = new SimpleDateFormat("ddMMyyyy").format(new Date());
            String file = fileName + "_" + time + ".png";
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("screenshot/"+file))
                    .setFullPage(true));
            System.out.println("Screenshot saved: " + fileName);
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }

    }



}
