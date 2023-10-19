package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountRegistrationPage extends BasePage {
    public Locator emailInput;
    public Locator emailInputError;
    public Locator firstNameInput;
    public Locator firstNameInputError;
    public Locator lastNameInput;
    public Locator lastNameInputError;
    public Locator passwordInput;
    public Locator passwordInputError;
    public Locator button;
    public Locator checkbox;
    public Locator inputError;


    public AccountRegistrationPage(Page page) {
        super(page);
        emailInput = page.locator("#email_id");
        emailInputError = page.locator("[data-name=\"email\"] [class^='text-field__ErrorMessage']");
        firstNameInput = page.locator("#firstname_id");
        firstNameInputError = page.locator("[data-name=\"firstname\"] [class^='text-field__ErrorMessage']");
        lastNameInput = page.locator("#lastname_id");
        lastNameInputError = page.locator("[data-name=\"lastname\"] [class^='text-field__ErrorMessage']");
        passwordInput = page.locator("#password_id");
        passwordInputError = page.locator("[data-name=\"password\"] [class^='text-field__ErrorMessage']");
        button = page.locator("button");
        checkbox = page.locator("[class^='checkbox-field']");
        inputError = page.locator(".invalid>div");

    }
}
