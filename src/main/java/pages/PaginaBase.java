package pages;

import org.openqa.selenium.WebDriver;

public class PaginaBase {
	protected WebDriver driver;

	public PaginaBase(WebDriver driver) {
		this.driver = driver;

	}
}