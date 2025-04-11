package factory;

import com.microsoft.playwright.*;

public class DriverFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static void initPage(String browserName){
        playwright = Playwright.create();
        switch(browserName.toLowerCase()){
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Please pass correct browser name");
                break;
        }

        context = browser.newContext();
        page = context.newPage();

    }

    public static Page getPage(){
        return page;
    }

    public static void closeBrowser(){
        playwright.close();
    }

}
