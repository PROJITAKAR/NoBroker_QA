package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='navHeader']//div[text()='Log in']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='signUp-phoneNumber']")
	private WebElement phone;
	
	@FindBy(id="signUpSubmit")
	private WebElement continueBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

	public WebElement getPhone() {
		return phone;
	}

	public void setPhone(WebElement phone) {
		this.phone = phone;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public void setContinueBtn(WebElement continueBtn) {
		this.continueBtn = continueBtn;
	}
	
	public void loginClick() {
		loginBtn.click();
	}
	public void loginToNoBroker(String phn) {
		phone.sendKeys(phn);
	}
	public void continueClick() {
		continueBtn.click();
	}
}
