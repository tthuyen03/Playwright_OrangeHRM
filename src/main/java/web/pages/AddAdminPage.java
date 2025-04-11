package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

public class AddAdminPage extends BasePage{
    public AddAdminPage(Page page){
        super(page);
    }

    private Locator selectUserRole = page.locator("//label[contains(text(), 'User Role')]/following::div[contains(@class, 'oxd-select-text--focus')]");
    private Locator inputUserRoleValue = page.locator("//div[@role='listbox']//span[text()='ESS']");
    private Locator inputEmployeeName = page.getByLabel("Employee Name");
    private Locator selectStatus = page.locator("//label[contains(text(), 'Status')]/following::div[contains(@class, 'oxd-select-text--focus')]");
    private Locator inputStatusValue = page.locator("//div[@role='listbox']//span[text()='Enabled']");
    private Locator inputUsername = page.getByLabel("Username");
    private Locator inputPassword = page.getByLabel("Password");
    private Locator inputConfirmPassword = page.getByLabel("Confirm Password");
    private Locator btnSubmit = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));




    public void addUser(String employeeName, String username, String password, String confirmPassword ){
        selectUserRole.click();
        inputUserRoleValue.click();
        inputEmployeeName.fill(employeeName);
        selectStatus.click();
        inputStatusValue.click();
        inputUsername.fill(username);
        inputPassword.fill(password);
        inputConfirmPassword.fill(confirmPassword);
        btnSubmit.click();


    }

}
