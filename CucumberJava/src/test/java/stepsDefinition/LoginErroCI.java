package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginErroCI {
	
	WebDriver driver;
	
	@Given("navegador aberto")
	public void navegador_aberto() {
	    System.out.println("abrir Chrome");
	    
	    String caminhoDriver = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", caminhoDriver+("/src/test/resources/Drivers/chromedriver.exe"));
	    
	    driver = new ChromeDriver();
	    driver.manage().window().setPosition(new Point(0,0));
	    driver.manage().window().setSize(new Dimension(134,954));
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("logado na central de interpretes") 
	public void logado_na_central_de_interpretes() throws InterruptedException {
	    System.out.println("Entrar em 200.137.197.197");
	    
	    driver.navigate().to("http://200.137.197.197/index.php/Login");
	    
	    Thread.sleep(2000);
	}

	@When("Usuario assiste ao video sinalizando o preenchimento do email")
	public void usuario_assiste_ao_video_sinalizando_o_preenchimento_do_email() throws InterruptedException {
	    System.out.println("Assistindo ao primeiro video");
	    
	    driver.findElement(By.id("username-video")).click();
	    
	    Thread.sleep(4000);
	    
	}

	@And("preenche o campo com o email")
	public void preenche_o_campo_com_o_email() throws InterruptedException {
		System.out.println("Preenche o email");
		
		driver.findElement(By.id("email")).sendKeys("liviafernanda@gmail.com");
		
		Thread.sleep(2000);
	}

	@And("assiste ao video sinalizando o preenchimento da senha")
	public void assiste_ao_video_sinalizando_o_preenchimento_da_senha() throws InterruptedException {
		System.out.println("Assistindo ao segundo video");
		
		driver.findElement(By.id("password-video")).click();
		
		Thread.sleep(4000);
	}

	@And("preenche o campo com senha")
	public void preenche_o_campo_com_senha() throws InterruptedException {
		System.out.println("Preenche a senha");
		
		driver.findElement(By.id("password")).sendKeys("livia");
		
		Thread.sleep(2000);
		
	}

	@And("clica no botao Entrar")
	public void clica_no_botao_entrar() throws InterruptedException {
		//System.out.println("Clica no botao");
		
		driver.findElement(By.id("submitLogin")).click();
		
		Thread.sleep(2000);
	}

	@Then("sistema alerta um erro de login")
	public void sistema_alerta_um_erro_de_login() throws InterruptedException {
		System.out.println("Emite alerta com erro");
		
		Alert alerta = driver.switchTo().alert();
		String mensagem = alerta.getText();
		
		System.out.println(mensagem);
		
		Thread.sleep(2000);
		
		alerta.accept();
		
	}


}
