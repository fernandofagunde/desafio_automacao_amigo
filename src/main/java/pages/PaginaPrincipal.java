package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaginaPrincipal extends PaginaBase {

	private By textoPaginaInicial = By.className("app_logo");
	private By botaoAdicionarCarrinho = By.id("add-to-cart-sauce-labs-backpack");
	private By iconeCarrinho = By.className("shopping_cart_link");
	private By filtroDropDown = By.className("product_sort_container");
	private By precoItem = By.className("inventory_item_price");

	public PaginaPrincipal(WebDriver driver) {
		super(driver);
	}

	public String getText() {

		return driver.findElement(textoPaginaInicial).getText();
	}

	public void clicarBotaoAdicionarCarrinho() {

		driver.findElement(botaoAdicionarCarrinho).click();
	}

	public void clicarIconeCarrinho() {

		driver.findElement(iconeCarrinho).click();
	}

	public void selecionarPrecoLowTohigh() {

		// WebElement filtroDropDown = driver.findElement(filtroDropDown);
		Select filtroSelect = new Select(driver.findElement(filtroDropDown));
		filtroSelect.selectByValue("lohi");
	}

	public boolean validarPrecosEmOrdemCrescente() {

		List<WebElement> precosItem = driver.findElements(precoItem);
		List<Double> precosAtual = new ArrayList<>();
		for (WebElement elementoPreco : precosItem) {
			String precoTexto = elementoPreco.getText().replace("$", "");
			precosAtual.add(Double.parseDouble(precoTexto));
		}
		// Criando uma cópia da lista e ordenando para comparação
		List<Double> precosOrdenados = new ArrayList<>(precosAtual);
		Collections.sort(precosOrdenados);

		if (precosAtual.equals(precosOrdenados)) {
			return true;

		} else {
			return false;
		}

	}

}
