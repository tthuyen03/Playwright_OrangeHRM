package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import web.common.NavigationBar;

public class DashboardPage extends BasePage{

    public DashboardPage(Page page){
        super(page);
    }
    private final Locator dashboardTitle = page.locator("//h6[text()='Dashboard']");

    public void navigateToAdminPage() {
        getNavigation().clickAdmin();
    }

    public boolean isDashboardVisible() {
        return dashboardTitle.isVisible();
    }


}
