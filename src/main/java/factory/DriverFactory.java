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
                browser = openChrome();
                break;
            case "firefox":
                browser =openFirefox();
                break;
            case "edge":
                browser = openEdge();
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
        }

        context = browser.newContext();
        page = context.newPage();

    }

    private static Browser openChrome(){
        return browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    private static Browser openFirefox(){
        return browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    private static Browser openEdge(){
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge")
                        .setHeadless(false));
    }


    public static Page getPage(){
        return page;
    }




    public static void closeBrowser(){
        playwright.close();
    }

}
