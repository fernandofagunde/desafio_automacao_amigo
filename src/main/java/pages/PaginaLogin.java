package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin extends PaginaBase {
	private By campoUsername = By.id("user-name");
	private By campoPassword = By.id("password");
	private By botaoLogin = By.id("login-button");
	private By mensagemErroLogin = By.cssSelector(".error-message-container h3");

	public PaginaLogin(WebDriver driver) {
		super(driver);
	}

	public void preencherUserName(String username) {
		driver.findElement(campoUsername).sendKeys(username);
	}

	public void preencherPassword(String password) {
		driver.findElement(campoPassword).sendKeys(password);
	}

	public void clicarLogin() {
		driver.findElement(botaoLogin).click();
	}

	public String getMensagemErroLogin() {
		return driver.findElement(mensagemErroLogin).getText();
	}

	public void efetuarLogin(String userName, String password) {
		preencherUserName(userName);
		preencherPassword(password);
		clicarLogin();
	}
}