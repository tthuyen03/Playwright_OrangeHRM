package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage{
    public LoginPage(Page page){
        super(page);
    }

    private Locator inputUsername = page.locator("input[name='username']");
    private Locator inputPassword = page.locator("input[name='password']");
    private Locator buttonLogin = page.getByRole(AriaRole.BUTTON);
    private Locator textMessage = page.getByText("Invalid credentials");
    private Locator textRequired = page.locator("span:has-text(\"Required\")");



    public void login(String username, String password){
        inputUsername.fill(username);
        inputPassword.fill(password);
        buttonLogin.click();
    }

    public boolean isInvalidCredentialsVisible(){
        return textMessage.isVisible();
    }

    public boolean isRequiredVisible(){
        return textRequired.isVisible();
    }


}
