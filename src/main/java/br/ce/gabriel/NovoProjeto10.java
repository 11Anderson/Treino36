package br.ce.gabriel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CadastroClientes.CampoTreinamentoPage;
import CadastrodeFuncionario03.DSL;

public class NovoProjeto10 {

	
	private WebDriver driver;
	
	private DSL dsl;
	private CampoTreinamentoPage page;

	//private WebElement elemen;

	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", "\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		//Clica no "link"
		driver.get("https://sgconline-306117.uc.r.appspot.com/index.jsp");
		//Incerir dados no Email "@gmail.com"
		driver.findElement(By.id("inputEmail")).sendKeys("@gmail.com");
		Assert.assertEquals( driver.findElement(By.id("inputEmail")).getAttribute("value"));
		//Incerir dados no elemento senha "12345678"
	    driver.findElement(By.id("inputPassword")).sendKeys("12345678");
	    Assert.assertEquals("12345678", driver.findElement(By.id("inputPassword")).getAttribute("value"));
	    //Clicar no elemento "continuar"
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);

	}
	@After
	public void finaliza() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
	}
		@Test
		public void deveInteragirComCadastrosCliente() throws InterruptedException {
		Thread.sleep(5000);
		//Clicando no botão de cadastros.
	    page.setClicaBotão();
		
		//Clicar No cliente.
		Thread.sleep(5000);
		page.setClicaCliente();
		
		//Clicar No Incluir
		page.setClicaNoIncluir();
		
		//Inserir nome do cliente
		page.setIncerirCliente("Tavares");
		Assert.assertEquals("Tavares", dsl.IncerirNomeDoClienteCampo("nomeUsuario"));

		//Inserir o cpf
		page.setIncerirOcpf("017.645.654-79");
		Assert.assertEquals("017.645.654-79", dsl.IncerirOCpfCampo("cpf"));

		//Incerir a data nacimento
		page.setIncerirADataNacimento("12/09/1975");
		Assert.assertEquals("12/09/1975", dsl.IncerirADataCampo("dataNascimento"));

		//Clicar No sexo
		page.setClicaNoSexo();
		
		//Clicar em estado civil
		page.setClicaNoEatadoCivil();
		
		//Inserir nacionalidade Brasileiro
		page.setIncerirNacionalidades("Brasileiro");
		Assert.assertEquals("Brasileiro", dsl.IncerirNacionalidadeCampo("nacionalidade"));

		//Inserir email
		page.setIncerirOEMAIL("tavaresfontes2113@gmail.com");
		Assert.assertEquals("tavaresfontes2113@gmail.com", dsl.IncerirEmaillCampo("email"));

		//Inserir no celular
		page.setIncerirNoCelular("79999122314");
		Assert.assertEquals("79999122314", dsl.IncerirCelulaCampo("telCelular"));

		//Inserir nome emergencia
		page.setIncerirNomeEmergencia("José");
		Assert.assertEquals("José", dsl.IncerirNomeEmergenciaCampo("nomeEmergencia"));

		//Inserir telefoneEmergencial
		page.setIncerirTelefoneEmergencial("79999098765");
		Assert.assertEquals("79999098765", dsl.IncerirTeleEmergencialCampo("telEmergencial"));

		//Clicar em salvar
		page.setClicaEmSalva();
		
		//Clicar em sim para finalizar
		page.setClicaEmSimParaFinalizar();	
		
	}
}

