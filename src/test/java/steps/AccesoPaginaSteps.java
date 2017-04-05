package steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.SauceUtils;
import utils.SeleniumUtils;

public class AccesoPaginaSteps {

WebDriver driver; 
	
	@Before
	public void run()
	{
		driver = SauceUtils.getDriver();	
	}
	
	@After
	public void end()
	{
		//Cerramos el navegador
		driver.quit();
	}
	
	@When("^un usuario cualquiera accede a la aplicacion$")
	public void i_login_with_name_and_password_alcalde(String name, String password) throws Throwable {
		driver.get("http://localhost:8090");	
		Thread.sleep(10000);
		SeleniumUtils.textoPresentePagina(driver, "Login");

	}

	@Then("^el usuario se encuentra con la pantalla de login$")
	public void i_receive_a_welcome_message_alcalde() throws Throwable {
		SeleniumUtils.textoPresentePagina(driver, "Login");
		SeleniumUtils.textoPresentePagina(driver, "Email");
		SeleniumUtils.textoPresentePagina(driver, "Password");
	}
}
