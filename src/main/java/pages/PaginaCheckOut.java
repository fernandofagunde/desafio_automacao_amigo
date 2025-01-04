package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaCheckOut extends PaginaBase {
	private By campoFirstName = By.id("first-name");
	private By campoLastName = By.id("last-name");
	private By campoPostalCode = By.id("postal-code");
	private By botaoContinue = By.id("continue");

	public PaginaCheckOut(WebDriver driver) {
		super(driver);
	}

	public void preencherCampoFirstName(String nome) {
		driver.findElement(campoFirstName).sendKeys(nome);
	}

	public void preencherCampoLastName(String sobreNome) {

		driver.findElement(campoLastName).sendKeys(sobreNome);
	}

	public void preencherCampoPostalCode(String cep) {
		driver.findElement(campoPostalCode).sendKeys(cep);
	}

	public void clicarBotaoContinue() {

		driver.findElement(botaoContinue).click();
	}

}
