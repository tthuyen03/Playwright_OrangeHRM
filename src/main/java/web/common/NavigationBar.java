package web.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NavigationBar {
    private Page page;
    private Locator adminLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin"));


    public NavigationBar(Page page){
        this.page = page;

    }

    public void clickAdmin(){
        adminLink.click();
    }


}
