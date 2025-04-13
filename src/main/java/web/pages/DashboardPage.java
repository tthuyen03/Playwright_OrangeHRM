package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage extends BasePage{

    public DashboardPage(Page page){
        super(page);
    }
    private final Locator dashboardTitle = page.locator("//h6[text()='Dashboard']");


    public boolean isDashboardVisible() {
        return dashboardTitle.isVisible();
    }


}
