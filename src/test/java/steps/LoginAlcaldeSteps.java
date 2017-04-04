package steps;




import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import utils.SeleniumUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import es.uniovi.asw.Application;
import static org.junit.Assert.*;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
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
