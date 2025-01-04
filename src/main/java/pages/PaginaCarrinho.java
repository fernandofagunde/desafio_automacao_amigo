package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaCarrinho extends PaginaBase {

	private By itemCarrinho = By.className("inventory_item_name");
	private By botaoRemove = By.id("remove-sauce-labs-backpack");
	private By carrinho = By.className("cart_item");
	private By botaoCheckout = By.id("checkout");

	public PaginaCarrinho(WebDriver driver) {
		super(driver);
	}

	public String pegarNomeItemCarrinho() {

		return driver.findElement(itemCarrinho).getText();
	}

	public void clicarBotaoRemove() {
		driver.findElement(botaoRemove).click();
	}

	public boolean verificarCarrinhoVazio() {
		return driver.findElements(carrinho).isEmpty();
	}

	public int pegarNumeroItensCarrinho() {
		return driver.findElements(carrinho).size();
	}

	public void clicarBotaoCheckout() {

		driver.findElement(botaoCheckout).click();
	}

}
