
import pages.PaginaCarrinho;
import pages.PaginaCheckOut;
import pages.PaginaConfirmacao;
import pages.PaginaLogin;
import pages.PaginaPrincipal;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CasosDeTeste_Test {

	private WebDriver driver;
	private PaginaLogin paginaLogin;
	private PaginaPrincipal paginaPrincipal;
	private PaginaCarrinho paginaCarrinho;
	private PaginaCheckOut paginaCheckOut;
	private PaginaConfirmacao paginaConfirmacao;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.crhome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		paginaLogin = new PaginaLogin(driver);
		paginaPrincipal = new PaginaPrincipal(driver);
		paginaCarrinho = new PaginaCarrinho(driver);
		paginaCheckOut = new PaginaCheckOut(driver);
		paginaConfirmacao = new PaginaConfirmacao(driver);
	}

	@Test
	public void login_sucesso() {
		paginaLogin.efetuarLogin("standard_user", "secret_sauce");
		assertEquals(paginaPrincipal.getText(), "Swag Labs");
	}

	@Test
	public void login_erro() {
		paginaLogin.efetuarLogin("standard_user", "senha_errada");
		assertEquals(paginaLogin.getMensagemErroLogin(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void adicionar_produto_carrinho() {
		paginaLogin.efetuarLogin("standard_user", "secret_sauce");
		paginaPrincipal.clicarBotaoAdicionarCarrinho();
		paginaPrincipal.clicarIconeCarrinho();
		assertEquals(paginaCarrinho.pegarNomeItemCarrinho(), "Sauce Labs Backpack");
	}

	@Test
	public void remover_produto_carrinho() {
		paginaLogin.efetuarLogin("standard_user", "secret_sauce");
		paginaPrincipal.clicarBotaoAdicionarCarrinho();
		paginaPrincipal.clicarIconeCarrinho();
		paginaCarrinho.clicarBotaoRemove();
		assertTrue(paginaCarrinho.verificarCarrinhoVazio());

	}

	@Test
	public void fluxo_compra_completo() {
		paginaLogin.efetuarLogin("standard_user", "secret_sauce");
		paginaPrincipal.clicarBotaoAdicionarCarrinho();
		paginaPrincipal.clicarIconeCarrinho();
		assertEquals(paginaCarrinho.pegarNumeroItensCarrinho(), 1);
		paginaCarrinho.clicarBotaoCheckout();
		paginaCheckOut.preencherCampoFirstName("Kent");
		paginaCheckOut.preencherCampoLastName("Beck");
		paginaCheckOut.preencherCampoPostalCode("55010590");
		paginaCheckOut.clicarBotaoContinue();
		assertEquals(paginaConfirmacao.pegarNumeroItensConfirmacao(), 1);
		assertEquals(paginaConfirmacao.pegarValorTotal(), 32.39, 0.001);
		paginaConfirmacao.clicarBotaoFinish();
		assertEquals(paginaConfirmacao.pegarMensagemConfirmacao(), "Thank you for your order!");

	}

	@Test
	public void filtragem_precos_low_high() {
		paginaLogin.efetuarLogin("standard_user", "secret_sauce");
		paginaPrincipal.selecionarPrecoLowTohigh();
		assertTrue(paginaPrincipal.validarPrecosEmOrdemCrescente());
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}
