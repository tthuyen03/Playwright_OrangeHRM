package web.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import web.common.NavigationBar;
import web.constants.Constants;


public class BasePage {
    public Page page;
    private NavigationBar navigation;

    public BasePage(Page page){
        this.page = page;
        this.navigation = new NavigationBar(page);
    }

    public void navigateToPage() {
        page.navigate(Constants.URL,
                new Page.NavigateOptions()
                        .setTimeout(60000)
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    public NavigationBar getNavigation(){
        return navigation;
    }


}
