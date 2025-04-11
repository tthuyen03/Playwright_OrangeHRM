package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import web.common.NavigationBar;

import java.util.ArrayList;
import java.util.List;

public class AdminPage extends BasePage{


    private Locator btnAdd = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add "));
    private Locator adminTable = page.locator("//div[@class='oxd-table' and @role='table']");
    private Locator userValues = adminTable.locator("div.oxd-table-body div.oxd-table-card > div > div:nth-child(2)");

    public AdminPage(Page page){
        super(page);

    }


    public void clickAdd(){
        btnAdd.click();
    }


    public boolean  verifyCreateUserSuccess(String username){
        List<String> userList = new ArrayList<>();
        int countUser = userValues.count();
        for(int i = 0; i <countUser; i++){
            String user = userValues.nth(i).textContent().trim();
            userList.add(user);
        }

        System.out.println("User in list:");
        for (String user : userList) {
            System.out.println(user);
        }
        return userList.contains(username);
    }
}
