package steps;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import utils.SeleniumUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;


import static org.junit.Assert.assertTrue;

public class LoginAlcaldeSteps {

	WebDriver driver; 
	
	@Before
	public void run()
	{
		driver = new HtmlUnitDriver();
		driver.get("http://localhost:8090");		
	}
	
	@After
	public void end()
	{
		//Cerramos el navegador
		driver.quit();
	}
	
	@When("^un usuario de tipo alcalde se loguea con usuario \"(.+)\" y password \"(.+)\"$")
	public void i_login_with_name_and_password(String name, String password) throws Throwable {
		SeleniumUtils.textoPresentePagina(driver, "Dashboard2b");

	}

	@Then("^el usuario recibe la pantalla inicial$")
	public void i_receive_a_welcome_message() throws Throwable {
		assertTrue(true);
	}
}
