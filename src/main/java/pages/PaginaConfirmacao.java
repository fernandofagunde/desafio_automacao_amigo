package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaConfirmacao extends PaginaBase {

	private By carrinhoItensConfirmacao = By.className("cart_item");
	private By totalLabel = By.className("summary_total_label");
	private By botaoFinish = By.id("finish");
	private By mensagemConfirmacao = By.className("complete-header");

	public PaginaConfirmacao(WebDriver driver) {
		super(driver);
	}

	public void clicarBotaoFinish() {
		driver.findElement(botaoFinish).click();
	}

	public String pegarMensagemConfirmacao() {
		return driver.findElement(mensagemConfirmacao).getText();
	}

	public int pegarNumeroItensConfirmacao() {
		return driver.findElements(carrinhoItensConfirmacao).size();
	}

	public double pegarValorTotal() {
		String texto = driver.findElement(totalLabel).getText();
		String totalTexto = texto.replace("Total: $", "");

		return Double.parseDouble(totalTexto);
	}

}
