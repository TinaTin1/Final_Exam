package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By signupLoginButton = By.xpath("//a[text()='Signup / Login']");
    private By loginEmailField = By.name("email");
    private By loginPasswordField = By.name("password");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By loginForm = By.xpath("//h2[text()='Login to your account']");
    private By loginError = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    private By logoutButton = By.xpath("//a[text()='Logout']");
    private By deleteAccountButton = By.xpath("//a[text()='Delete Account']");
    private By accountDeletedMessage = By.xpath("//h2[text()='Account Deleted!']");


    private By signupNameField = By.name("name");
    private By signupEmailField = By.name("email");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By accountInformation = By.xpath("//h2[text()='Enter Account Information']");
    private By titleMrRadio = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By dobDays = By.id("days");
    private By dobMonths = By.id("months");
    private By dobYears = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    private By accountCreatedMessage = By.xpath("//h2[text()='Account Created!']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");


    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }

    public boolean isLoginFormVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
        return driver.findElement(loginForm).isDisplayed();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmailField).sendKeys(email);
        driver.findElement(loginPasswordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginError));
        return driver.findElement(loginError).isDisplayed();
    }

    public boolean isLoggedInAsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAs));
        return driver.findElement(loggedInAs).isDisplayed();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }

    public boolean isAccountDeletedVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMessage));
        return driver.findElement(accountDeletedMessage).isDisplayed();
    }


    public void enterNameAndEmail(String name, String email) {
        driver.findElement(signupNameField).sendKeys(name);
        driver.findElement(signupEmailField).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public boolean isAccountInformationVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountInformation));
        return driver.findElement(accountInformation).isDisplayed();
    }

    public void fillAccountInformation(
            String password, String day, String month, String year,
            String firstName, String lastName, String company,
            String address1, String country, String state, String city,
            String zipcode, String mobile) {

        driver.findElement(titleMrRadio).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(dobDays).sendKeys(day);
        driver.findElement(dobMonths).sendKeys(month);
        driver.findElement(dobYears).sendKeys(year);
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(offersCheckbox).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public boolean isAccountCreatedVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage));
        return driver.findElement(accountCreatedMessage).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isLoggedInAfterRegistrationVisible() {
        return isLoggedInAsVisible();
    }
}
