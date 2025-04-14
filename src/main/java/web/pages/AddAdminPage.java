package web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import static web.constants.LocatorConstants.DROPDOWN_LIST;

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


    public void getValueInList(String base, String text){
       Locator locator = page.locator(base + "//span[text()='" + text + "']");
       locator.waitFor();
       locator.click();
    }

    public void getEmplyeeName(String empName){
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(empName)).click();
    }

    public void addUser(String role, String employeeName, String status, String username, String password, String confirmPassword ){
        //page.pause();
        selectUserRole.click();
        getValueInList(DROPDOWN_LIST,role);
        selectStatus.click();
        getValueInList(DROPDOWN_LIST,status);
        inputEmployeeName.fill(employeeName);
        getEmplyeeName(employeeName);
        inputUsername.fill(username);
        inputPassword.fill(password);
        inputConfirmPassword.fill(confirmPassword);
        btnSubmit.click();


    }

}
