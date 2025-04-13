package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

public class AddAdminPage extends BasePage{
    public AddAdminPage(Page page){
        super(page);
    }

    private final Locator selectUserRole = page.locator("div.oxd-select-wrapper:below(label:has-text('User Role'))").first();
    private final Locator selectStatus = page.locator("div.oxd-select-wrapper:below(label:has-text('Status'))").first();
    private final Locator inputEmployeeName = page.getByPlaceholder("Type for hints...");

    private final Locator inputUsername = page.locator("input[autocomplete='off']:below(label:has-text('Username'))").first();
    private final Locator inputPassword = page.locator("input[type='password']:below(label:has-text('Password'))").first();
    private final Locator inputConfirmPassword = page.locator("input[type='password']:below(label:has-text('Confirm Password'))").first();
    private final Locator btnSubmit = page.locator("button:has-text('Save')");


    public void getValueUserRole(String role){
        selectUserRole.click();
        page.locator("//div[@role='listbox']//span[text()='"+role+"']").click();
    }

    public void getValueStatus(String status){
        selectStatus.click();
        page.locator("//div[@role='listbox']//span[text()='"+status+"']");
    }

    public void addUser(String role, String employeeName, String status, String username, String password, String confirmPassword ){
        getValueUserRole(role);
        inputEmployeeName.fill(employeeName);
        getValueStatus(status);
        inputUsername.fill(username);
        inputPassword.fill(password);
        inputConfirmPassword.fill(confirmPassword);
        btnSubmit.click();


    }

}
